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

package org.apache.airavata.xbaya.jython.runner;

import java.io.File;
import java.security.AccessController;
import java.security.PrivilegedActionException;
import java.security.PrivilegedExceptionAction;
import java.util.jar.JarFile;

import org.apache.airavata.xbaya.XBayaException;
import org.python.core.PySystemState;
import org.python.util.PythonInterpreter;

import xsul5.MLogger;

public class JythonOneTimeRunnerImpl implements JythonOneTimeRunner {

    private static final MLogger logger = MLogger.getLogger();

    /**
     * @throws XBayaException
     * @see org.apache.airavata.xbaya.jython.runner.JythonOneTimeRunner#run(java.lang.String, java.lang.String[])
     */
    public void run(final String script, final String[] arguments) throws XBayaException {

        try {
            AccessController.doPrivileged(new PrivilegedExceptionAction<Void>() {
                public Void run() {
                    ClassLoader loader = this.getClass().getClassLoader();

                    PySystemState.initialize(System.getProperties(), null, arguments, loader);

                    if (loader instanceof JythonClassLoader) {
                        logger.info("jythonClassLoader");
                        JythonClassLoader jythonLoader = (JythonClassLoader) loader;

                        JarFile xbayaJarFile = jythonLoader.getXBayaJarFile();
                        if (xbayaJarFile != null) {
                            String jarPath = xbayaJarFile.getName();
                            logger.finest("jarPath: " + jarPath);
                            // String jarDir = jarPath.substring(0,
                            // jarPath.lastIndexOf());
                            File jarFile = new File(jarPath);
                            String jarDir = jarFile.getParent();
                            logger.finest("jarDir: " + jarDir);

                            // This is for the Jython interpreter to
                            // solve import statements.
                            PySystemState.add_extdir(jarDir);
                        }
                    }

                    PythonInterpreter interpreter = new PythonInterpreter();
                    interpreter.exec(script);
                    return null;
                }
            });
        } catch (PrivilegedActionException e) {
            logger.caught(e);
            throw new XBayaException(e.getCause());
        }

    }

}