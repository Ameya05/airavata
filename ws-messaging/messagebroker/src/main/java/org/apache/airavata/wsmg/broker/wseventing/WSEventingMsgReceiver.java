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

package org.apache.airavata.wsmg.broker.wseventing;

import org.apache.airavata.wsmg.broker.AbstractBrokerMsgReceiver;
import org.apache.airavata.wsmg.broker.context.ProcessingContext;
import org.apache.airavata.wsmg.commons.WsmgCommonConstants;
import org.apache.airavata.wsmg.config.WsmgConfigurationContext;
import org.apache.airavata.wsmg.util.WsEventingOperations;
import org.apache.axis2.AxisFault;
import org.apache.axis2.context.MessageContext;
import org.apache.log4j.Logger;

/**
 * BrokerServiceMessageReceiverInOut message receiver
 */

public class WSEventingMsgReceiver extends AbstractBrokerMsgReceiver {

    org.apache.log4j.Logger log = Logger.getLogger(WSEventingMsgReceiver.class);
    WSEProcessingContextBuilder builder = new WSEProcessingContextBuilder();

    public MessageContext process(MessageContext inMsg, String operationName) throws AxisFault {

        WsEventingOperations msgType = WsEventingOperations.valueFrom(operationName);

        ProcessingContext processingContext = builder.build(inMsg, msgType);

        MessageContext outputMsg = null;

        switch (msgType) {
        case SUBSCRIBE: {

            WsmgConfigurationContext brokerConfigContext = (WsmgConfigurationContext) inMsg.getConfigurationContext()
                    .getProperty(WsmgCommonConstants.BROKER_WSMGCONFIG);

            brokerConfigContext.getSubscriptionManager().subscribe(processingContext);
            outputMsg = createOutputMessageContext(inMsg, processingContext);
        }
            break;
        case UNSUBSCRIBE: {

            WsmgConfigurationContext brokerConfigContext = (WsmgConfigurationContext) inMsg.getConfigurationContext()
                    .getProperty(WsmgCommonConstants.BROKER_WSMGCONFIG);

            brokerConfigContext.getSubscriptionManager().unsubscribe(processingContext);
            outputMsg = createOutputMessageContext(inMsg, processingContext);
        }
            break;
        case RENEW:
            // throw AxisFault.makeFault("unsupported operation" +
            // msgType.toString());
            break;
        case GET_STATUS:
            // nothing to do
            break;
        case SUBSCRIPTION_END:
            // nothing to do
            break;

        }

        return outputMsg;
    }

}// end of class
