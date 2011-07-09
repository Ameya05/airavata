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

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import org.apache.airavata.xbaya.XBayaEngine;
import org.apache.airavata.xbaya.XBayaRuntimeException;
import org.apache.airavata.xbaya.ode.ODEDeploymentDescriptor;
import org.apache.airavata.xbaya.xregistry.XRegistryAccesser;
import org.ogce.xregistry.utils.XRegistryClientException;

public class ExperimentMenu {

    private JMenu experimentMenu;

    private ODEDeploymentDescriptor odeDeploymentDescription;

    protected XRegistryAccesser xregistryAccesser;

    private JMenuItem configureXRegistryItem;

    private JMenuItem loadWorkflowfromXRegistryItem;

    private JMenuItem saveWorkflowtoXRegistryItem;

    private JMenuItem deleteWorkflowfromXRegistryItem;

    private JMenuItem deployWorkflowtoODEItem;

    private JMenuItem launchODEWorkflowItem;

    private JMenuItem launchXBayaInterpreterItem;

    private JMenuItem launchGridChemWorkflowItem;

    private XBayaEngine engine;

    /**
     * Constructs a FileMenu.
     * 
     * @param engine
     * 
     */
    public ExperimentMenu(XBayaEngine engine) {
        this.engine = engine;
        this.odeDeploymentDescription = new ODEDeploymentDescriptor();
        this.xregistryAccesser = new XRegistryAccesser(engine);

        createExperimentMenu();
    }

    private void createExperimentMenu() {

        createConfigureXRegistryItem();
        createLoadWorkflowfromXRegistryItem();
        createSaveWorkflowtoXRegistryItem();
        createDeleteWorkflowtoXRegistryItem();
        // createDeployWorkflowtoODEItem();
        // createLaunchODEWorkflowItem();
        createLaunchXBayaInterpreterItem();
        createLaunchGridChemWorkflowItem();

        this.experimentMenu = new JMenu("Experiment");
        this.experimentMenu.setMnemonic(KeyEvent.VK_F);

        this.experimentMenu.add(this.configureXRegistryItem);
        this.experimentMenu.addSeparator();
        this.experimentMenu.add(this.loadWorkflowfromXRegistryItem);
        this.experimentMenu.add(this.saveWorkflowtoXRegistryItem);
        this.experimentMenu.add(this.deleteWorkflowfromXRegistryItem);
        this.experimentMenu.addSeparator();
        this.experimentMenu.add(this.launchXBayaInterpreterItem);
        this.experimentMenu.addSeparator();
        this.experimentMenu.add(this.launchGridChemWorkflowItem);
        // TODO: ODE build has to be improved before it is supported by default.
        // this.experimentMenu.addSeparator();
        // this.experimentMenu.add(this.deployWorkflowtoODEItem);
        // this.experimentMenu.add(this.launchODEWorkflowItem);
    }

    /**
     * @return The Experiment menu.
     */
    public JMenu getMenu() {
        return this.experimentMenu;
    }

    private void createConfigureXRegistryItem() {
        this.configureXRegistryItem = new JMenuItem("Configure XRegistry");
        configureXRegistryItem.setMnemonic(KeyEvent.VK_C);
        configureXRegistryItem.addActionListener(new AbstractAction() {
            private XRegistryConfigurationWindow window;

            public void actionPerformed(ActionEvent e) {
                if (this.window == null) {
                    this.window = new XRegistryConfigurationWindow(ExperimentMenu.this.engine);
                }
                this.window.show();
            }
        });
    }

    private void createLoadWorkflowfromXRegistryItem() {
        this.loadWorkflowfromXRegistryItem = new JMenuItem("Load Workflow from XRegistry");
        this.loadWorkflowfromXRegistryItem.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                new OGCEXRegistryLoaderWindow(ExperimentMenu.this.engine).show();

            }
        });
    }

    private void createSaveWorkflowtoXRegistryItem() {
        this.saveWorkflowtoXRegistryItem = new JMenuItem("Save Workflow to XRegistry");
        this.saveWorkflowtoXRegistryItem.setMnemonic(KeyEvent.VK_C);
        this.saveWorkflowtoXRegistryItem.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                ExperimentMenu.this.xregistryAccesser.saveWorkflow();
            }
        });
    }

    private void createDeleteWorkflowtoXRegistryItem() {
        this.deleteWorkflowfromXRegistryItem = new JMenuItem("Delete Workflows in XRegistry");
        this.deleteWorkflowfromXRegistryItem.addActionListener(new AbstractAction() {
            public void actionPerformed(ActionEvent e) {
                try {
                    ExperimentMenu.this.xregistryAccesser.deleteOGCEWorkflow(ExperimentMenu.this.engine.getWorkflow()
                            .getQname());
                } catch (XRegistryClientException e1) {
                    throw new XBayaRuntimeException(e1);
                }
            }
        });
    }

    // private void createDeployWorkflowtoODEItem() {
    // this.deployWorkflowtoODEItem = new JMenuItem("Deploy Workflow to ODE Engine");
    // deployWorkflowtoODEItem.addActionListener(new AbstractAction() {
    // private OGCEODEDeploymentWindow window;
    //
    // public void actionPerformed(ActionEvent e) {
    //
    // if (this.window == null) {
    // this.window = new OGCEODEDeploymentWindow(
    // ExperimentMenu.this.engine);
    // }
    // try {
    // this.window.show();
    // } catch (Exception e1) {
    // ExperimentMenu.this.engine.getErrorWindow().error(e1);
    // }
    //
    // }
    // });
    // }
    //
    // private void createLaunchODEWorkflowItem() {
    // this.launchODEWorkflowItem = new JMenuItem("Launch Workflow to ODE Engine");
    // launchODEWorkflowItem.addActionListener(new AbstractAction() {
    // private ODEInvokerWindow window;
    //
    // public void actionPerformed(ActionEvent e) {
    // if (this.window == null) {
    // this.window = new ODEInvokerWindow(
    // ExperimentMenu.this.engine);
    // }
    // try {
    // this.window.show();
    // } catch (Exception e1) {
    // ExperimentMenu.this.engine.getErrorWindow().error(e1);
    // }
    //
    // }
    // });
    //
    // }

    private void createLaunchXBayaInterpreterItem() {
        this.launchXBayaInterpreterItem = new JMenuItem("Launch Workflow to XBaya Interpreter Server");
        launchXBayaInterpreterItem.addActionListener(new AbstractAction() {
            private WorkflowInterpreterLaunchWindow window;

            public void actionPerformed(ActionEvent e) {
                if (this.window == null) {
                    this.window = new WorkflowInterpreterLaunchWindow(ExperimentMenu.this.engine);
                }
                try {
                    this.window.show();
                } catch (Exception e1) {
                    ExperimentMenu.this.engine.getErrorWindow().error(e1);
                }

            }
        });
    }

    /**
	 * 
	 */
    private void createLaunchGridChemWorkflowItem() {
        this.launchGridChemWorkflowItem = new JMenuItem("Launch Workflow and Register with GridChem");
        // TODO Add the following operations
        // First Call OGCE-GridChem-Bridge Service to register an experiment
        // Set lead context header with all the required notifier context
        // call launch workflow

    }
}