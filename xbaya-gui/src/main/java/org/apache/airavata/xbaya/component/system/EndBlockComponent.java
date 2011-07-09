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

package org.apache.airavata.xbaya.component.system;

import org.apache.airavata.xbaya.component.ComponentControlPort;
import org.apache.airavata.xbaya.component.ComponentPort;
import org.apache.airavata.xbaya.graph.Graph;
import org.apache.airavata.xbaya.graph.Node;
import org.apache.airavata.xbaya.graph.system.EndBlockNode;

public class EndBlockComponent extends SystemComponent {

    /**
     * The name of the const component
     */
    public static final String NAME = "EndBlock";

    // TODO
    private static final String DESCRIPTION = "TODO";

    private static final String INPUT_PORT_NAME = "Input";

    private static final String INPUT_PORT_DESCRIPTION = "This port can be connected to any type.";

    private static final String OUTPUT_PORT_NAME = "Output";

    // TODO
    private static final String OUTPUT_PORT_DESCRIPTION = "";

    private SystemComponentDataPort inputPort;

    private SystemComponentDataPort outputPort;

    /**
     * Creates an InputComponent.
     */
    public EndBlockComponent() {
        super();
        setName(NAME);
        setDescription(DESCRIPTION);

        this.inputPort = new SystemComponentDataPort(INPUT_PORT_NAME);
        this.inputPort.setDescription(INPUT_PORT_DESCRIPTION);
        this.inputs.add(this.inputPort);
        this.inputs.add(this.inputPort);

        this.outputPort = new SystemComponentDataPort(OUTPUT_PORT_NAME);
        this.outputPort.setDescription(OUTPUT_PORT_DESCRIPTION);
        this.outputs.add(this.outputPort);

        this.controlInPort = new ComponentControlPort();
        this.controlOutPorts.add(new ComponentControlPort());
    }

    /**
     * Returns the input component port.
     * 
     * This method is used by EndifNode to create additional output port.
     * 
     * @return The input component port.
     */
    public SystemComponentDataPort getInputPort() {
        return this.inputPort;
    }

    /**
     * @see org.apache.airavata.xbaya.component.Component#getInputPort(int)
     */
    @Override
    public ComponentPort getInputPort(int index) {
        // This method is called during the parsing to bind port to a component
        // port. Since the number of output ports in a endif node dynamically
        // changes, we overwrite it.
        return getInputPort();
    }

    /**
     * Returns the input component port.
     * 
     * This method is used by EndifNode to create additional output port.
     * 
     * @return The output component port.
     */
    public SystemComponentDataPort getOutputPort() {
        return this.outputPort;
    }

    /**
     * @see org.apache.airavata.xbaya.component.Component#getOutputPort(int)
     */
    @Override
    public ComponentPort getOutputPort(int index) {
        // This method is called during the parsing to bind port to a component
        // port. Since the number of output ports in a endif node dynamically
        // changes, we overwrite it.
        return getOutputPort();
    }

    /**
     * @see org.apache.airavata.xbaya.component.Component#createNode(org.apache.airavata.xbaya.graph.Graph)
     */
    @Override
    public Node createNode(Graph graph) {
        EndBlockNode node = new EndBlockNode(graph);

        node.setName(NAME);
        node.setComponent(this);

        // Creates a unique ID for the node. This has to be after setName().
        node.createID();

        createPorts(node);

        return node;
    }
}