/*******************************************************************************
 * Copyright (c) 2016, 2021 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.commons.core;

import com.google.inject.AbstractModule;

public abstract class AbstractKapuaModule extends AbstractModule {

    public AbstractKapuaModule() {}

    @Override
    protected final void configure() {
        configureModule();
    }

    protected abstract void configureModule();
}
