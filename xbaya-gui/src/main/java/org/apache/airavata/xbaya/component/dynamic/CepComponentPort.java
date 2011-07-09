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

package org.apache.airavata.xbaya.component.dynamic;

import javax.xml.namespace.QName;

import org.apache.airavata.xbaya.component.ComponentDataPort;
import org.apache.airavata.xbaya.graph.DataPort;
import org.apache.airavata.xbaya.graph.dynamic.CepPort;
import org.apache.airavata.xbaya.util.WSConstants;

public class CepComponentPort extends ComponentDataPort {

    private CepComponent component;

    public CepComponentPort(CepComponent component) {
        super();
        this.component = component;
        this.type = WSConstants.XSD_ANY_TYPE;
    }

    /**
     * @see org.apache.airavata.xbaya.component.ComponentDataPort#createPort()
     */
    @Override
    public DataPort createPort() {
        CepPort port = new CepPort();
        port.setComponentPort(this);

        return port;
    }

    public void setType(QName type) {
        this.type = type;
    }

    /**
     * Returns the component.
     * 
     * @return The component
     */
    public CepComponent getComponent() {
        return this.component;
    }

}