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
package org.eclipse.kapua.service.authentication.token.shiro;

import org.eclipse.kapua.commons.model.query.AbstractKapuaQuery;
import org.eclipse.kapua.model.id.KapuaId;
import org.eclipse.kapua.service.authentication.token.AccessTokenQuery;

/**
 * Access token query implementation.
 *
 * @since 1.0
 */
public class AccessTokenQueryImpl extends AbstractKapuaQuery implements AccessTokenQuery {

    /**
     * Constructor
     */
    private AccessTokenQueryImpl() {
        super();
    }

    /**
     * Constructor
     *
     * @param scopeId
     */
    public AccessTokenQueryImpl(KapuaId scopeId) {
        this();
        setScopeId(scopeId);
    }
}
