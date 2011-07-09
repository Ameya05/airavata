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

package org.apache.airavata.xbaya.gridftp;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.globus.ftp.DataSink;
import org.globus.ftp.DataSinkStream;
import org.globus.ftp.DataSource;
import org.globus.ftp.DataSourceStream;
import org.globus.ftp.GridFTPClient;
import org.globus.ftp.Marker;
import org.globus.ftp.MarkerListener;
import org.globus.ftp.exception.ClientException;
import org.globus.ftp.exception.ServerException;
import org.ietf.jgss.GSSCredential;

public class GridFtpClient implements MarkerListener {

    public void upload(File file, String directory, String remoteFile, GSSCredential credential) {
        try {
            GridFTPClient gridFTPClient = new GridFTPClient("", 9393);
            gridFTPClient.authenticate(credential);
            DataSource source = new DataSourceStream(new FileInputStream(file));
            if (null != directory) {
                gridFTPClient.changeDir(directory);
            }
            gridFTPClient.extendedPut(remoteFile, source, this);
        } catch (ServerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void downloadFile(String remoteFileName, String directory, GSSCredential credential, OutputStream out) {
        try {
            GridFTPClient gridFTPClient = new GridFTPClient("", 9393);
            gridFTPClient.authenticate(credential);
            gridFTPClient.changeDir(directory);
            DataSink sink = new DataSinkStream(out);
            gridFTPClient.get(remoteFileName, sink, this);
        } catch (ServerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ClientException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    /**
     * @see org.globus.ftp.MarkerListener#markerArrived(org.globus.ftp.Marker)
     */
    public void markerArrived(Marker arg0) {
        // TODO Auto-generated method stub

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
