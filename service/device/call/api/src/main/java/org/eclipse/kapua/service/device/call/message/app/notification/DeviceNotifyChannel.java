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
package org.eclipse.kapua.service.device.call.message.app.notification;

import org.eclipse.kapua.service.device.call.message.app.DeviceAppChannel;

/**
 * {@link DeviceNotifyChannel} definition.
 *
 * @since 1.0.0
 */
public interface DeviceNotifyChannel extends DeviceAppChannel {

    /**
     * Gets the notification resources.
     *
     * @return The notification resources.
     * @since 1.2.0
     */
    String[] getResources();

    /**
     * Sets the notification resources.
     *
     * @param resources The notification resources.
     * @since 1.2.0
     */
    void setResources(String[] resources);

}
