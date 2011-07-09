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

package org.apache.airavata.xbaya.lead;

import java.net.URI;

import org.apache.airavata.xbaya.XBayaConfiguration;
import org.apache.airavata.xbaya.XBayaConstants;
import org.apache.airavata.xbaya.monitor.MonitorConfiguration;
import org.apache.airavata.xbaya.mylead.MyLeadConfiguration;
import org.apache.airavata.xbaya.util.WSDLUtil;
import org.apache.airavata.xbaya.wf.Workflow;

import wsmg.WseClientAPI;
import xsul.lead.LeadContextHeader;
import xsul.ws_addressing.WsaEndpointReference;

public class LeadContextHeaderHelper {

    /**
     * DEFAULT_USER
     */
    private static final String DEFAULT_USER = "xbaya-user";

    /**
     * DEFAULT_EXPERIMENT
     */
    private static final String DEFAULT_EXPERIMENT = "xbaya-experiment";

    private LeadContextHeader leadContextHeader;

    /**
     * Constructs a LeadContextHeaderHelper.
     * 
     */
    public LeadContextHeaderHelper() {
        // The default experiment and user will be will be overwritten.
        this.leadContextHeader = new LeadContextHeader(DEFAULT_EXPERIMENT, DEFAULT_USER);
    }

    /**
     * @return The leadContextHeader.
     */
    public LeadContextHeader getLeadContextHeader() {
        return this.leadContextHeader;
    }

    /**
     * @param user
     */
    public void setUser(String user) {
        if (user == null || user.length() == 0) {
            user = DEFAULT_USER;
        }
        this.leadContextHeader.setUserDn(user);
    }

    /**
     * @param workflowTemplateID
     */
    public void setWorkflowTemplateID(URI workflowTemplateID) {
        if (workflowTemplateID != null) {
            this.leadContextHeader.setWorkflowTemplateId(workflowTemplateID);
        }
    }

    /**
     * @param workflowInstanceID
     */
    public void setWorkflowInstanceID(URI workflowInstanceID) {
        if (workflowInstanceID != null) {
            this.leadContextHeader.setWorkflowInstanceId(workflowInstanceID);
        }
    }

    /**
     * @param myLeadAgentURL
     */
    public void setMyLeadAgentURL(URI myLeadAgentURL) {
        if (myLeadAgentURL != null) {
            this.leadContextHeader.setMyleadAgentUrl(WSDLUtil.appendWSDLQuary(myLeadAgentURL));
        }
    }

    /**
     * @param brokerURL
     * @param topic
     */
    public void setEventSink(URI brokerURL, String topic) {
        if (brokerURL != null) {
            if (topic == null || topic.length() == 0) {
                topic = XBayaConstants.DEFAULT_TOPIC;
            }
            WsaEndpointReference eventSink = WseClientAPI.createEndpointReference(brokerURL.toString(), topic);
            this.leadContextHeader.setEventSink(eventSink);
        }
    }

    /**
     * @param xRegistryURL
     */
    public void setXRegistryURL(URI xRegistryURL) {
        if (xRegistryURL != null) {
            this.leadContextHeader.setXRegistryUrl(WSDLUtil.appendWSDLQuary(xRegistryURL));
        }
    }

    /**
     * @param gFacURL
     */
    public void setGFacURL(URI gFacURL) {
        if (gFacURL != null) {
            this.leadContextHeader.setGfacUrl(WSDLUtil.appendWSDLQuary(gFacURL));
        }
    }

    //
    // The followings are higer-level APIs.
    //

    /**
     * @param workflow
     */
    public void setWorkflow(Workflow workflow) {
        if (workflow != null) {
            setWorkflowTemplateID(workflow.getGPELTemplateID());
            setWorkflowInstanceID(workflow.getGPELInstanceID());
        }
    }

    /**
     * @param myleadConfiguration
     */
    public void setMyLeadConfiguration(MyLeadConfiguration myleadConfiguration) {
        setUser(myleadConfiguration.getUser());
        setMyLeadAgentURL(myleadConfiguration.getURL());
    }

    /**
     * @param monitorConfiguration
     */
    public void setMonitorConfiguration(MonitorConfiguration monitorConfiguration) {
        setEventSink(monitorConfiguration.getBrokerURL(), monitorConfiguration.getTopic());
    }

    /**
     * This method has to be called before setMyLeadConfiguration() or setMonitorConfiguration because this will
     * overwrite some variables.
     * 
     * @param xbayaConfiguration
     */
    public void setXBayaConfiguration(XBayaConfiguration xbayaConfiguration) {
        setXRegistryURL(xbayaConfiguration.getXRegistryURL());
        setGFacURL(xbayaConfiguration.getGFacURL());

        // The followings might overwrite some variables.
        setWorkflowTemplateID(xbayaConfiguration.getGPELTemplateID());
        setWorkflowInstanceID(xbayaConfiguration.getGPELInstanceID());
        setUser(xbayaConfiguration.getMyLeadUser());
        setMyLeadAgentURL(xbayaConfiguration.getMyLeadAgentURL());
        setEventSink(xbayaConfiguration.getBrokerURL(), xbayaConfiguration.getTopic());
    }

}