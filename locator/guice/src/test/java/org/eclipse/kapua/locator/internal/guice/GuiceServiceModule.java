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
 *     Red Hat Inc
 *******************************************************************************/
package org.eclipse.kapua.locator.internal.guice;

import org.eclipse.kapua.KapuaException;
import org.eclipse.kapua.commons.core.ServiceModule;
import org.eclipse.kapua.locator.KapuaProvider;

@KapuaProvider
public class GuiceServiceModule implements ServiceModule {

    @Override
    public void start() throws KapuaException {
        // TODO Auto-generated method stub
    }

    @Override
    public void stop() throws KapuaException {
        // TODO Auto-generated method stub
    }
}
