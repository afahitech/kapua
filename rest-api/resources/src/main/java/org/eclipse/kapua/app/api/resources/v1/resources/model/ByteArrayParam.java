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
 *     Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.app.api.resources.v1.resources.model;

import org.eclipse.kapua.model.xml.BinaryXmlAdapter;

import javax.annotation.Nullable;
import java.util.Base64;

/**
 * This class is used to deserialize a {@link Byte}[] {@link javax.ws.rs.QueryParam} from a {@link Base64} encoded {@link String} to a {@link Byte[]}
 *
 * @since 1.0.0
 */
public class ByteArrayParam extends BinaryXmlAdapter {

    private byte[] value;

    /**
     * This converts a {@link Base64} encoded {@link String} to a {@link Byte}[]
     *
     * @param base64encoded The {@link Base64} encoded  {@link String} representation of the {@link Byte}[].
     * @since 1.0.0
     */
    public ByteArrayParam(@Nullable String base64encoded) {
        value = super.unmarshal(base64encoded);
    }

    /**
     * Gets the converted {@link Byte}[]
     *
     * @return the converted {@link Byte}[]
     */
    public byte[] getValue() {
        return value;
    }
}
