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

package org.apache.airavata.xbaya.experiment.gui;

import javax.xml.namespace.QName;

import org.apache.airavata.xbaya.gui.TableRenderable;

import xregistry.generated.FindAppDescResponseDocument.FindAppDescResponse.AppData;
import xregistry.generated.HostDescData;
import xregistry.generated.OGCEResourceData;
import xregistry.generated.ServiceDescData;

public class OGCEXRegistrySearchResult implements TableRenderable {

    private static String[] columnName = { "Name", "Description" };

    private QName qname;

    private QName resourceID;

    private String resourceName;

    private String description;

    private OGCEResourceData data;

    /**
     * Constructs a XRSearchResult.
     * 
     * @param resourceID
     * @param description
     * @param val
     */
    public OGCEXRegistrySearchResult(OGCEResourceData val) {
        this.qname = val.getName();
        this.resourceID = val.getResourceID();
        this.resourceName = val.getResourceName();
        this.description = val.getResourceDesc();
        this.data = val;
    }

    /**
     * Constructs a OGCEXRegistrySearchResult.
     * 
     * @param val
     */

    public OGCEXRegistrySearchResult(Object val) {
        if (val instanceof HostDescData) {
            this.qname = ((HostDescData) val).getName();
            this.resourceID = new QName(((HostDescData) val).getResourceID());
            this.description = ((HostDescData) val).getOwner();
            this.resourceName = ((HostDescData) val).getName().toString();
        } else if (val instanceof AppData) {
            this.qname = ((AppData) val).getName();
            this.resourceID = new QName(((AppData) val).getResourceID());
            this.description = ((AppData) val).getHostName();
            this.resourceName = ((AppData) val).getName().getLocalPart().toString();
        } else if (val instanceof ServiceDescData) {
            this.qname = ((ServiceDescData) val).getName();
            this.resourceID = new QName(((ServiceDescData) val).getResourceID());
            this.description = ((ServiceDescData) val).getOwner();
            this.resourceName = ((ServiceDescData) val).getName().getLocalPart().toString();
        }
    }

    /**
     * Returns the qname.
     * 
     * @return The resourceID
     */
    public QName getQname() {
        return this.qname;
    }

    /**
     * Returns the resourceId.
     * 
     * @return The resourceID
     */
    public QName getResourceId() {
        return this.resourceID;
    }

    /**
     * Returns the description.
     * 
     * @return The description
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * Returns the resourceName.
     * 
     * @return The resourceName
     */
    public String getResourceName() {
        return this.resourceName;
    }

    /**
     * Returns the data.
     * 
     * @return The data
     */
    public OGCEResourceData getData() {
        return this.data;
    }

    /**
     * @see org.apache.airavata.xbaya.gui.TableRenderable#getColumnCount()
     */
    @Override
    public int getColumnCount() {
        return 2;
    }

    /**
     * @see org.apache.airavata.xbaya.gui.TableRenderable#getColumnTitle(int)
     */
    @Override
    public String getColumnTitle(int index) {
        return columnName[index];
    }

    /**
     * @see org.apache.airavata.xbaya.gui.TableRenderable#getValue(int)
     */
    @Override
    public Object getValue(int index) {
        switch (index) {
        case 0:
            return getResourceName();
        case 1:
            return getDescription();
        default:
            return null;
        }
    }

}