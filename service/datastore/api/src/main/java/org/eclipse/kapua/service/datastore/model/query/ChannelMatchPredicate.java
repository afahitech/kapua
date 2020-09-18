/*******************************************************************************
 * Copyright (c) 2016, 2020 Eurotech and/or its affiliates and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.service.datastore.model.query;

import org.eclipse.kapua.service.storable.model.query.predicate.StorablePredicate;

/**
 * Query predicate definition for matching the channel value
 *
 * @since 1.0
 */
public interface ChannelMatchPredicate extends StorablePredicate {

    /**
     * Get the channel expression (may use wildcard)
     *
     * @return
     */
    String getExpression();
}
