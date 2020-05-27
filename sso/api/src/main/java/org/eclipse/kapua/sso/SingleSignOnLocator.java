/*******************************************************************************
 * Copyright (c) 2017, 2020 Red Hat Inc and others.
 *
 * All rights reserved. This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Red Hat Inc - initial API and implementation
 *     Eurotech
 *******************************************************************************/
package org.eclipse.kapua.sso;

import org.eclipse.kapua.sso.exception.SsoException;

// TODO: currently two naming conventions are used (SingleSignOn and SSO) with the same meaning, adopt only one

/**
 * SingleSignOn service locator interface.
 */
public interface SingleSignOnLocator {

    /**
     * Retrieve the SSO service.
     *
     * @return a {@link SingleSignOnService} object.
     */
    SingleSignOnService getService();

    /**
     * Retrieve the JwtProcessor.
     *
     * @return a {@link JwtProcessor} object.
     * @throws SsoException if it fails to retrieve the {@link JwtProcessor}.
     */
    JwtProcessor getProcessor() throws SsoException;
}
