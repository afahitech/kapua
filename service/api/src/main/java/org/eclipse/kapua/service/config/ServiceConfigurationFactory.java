/*******************************************************************************
 * Copyright (c) 2019, 2020 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.service.config;

import org.eclipse.kapua.model.KapuaObjectFactory;

/**
 * Service configuration entity service factory definition.
 *
 * @since 1.0
 */
public interface ServiceConfigurationFactory extends KapuaObjectFactory {

    /**
     * Creates a new {@link ServiceComponentConfiguration} using the given component configuration identifier
     *
     * @return
     */
    ServiceComponentConfiguration newComponentConfigurationInstance(String componentConfigurationId);

    /**
     * Creates a new {@link ServiceConfiguration}
     *
     * @return
     */
    ServiceConfiguration newConfigurationInstance();
}
