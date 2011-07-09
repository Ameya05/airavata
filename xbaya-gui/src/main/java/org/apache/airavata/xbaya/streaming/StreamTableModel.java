/*
 * Copyright (c) 2009 Extreme! Lab, Indiana University. All rights reserved.
 *
 * This software is open source. See the bottom of this file for the license.
 *
 * $Id: $
 */
package org.apache.airavata.xbaya.streaming;

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

import java.net.MalformedURLException;

import javax.swing.table.AbstractTableModel;

import org.apache.airavata.xbaya.XBayaConstants;
import org.apache.airavata.xbaya.XBayaEngine;
import org.apache.airavata.xbaya.streaming.StreamServiceStub.StreamDescription;

/**
 * @author Chathura Herath
 */
public class StreamTableModel extends AbstractTableModel {

    private String[] columnNames = { "", "Stream", "Rate", "Last evetn Time", "message" };
    private Object[][] data;
    private XBayaEngine engine;
    private StreamDescription[] streams;

    public StreamTableModel(XBayaEngine engine) {
        this.engine = engine;

    }

    /**
     * @throws XregistryException
     * @throws MalformedURLException
     */
    public void init() {

        try {
            StreamServiceStub stub = new StreamServiceStub(XBayaConstants.STREAM_SERVER);
            streams = stub.getStreams(50);

            this.data = new Object[streams.length][columnNames.length];
            for (int i = 0; i < streams.length; i++) {
                this.data[i][0] = i;
                this.data[i][1] = streams[i].getStreamName();
                this.data[i][2] = streams[i].getRate().replace(':', '|');
                this.data[i][3] = streams[i].getLastEventTimestamp();
                this.data[i][4] = streams[i].getMessage();

            }
        } catch (Exception e) {
            engine.getErrorWindow().error(e);
        }

    }

    /**
     * @see javax.swing.table.TableModel#getColumnCount()
     */
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return columnNames.length;
    }

    /**
     * @see javax.swing.table.TableModel#getRowCount()
     */
    public int getRowCount() {
        // TODO Auto-generated method stub
        return data.length;
    }

    /**
     * @see javax.swing.table.TableModel#getValueAt(int, int)
     */
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        return data[rowIndex][columnIndex];
    }

    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    /**
     * @param row
     */
    public void stopStream(int row) {
        // TODO Auto-generated method stub

    }

    /**
     * @param row
     * @return
     */
    public String getStream(int row) {
        return (String) this.data[row][1];
    }

    /**
     * @param row
     * @return
     */
    public String getStreamRate(int row) {
        return (String) this.data[row][2];
    }

    /**
     * @param newStreamName
     */
    public String getRate(String newStreamName) {
        for (int i = 0; i < data.length; i++) {
            if (this.data[i][1].equals(newStreamName)) {
                return (String) this.data[i][2];
            }
        }
        return "";

    }

}

/*
 * Indiana University Extreme! Lab Software License, Version 1.2
 * 
 * Copyright (c) 2009 The Trustees of Indiana University. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, are permitted provided that the
 * following conditions are met:
 * 
 * 1) All redistributions of source code must retain the above copyright notice, the list of authors in the original
 * source code, this list of conditions and the disclaimer listed in this license;
 * 
 * 2) All redistributions in binary form must reproduce the above copyright notice, this list of conditions and the
 * disclaimer listed in this license in the documentation and/or other materials provided with the distribution;
 * 
 * 3) Any documentation included with all redistributions must include the following acknowledgement:
 * 
 * "This product includes software developed by the Indiana University Extreme! Lab. For further information please
 * visit http://www.extreme.indiana.edu/"
 * 
 * Alternatively, this acknowledgment may appear in the software itself, and wherever such third-party acknowledgments
 * normally appear.
 * 
 * 4) The name "Indiana University" or "Indiana University Extreme! Lab" shall not be used to endorse or promote
 * products derived from this software without prior written permission from Indiana University. For written permission,
 * please contact http://www.extreme.indiana.edu/.
 * 
 * 5) Products derived from this software may not use "Indiana University" name nor may "Indiana University" appear in
 * their name, without prior written permission of the Indiana University.
 * 
 * Indiana University provides no reassurances that the source code provided does not infringe the patent or any other
 * intellectual property rights of any other entity. Indiana University disclaims any liability to any recipient for
 * claims brought by any other entity based on infringement of intellectual property rights or otherwise.
 * 
 * LICENSEE UNDERSTANDS THAT SOFTWARE IS PROVIDED "AS IS" FOR WHICH NO WARRANTIES AS TO CAPABILITIES OR ACCURACY ARE
 * MADE. INDIANA UNIVERSITY GIVES NO WARRANTIES AND MAKES NO REPRESENTATION THAT SOFTWARE IS FREE OF INFRINGEMENT OF
 * THIRD PARTY PATENT, COPYRIGHT, OR OTHER PROPRIETARY RIGHTS. INDIANA UNIVERSITY MAKES NO WARRANTIES THAT SOFTWARE IS
 * FREE FROM "BUGS", "VIRUSES", "TROJAN HORSES", "TRAP DOORS", "WORMS", OR OTHER HARMFUL CODE. LICENSEE ASSUMES THE
 * ENTIRE RISK AS TO THE PERFORMANCE OF SOFTWARE AND/OR ASSOCIATED MATERIALS, AND TO THE PERFORMANCE AND VALIDITY OF
 * INFORMATION GENERATED USING SOFTWARE.
 */
