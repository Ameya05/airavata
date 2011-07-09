/*
 * Copyright (c) 2009 Extreme! Lab, Indiana University. All rights reserved.
 *
 * This software is open source. See the bottom of this file for the license.
 *
 * $Id: $
 */
package org.apache.airavata.xbaya.xsd;

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

/**
 * @author Chathura Herath
 */
public class LeadContextHeaderXSD {

    public static final String XSD = "<schema\n"
            + "    targetNamespace='http://lead.extreme.indiana.edu/namespaces/2005/10/lead-context-header'\n"
            + "    xmlns:lead='http://lead.extreme.indiana.edu/namespaces/2005/10/lead-context-header'\n"
            + "    xmlns='http://www.w3.org/2001/XMLSchema'\n"
            + "    xmlns:lrm='http://lead.extreme.indiana.edu/namespaces/2006/lead-resource-mapping/'\n"
            + "    attributeFormDefault='qualified'\n"
            + "    elementFormDefault='qualified'>\n"
            + "    <element name='experiment-id' type='string'>\n"
            + "      <annotation><documentation xml:lang='en'>\n"
            + "        Experiment ID. (REQUIRED in context)\n"
            + "      </documentation></annotation>\n"
            + "    </element>\n"
            + "    <element name='workflow-instance-id' type='anyURI'>\n"
            + "      <annotation><documentation xml:lang='en'>\n"
            + "        URI that identifies workflow instance that originated that message. (optional)\n"
            + "      </documentation></annotation>\n"
            + "    </element>\n"
            + "    <element name='workflow-template-id' type='anyURI'>\n"
            + "      <annotation><documentation xml:lang='en'>\n"
            + "        URI that identifies workflow template that was used to create this workflow instance. (optional)\n"
            + "      </documentation></annotation>\n"
            + "    </element>\n"
            + "    <element name='workflow-node-id' type='string'>\n"
            + "      <annotation><documentation xml:lang='en'>\n"
            + "        String that identifies uniqueley a node in workflow graph that originated that message. (optional)\n"
            + "      </documentation></annotation>\n"
            + "    </element>\n"
            + "    <element name='workflow-time-step' type='int'>\n"
            + "      <annotation><documentation xml:lang='en'>\n"
            + "        Increasing integer representing time in the workflow execution when the message originated. (optional)\n"
            + "      </documentation></annotation>\n"
            + "    </element>\n"
            + "    <element name='service-instance-id' type='anyURI'>\n"
            + "      <annotation><documentation xml:lang='en'>\n"
            + "        URI that identifies service instance that originated that message. (optional)\n"
            + "      </documentation></annotation>\n"
            + "    </element>\n"
            + "    <element name='service-replica-id' type='anyURI'>\n"
            + "      <annotation><documentation xml:lang='en'>\n"
            + "        URI that identifies the replica of service instance that originated that message, primarly used by FTR service to overprovision. (optional)\n"
            + "      </documentation></annotation>\n"
            + "    </element>\n"
            + "    <element name='gfac-url' type='anyURI'>\n"
            + "      <annotation><documentation xml:lang='en'>\n"
            + "        Location of GFac factory service to use. (optional)\n"
            + "      </documentation></annotation>\n"
            + "    </element>\n"
            + "    <element name='dsc-url' type='anyURI'>\n"
            + "      <annotation><documentation xml:lang='en'>\n"
            + "        Location of DSC service to use. (optional)\n"
            + "      </documentation></annotation>\n"
            + "    </element>\n"
            + "    <element name='resource-broker-url' type='anyURI'>\n"
            + "      <annotation><documentation xml:lang='en'>\n"
            + "        Location of Resource Broker Service to use. (optional)\n"
            + "      </documentation></annotation>\n"
            + "    </element>\n"
            + "    <element name='resource-scheduler' type='string'>\n"
            + "      <annotation><documentation xml:lang='en'>\n"
            + "        Resource Scheduler to use among LEAD, VGRADS and SPRUCE. (optional)\n"
            + "      </documentation></annotation>\n"
            + "    </element>\n"
            + "    <element name='properties-file-url' type='anyURI'>\n"
            + "      <annotation><documentation xml:lang='en'>\n"
            + "        Location of properties file used by some of LEAD services to override namelist defaults. (optional)\n"
            + "      </documentation></annotation>\n"
            + "    </element>\n"
            + "    <element name='mylead-agent-url' type='anyURI'>\n"
            + "      <annotation><documentation xml:lang='en'>\n"
            + "        Location of MyLEAD Agent\n"
            + "      </documentation></annotation>\n"
            + "    </element>\n"
            + "    <element name='scms-url' type='anyURI'>\n"
            + "      <annotation><documentation xml:lang='en'>\n"
            + "        Location of the SCMS (Session Credential Management Service).\n"
            + "      </documentation></annotation>\n"
            + "    </element>\n"
            + "   <element name='execution-session-id' type='string'>\n"
            + "      <annotation><documentation xml:lang='en'>\n"
            + "        The ID of the session credential to be used for executing grid operations as needed\n"
            + "        by the workflow.\n"
            + "      </documentation></annotation>\n"
            + "    </element>\n"
            + "    <element name='event-sink-epr'>\n"
            + "      <annotation><documentation xml:lang='en'>\n"
            + "        EPR for WS-Eventing sink where to send event.  (optional)\n"
            + "        NOTE: currently any XML is accepted as there are many versions of WS-Addressing.\n"
            + "      </documentation></annotation>\n"
            + "      <complexType>\n"
            + "        <sequence>\n"
            + "          <any namespace='##any' processContents='lax' minOccurs='0' maxOccurs='unbounded' />\n"
            + "        </sequence>\n"
            + "      </complexType>\n"
            + "    </element>\n"
            + "    <element name='error-sink-epr'>\n"
            + "      <annotation><documentation xml:lang='en'>\n"
            + "        EPR for WS-Eventing sink where to send errors (optional)\n"
            + "        NOTE: designed good for debugging and system level warnings, errors, etc\n"
            + "      </documentation></annotation>\n"
            + "      <complexType>\n"
            + "        <sequence>\n"
            + "          <any namespace='##any' processContents='lax' minOccurs='0' maxOccurs='unbounded' />\n"
            + "        </sequence>\n"
            + "      </complexType>\n"
            + "    </element>\n"
            + "    <element name='user-dn' type='string'>\n"
            + "      <annotation><documentation xml:lang='en'>\n"
            + "        String that identifies user running this experiment. (REQUIRED in context\n"
            + "      </documentation></annotation>\n"
            + "    </element>\n"
            + "    <element name='URGENCY' type='string'>\n"
            + "      <annotation><documentation xml:lang='en'>\n"
            + "        Spruce urgency parameter\n"
            + "      </documentation></annotation>\n"
            + "    </element>\n"
            + "    <element name='ForceFileStagingToWorkDir' type='string'>\n"
            + "      <annotation><documentation xml:lang='en'>\n"
            + "       ForceFileStagingToWorkDir (optinal)\n"
            + "      </documentation></annotation>\n"
            + "    </element>\n"
            + "    <element name='OUTPUT_DATA_DIRECTORY' type='anyURI'>\n"
            + "      <annotation>\n"
            + "        <documentation xml:lang='en'>\n"
            + "          GFac output data staging directory. (optional)\n"
            + "        </documentation>\n"
            + "      </annotation>\n"
            + "    </element>\n"
            + "    <element name='OPENDAP_DIRECTORY' type='anyURI'>\n"
            + "      <annotation>\n"
            + "        <documentation xml:lang='en'>\n"
            + "          Prefix for data staged by GFac so it can be accessed via\n"
            + "          OpenDap. (optional)\n"
            + "        </documentation>\n"
            + "      </annotation>\n"
            + "    </element>\n"
            + "    <element name='OUTPUT_DATA_FILES_SUFFIX' type='string'>\n"
            + "      <annotation>\n"
            + "        <documentation xml:lang='en'>\n"
            + "          Suffix (file extension in most cases) to be added to a file\n"
            + "          staged to OUTPUT_DATA_DIRECTORY. (optional)\n"
            + "        </documentation>\n"
            + "      </annotation>\n"
            + "    </element>\n"
            + "    <element name='context'>\n"
            + "      <annotation><documentation xml:lang='en'>\n"
            + "        Element that contains LEAD specific context information sent as a SOAP header in a SOAP message.\n"
            + "      </documentation></annotation>\n" + "      <complexType>\n" + "        <sequence>\n"
            + "          <element minOccurs='1' maxOccurs='1' ref='lead:experiment-id'/>\n"
            + "          <any namespace='##any' processContents='lax' minOccurs='0' maxOccurs='unbounded' />\n"
            + "         <element minOccurs='0' maxOccurs='1' ref='lead:workflow-instance-id'/>\n"
            + "          <element minOccurs='0' maxOccurs='1' ref='lead:workflow-node-id'/>\n"
            + "          <element minOccurs='0' maxOccurs='1' ref='lead:workflow-time-step'/>\n"
            + "         </sequence>\n" + "      </complexType>\n" + "   </element>\n" + "</schema>\n";

    /**
     * @return
     */
    public static String getXml() {
        // TODO Auto-generated method stub
        return XSD;
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
