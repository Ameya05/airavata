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

package org.apache.airavata.xbaya.monitor;

import java.net.URI;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.airavata.xbaya.XBayaException;
import org.apache.airavata.xbaya.event.Event;
import org.apache.airavata.xbaya.event.Event.Type;
import org.apache.airavata.xbaya.event.EventProducer;
import org.apache.airavata.xbaya.monitor.KarmaClient.Rate;
import org.xmlpull.infoset.XmlElement;

import xsul5.MLogger;

public class Monitor extends EventProducer {

    protected static final MLogger logger = MLogger.getLogger();

    protected MonitorConfiguration configuration;

    protected static String DEFAULT_MODEL_KEY = "_DEFAULT_MODEL_KEY";

    protected Map<String, MonitorEventData> eventDataMap = new HashMap<String, MonitorEventData>();

    protected WsmgClient wsmgClient;

    /**
     * Constructs a Monitor.
     * 
     * @param configuration
     */
    public Monitor(MonitorConfiguration configuration) {
        this.configuration = configuration;
        // The first one is special and it is for the main event panel display
        // and
        // it does not have and filters
        this.eventDataMap.put(DEFAULT_MODEL_KEY, new MonitorEventData());

    }

    /**
     * @return The configuration
     */
    public MonitorConfiguration getConfiguration() {
        return this.configuration;
    }

    /**
     * @return The event data;
     */
    public MonitorEventData getEventData() {
        // send the first one cos that is the default one
        return this.eventDataMap.get(DEFAULT_MODEL_KEY);
    }

    /**
     * @return The event data;
     */
    public MonitorEventData getEventData(String nodeID) {
        // send the first one cos that is the default one
        return this.eventDataMap.get(nodeID);
    }

    /**
     * @throws MonitorException
     */
    public synchronized void start() throws MonitorException {
        // Stop the previous monitoring if any.
        asynchronousStop();

        subscribe();

        if (null != this.configuration.getInteractiveNodeIDs()) {
            List<String> interactiveNodeIDs = this.configuration.getInteractiveNodeIDs();
            // now add models for this as well
            for (String string : interactiveNodeIDs) {

                final String nodeID = string;
                // for each wsnode there is one data model which
                this.eventDataMap.put(nodeID, new MonitorEventData(new EventFilter() {
                    /**
                     * @see org.apache.airavata.xbaya.monitor.EventFilter#isAcceptable(org.apache.airavata.xbaya.monitor.MonitorEvent)
                     */
                    public boolean isAcceptable(MonitorEvent event) {
                        return event != null && event.getNodeID() != null && event.getNodeID().equals(nodeID);
                    }
                }));
            }

        }
    }

    /**
     * @param kermaURL
     * @param workflowInstanceID
     * @param rate
     */
    public synchronized void startKarma(URI kermaURL, URI workflowInstanceID, Rate rate) {
        KarmaClient karma = new KarmaClient(this, kermaURL, workflowInstanceID, rate);
        karma.start();

        // Enable/disable some menu items and show the monitor panel.
        sendSafeEvent(new Event(Type.KARMA_STARTED));
    }

    /**
     * Stops monitoring.
     */
    public synchronized void asynchronousStop() {
        if (this.wsmgClient != null) {
            // To make thread safe.
            final WsmgClient client = this.wsmgClient;
            this.wsmgClient = null;

            // Users don't need to know the end of unsubscription.
            new Thread() {
                @Override
                public void run() {
                    try {
                        unsubscribe(client);
                    } catch (XBayaException e) {
                        // Ignore the error in unsubscription.
                        logger.caught(e);
                    }
                }
            }.start();
        }
    }

    /**
     * Stops monitoring without using a thread.
     * 
     * @throws MonitorException
     */
    public synchronized void stop() throws MonitorException {
        if (this.wsmgClient != null) {
            unsubscribe(this.wsmgClient);
            this.wsmgClient = null;
        }
    }

    /**
     * Resets the graph and clear the monitoring table. Remove all the extra tablemodels available
     */
    public void reset() {
        Set<String> keys = this.eventDataMap.keySet();
        LinkedList<String> keysToBeRemoved = new LinkedList<String>();
        // Remove everthing leaving only the last one
        for (String key : keys) {
            MonitorEventData monitorEventData = this.eventDataMap.get(key);
            monitorEventData.removeAllEvents();
            if (!key.equals(DEFAULT_MODEL_KEY)) {
                keysToBeRemoved.add(key);
            }
        }
        for (String key : keysToBeRemoved) {
            this.eventDataMap.remove(key);
        }

    }

    /**
     * @param event
     */
    public synchronized void handleNotification(XmlElement event) {
        Set<String> keys = this.eventDataMap.keySet();
        // Remove everthing leaving only the last one
        for (String key : keys) {
            this.eventDataMap.get(key).addEvent(event);
        }
    }

    private void subscribe() throws MonitorException {
        this.wsmgClient = new WsmgClient(this);
        this.wsmgClient.subscribe();

        // Enable/disable some menu items and show the monitor panel.
        sendSafeEvent(new Event(Type.MONITOR_STARTED));
    }

    private void unsubscribe(WsmgClient client) throws MonitorException {
        // Enable/disable some menu items.
        sendSafeEvent(new Event(Type.MONITOR_STOPED));

        client.unsubscribe();
    }

}