/*
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 *
 */

package org.apache.airavata.wsmg.msgbox.Storage.DB_Pool;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import javax.xml.stream.XMLStreamException;

import org.apache.axiom.om.OMElement;
import org.apache.axis2.AxisFault;
import org.apache.log4j.Logger;

public class MessageBoxDB {

    static Logger logger = Logger.getLogger(MessageBoxDB.class);

    private static Set<String> msgBoxids;

    public static final String SELECT_ALL_FROM_MSGBOXES = "SELECT * FROM msgBoxes";

    private static JdbcStorage db;

    public static String SQL_STORE_MESSAGE_STATEMENT = "INSERT INTO msgbox (xml, msgboxid, messageid,soapaction) VALUES (?,?,?,?)";

    public static String SQL_CREATE_MSGBOX_STATEMENT = "INSERT INTO %s (msgboxid) VALUES ('%s')";

    public static String SQL_DELETE_ALL_STATEMENT = "DELETE FROM %s WHERE msgboxid='%s'";

    public static String SQL_SELECT_STATEMENT1 = "SELECT * FROM %s WHERE msgboxid='%s' ORDER BY '%s' DESC";

    public static String SQL_DELETE_ANCIENT_STATEMENT = "DELETE FROM %s WHERE time <'%s'";

    public MessageBoxDB(JdbcStorage db) {
        this.db = db;
    }

    public static void createMsgBx(String messageBoxId, String tableName) throws SQLException, IOException {
        if (!msgBoxids.contains(messageBoxId)) {
            Connection connection = db.connect();
            Statement statement = connection.createStatement();
            statement.execute(String.format(SQL_CREATE_MSGBOX_STATEMENT, tableName, messageBoxId));
            connection.commit();
            db.closeConnection(connection);
            msgBoxids.add(messageBoxId);
        } else
            throw new AxisFault("The message box ID requested already exists");
    }

    public static void addMessage(String msgBoxID, String messageID, String soapAction, OMElement message)
            throws SQLException, IOException, XMLStreamException {
        if (msgBoxids.contains(msgBoxID)) {
            Connection connection = db.connect();
            PreparedStatement stmt = connection.prepareStatement(SQL_STORE_MESSAGE_STATEMENT);
            byte[] buffer;
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(output);
            out.writeObject(message.toStringWithConsume());
            buffer = output.toByteArray();
            ByteArrayInputStream in = new ByteArrayInputStream(buffer);
            stmt.setBinaryStream(1, in, buffer.length);
            stmt.setString(2, msgBoxID);
            stmt.setString(3, messageID);
            stmt.setString(4, soapAction);
            db.insert(stmt);
            stmt.close();
            connection.commit();
            db.closeConnection(connection);
        } else {
            throw new AxisFault("Currently a messagebox is not available with given message box id :" + msgBoxID);
        }
    }

    public static void deleteMessageBox(String msgBoxId) throws SQLException {

        if (msgBoxids.contains(msgBoxId)) {
            Connection connection = db.connect();
            Statement statement = connection.createStatement();
            statement.execute(String.format(SQL_DELETE_ALL_STATEMENT, "msgbox", msgBoxId));
            statement.execute(String.format(SQL_DELETE_ALL_STATEMENT, "msgBoxes", msgBoxId));
            db.closeConnection(connection);
            msgBoxids.remove(msgBoxId);
        }
    }

    public static List<String> removeAllMessagesforClient(String msgBoxId) throws SQLException, IOException,
            ClassNotFoundException, XMLStreamException {
        LinkedList<String> list = new LinkedList<String>();
        if (msgBoxids.contains(msgBoxId)) {
            Connection connection = db.connect();

            PreparedStatement stmt = connection.prepareStatement(String.format(SQL_SELECT_STATEMENT1, "msgbox",
                    msgBoxId, String.format("%s.%s", "msgbox", "id")));
            ResultSet resultSet = stmt.executeQuery();
            resultSet.beforeFirst();

            while (resultSet.next()) {
                InputStream in = resultSet.getAsciiStream("xml");
                ObjectInputStream s = new ObjectInputStream(in);
                String xmlString = (String) s.readObject();
                System.out.println(xmlString);
                list.addFirst(xmlString);
            }
            resultSet.close();
            stmt.close();
            stmt = connection.prepareStatement(String.format(SQL_DELETE_ALL_STATEMENT, "msgbox", msgBoxId));
            db.insert(stmt);
            stmt.close();
            connection.commit();
            db.closeConnection(connection);
        }
        return list;
    }

    public static void removeAncientMessages() {
        try {
            Connection connection = db.connect();
            long interval = db.getInterval();
            long persevetime = (System.currentTimeMillis() - interval);
            PreparedStatement stmt = connection.prepareStatement(String.format(SQL_DELETE_ANCIENT_STATEMENT, "msgBox",
                    persevetime));
            db.insert(stmt);
            stmt.close();
            db.closeConnection(connection);
        } catch (SQLException e) {
            logger.fatal("Caught exception while removing old entries from msgbox db table", e);
        }

    }

    public static void setJdbcStorage(JdbcStorage db2) throws SQLException {
        db = db2;
        setMsgBoxidList();

    }

    private static void setMsgBoxidList() throws SQLException {
        msgBoxids = Collections.synchronizedSet(new HashSet<String>());
        Connection connection = db.connect();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(SELECT_ALL_FROM_MSGBOXES);
        while (resultSet.next()) {
            msgBoxids.add(resultSet.getString("msgboxid"));
        }
        statement.close();
        connection.commit();
        db.closeConnection(connection);
    }

}
