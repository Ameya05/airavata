/*
 * Copyright (c) 2008 Extreme! Lab, Indiana University. All rights reserved.
 *
 * This software is open source. See the bottom of this file for the license.
 *
 * $Id: WorkflowInvoker.java,v 1.1 2008/09/03 18:44:55 cherath Exp $
 */
package org.apache.airavata.xbaya.workflow;

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

import org.apache.airavata.xbaya.XBayaException;

import xsul.wsif.WSIFMessage;

/**
 * @author Chathura Herath
 */
public interface WorkflowInvoker {

    /**
     * Sets up the invoker.
     * 
     * @throws XBayaException
     */
    public abstract void setup() throws XBayaException;

    /**
     * Sets the operation name to invoke.
     * 
     * @param operationName
     *            The name of the operation
     * @throws XBayaException
     */
    public abstract void setOperation(String operationName) throws XBayaException;

    /**
     * Sets an input parameter
     * 
     * @param name
     *            The name of the input parameter
     * @param value
     *            The value of the input parameter
     * @throws XBayaException
     */
    public abstract void setInput(String name, Object value) throws XBayaException;

    /**
     * Invokes the service. This is a non-blocking call.
     * 
     * @throws XBayaException
     */
    public abstract void invoke() throws XBayaException;

    /**
     * Returns the output of a specified name. This method blocks until the execution finishes.
     * 
     * @param name
     *            The name of the output parameter
     * @return The value of the output
     * @throws XBayaException
     */
    public abstract Object getOutput(String name) throws XBayaException;

    public WSIFMessage getOutputs() throws XBayaException;

}

/*
 * Indiana University Extreme! Lab Software License, Version 1.2
 * 
 * Copyright (c) 2008 The Trustees of Indiana University. All rights reserved.
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
