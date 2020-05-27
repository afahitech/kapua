/*******************************************************************************
 * Copyright (c) 2016, 2020 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.service.device.call.message.kura.lifecycle;

import org.eclipse.kapua.service.device.call.message.lifecycle.DeviceLifecycleChannel;

/**
 * {@link DeviceLifecycleChannel} {@link org.eclipse.kapua.service.device.call.kura.Kura} implementation.
 *
 * @see KuraBirthMessage
 * @since 1.0.0
 */
public class KuraBirthChannel extends AbstractKuraAppsBirthChannel implements DeviceLifecycleChannel {

    /**
     * Constructor.
     *
     * @param messageClassification The message classification.
     * @param scopeNamespace        The scope namespace.
     * @param clientId              The clientId.
     * @see org.eclipse.kapua.service.device.call.message.DeviceChannel
     * @since 1.0.0
     */
    public KuraBirthChannel(String messageClassification, String scopeNamespace, String clientId) {
        super(messageClassification, scopeNamespace, clientId);
    }

    @Override
    public String getPhase() {
        return "BIRTH";
    }
}
