/*******************************************************************************
 * Copyright (c) 2017, 2020 Eurotech and/or its affiliates and others
 *
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *     Red Hat Inc
 *******************************************************************************/
package org.eclipse.kapua.service.device.management.commons.message.request;

import org.eclipse.kapua.message.internal.KapuaMessageImpl;
import org.eclipse.kapua.service.device.management.message.request.KapuaRequestChannel;
import org.eclipse.kapua.service.device.management.message.request.KapuaRequestMessage;
import org.eclipse.kapua.service.device.management.message.request.KapuaRequestPayload;
import org.eclipse.kapua.service.device.management.message.response.KapuaResponseMessage;

public class KapuaRequestMessageImpl<C extends KapuaRequestChannel, P extends KapuaRequestPayload> extends KapuaMessageImpl<C, P> implements KapuaRequestMessage<C, P> {

    private static final long serialVersionUID = 1L;

    @SuppressWarnings("rawtypes")
    @Override
    public Class<KapuaRequestMessage> getRequestClass() {
        return KapuaRequestMessage.class;
    }

    @SuppressWarnings("rawtypes")
    @Override
    public Class<KapuaResponseMessage> getResponseClass() {
        return KapuaResponseMessage.class;
    }
}
