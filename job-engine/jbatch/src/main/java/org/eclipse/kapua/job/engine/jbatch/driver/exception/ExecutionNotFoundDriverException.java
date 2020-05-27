/*******************************************************************************
 * Copyright (c) 2018, 2020 Eurotech and/or its affiliates and others
 *
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.job.engine.jbatch.driver.exception;

public class ExecutionNotFoundDriverException extends JbatchDriverException {

    public ExecutionNotFoundDriverException(String jobName) {
        this(null, jobName);
    }

    public ExecutionNotFoundDriverException(Throwable t, String jobName) {
        super(JbatchDriverErrorCodes.JOB_EXECUTION_NOT_FOUND, t, jobName);
    }
}
