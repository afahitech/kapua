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
package org.eclipse.kapua.message;

import org.eclipse.kapua.KapuaSerializable;

/**
 * {@link Message} definition.
 *
 * @param <C> channel type
 * @param <P> payload type
 * @since 1.0.0
 */
public interface Message<C extends Channel, P extends Payload> extends KapuaSerializable {

}
