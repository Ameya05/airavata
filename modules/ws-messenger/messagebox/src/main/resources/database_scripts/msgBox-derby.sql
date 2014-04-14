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

CREATE TABLE MSGBOXES (
  MSGBOXID VARCHAR(100) NOT NULL DEFAULT '',
  PRIMARY KEY  (MSGBOXID)
); 

CREATE TABLE MSGBOX (
  ID INTEGER NOT NULL GENERATED BY DEFAULT AS IDENTITY,
  CONTENT BLOB,
  MSGBOXID VARCHAR(100) NOT NULL DEFAULT '',
  MESSAGEID VARCHAR(100) DEFAULT '',
  SOAPACTION VARCHAR(100) DEFAULT '',
  TIME TIMESTAMP ,
  PRIMARY KEY  (ID))
;

CREATE TRIGGER MESSAGE_TIME
  AFTER INSERT ON MSGBOX
  REFERENCING NEW AS NEW
  FOR EACH ROW MODE DB2SQL
    UPDATE MSGBOX SET TIME = CURRENT_TIMESTAMP WHERE ID = NEW.ID;
