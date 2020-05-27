/*******************************************************************************
 * Copyright (c) 2020 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.service.authentication.credential.mfa;

import org.eclipse.kapua.model.KapuaUpdatableEntityAttributes;

/**
 * {@link MfaOption} predicates used to build query predicates.
 */
public class MfaOptionAttributes extends KapuaUpdatableEntityAttributes {

    public static final String USER_ID = "userId";
    public static final String MFA_SECRET_KEY = "mfaSecretKey";

}
