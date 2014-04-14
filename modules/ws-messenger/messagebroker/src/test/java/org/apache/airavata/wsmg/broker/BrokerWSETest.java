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

package org.apache.airavata.wsmg.broker;

import java.io.IOException;
import java.util.Properties;

import junit.framework.TestCase;

import org.apache.airavata.wsmg.client.ConsumerNotificationHandler;
import org.apache.airavata.wsmg.client.WseMsgBrokerClient;
import org.apache.airavata.wsmg.util.TestUtilServer;
import org.apache.axiom.om.impl.llom.util.AXIOMUtil;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axis2.AxisFault;
import org.junit.Test;

public class BrokerWSETest extends TestCase implements ConsumerNotificationHandler {

    private static int port = TestUtilServer.TESTING_PORT;
    static Properties configs = new Properties();

    public void handleNotification(SOAPEnvelope msgEnvelope) {
        System.out.println("Received " + msgEnvelope);
    }

    @Override
    protected void setUp() throws Exception {
        TestUtilServer.start(null, null);
    }

    @Override
    protected void tearDown() throws Exception {
        TestUtilServer.stop();
    }

    @Test
    public void testRoundTrip() throws InterruptedException {

        try {

            String brokerEPR = "http://localhost:" + TestUtilServer.TESTING_PORT + "/axis2/services/EventingService";
            long value = System.currentTimeMillis();
            String msg = String.format("<msg> current time is : %d </msg>", value);

            WseMsgBrokerClient wseMsgBrokerClient = new WseMsgBrokerClient();
            wseMsgBrokerClient.init(brokerEPR);
            int consumerPort = TestUtilServer.getAvailablePort();

            String[] consumerEPRs = wseMsgBrokerClient.startConsumerService(consumerPort, this);

            assertTrue(consumerEPRs.length > 0);

            String topic = "WseRoundTripTestTopic";

            String subscriptionID = wseMsgBrokerClient.subscribe(consumerEPRs[0], topic, null);
            System.out.println("topic sub id = " + subscriptionID);

            try {
                wseMsgBrokerClient.publish(topic, msg);
                wseMsgBrokerClient.publish(topic, AXIOMUtil.stringToOM("<foo><bar>Test</bar></foo>"));
            } catch (Exception e) {
                fail(e.getMessage());
            }

            Thread.sleep(2000);

            try {
                wseMsgBrokerClient.unSubscribe(subscriptionID);
            } catch (AxisFault e) {
                e.printStackTrace();
                fail(e.getMessage());
            }
            wseMsgBrokerClient.shutdownConsumerService();

        } catch (AxisFault e) {
            e.printStackTrace();
            try {
                System.in.read();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            fail("unexpected exception occured");
        }
        System.out.println("Broker roundtrip done");

    }
}
