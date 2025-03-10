/*******************************************************************************
 * Copyright (c) 2017, 2021 Eurotech and/or its affiliates and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.broker.core.plugin;

import org.eclipse.kapua.KapuaException;

public class KapuaIllegalDeviceStateException extends KapuaException {

    private static final long serialVersionUID = 1751650664486096457L;

    public KapuaIllegalDeviceStateException(KapuaBrokerErrorCodes errorCode, String clientId) {
        super(errorCode, clientId);
    }

}