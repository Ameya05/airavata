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

package org.apache.airavata.xbaya.graph.system;

import org.apache.airavata.xbaya.component.system.BlockComponent;
import org.apache.airavata.xbaya.graph.Graph;
import org.apache.airavata.xbaya.graph.GraphException;
import org.apache.airavata.xbaya.graph.GraphSchema;
import org.apache.airavata.xbaya.graph.gui.NodeGUI;
import org.apache.airavata.xbaya.graph.system.gui.BlockNodeGUI;
import org.xmlpull.infoset.XmlElement;

public class BlockNode extends SystemNode {

    // private static final MLogger logger = MLogger.getLogger();

    private BlockNodeGUI gui;

    /**
     * Creates a InputNode.
     * 
     * @param graph
     */
    public BlockNode(Graph graph) {
        super(graph);
    }

    /**
     * Constructs an IfNode.
     * 
     * @param nodeElement
     * @throws GraphException
     */
    public BlockNode(XmlElement nodeElement) throws GraphException {
        super(nodeElement);
    }

    /**
     * @see org.apache.airavata.xbaya.graph.Node#getGUI()
     */
    public NodeGUI getGUI() {
        if (this.gui == null) {
            this.gui = new BlockNodeGUI(this);
        }
        return this.gui;
    }

    /**
     * @see org.apache.airavata.xbaya.graph.impl.NodeImpl#getComponent()
     */
    @Override
    public BlockComponent getComponent() {
        BlockComponent component = (BlockComponent) super.getComponent();
        if (component == null) {
            // The component is null when read from the graph XML.
            component = new BlockComponent();
            setComponent(component);
        }
        return component;
    }

    @Override
    protected XmlElement toXML() {
        XmlElement nodeElement = super.toXML();
        nodeElement.setAttributeValue(GraphSchema.NS, GraphSchema.NODE_TYPE_ATTRIBUTE, GraphSchema.NODE_TYPE_IF);
        return nodeElement;
    }

}