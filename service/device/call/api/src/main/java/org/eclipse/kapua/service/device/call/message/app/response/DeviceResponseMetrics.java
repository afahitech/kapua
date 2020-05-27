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
 *      Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.service.device.call.message.app.response;

import org.eclipse.kapua.service.device.call.message.DeviceMetrics;

/**
 * {@link DeviceResponseMetrics} definition.
 *
 * @since 1.0.0
 */
public interface DeviceResponseMetrics extends DeviceMetrics {

    /**
     * Gets the value of this {@link DeviceResponseMetrics}.
     *
     * @return The value of this {@link DeviceResponseMetrics}.
     * @since 1.0.0
     * @deprecated Since 1.2.0. Renamed to {@link #getName()}.
     */
    @Deprecated
    String getValue();
}
