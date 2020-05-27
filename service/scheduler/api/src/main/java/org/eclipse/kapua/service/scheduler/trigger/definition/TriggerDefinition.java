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
package org.eclipse.kapua.service.scheduler.trigger.definition;

import org.eclipse.kapua.model.KapuaNamedEntity;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * {@link TriggerDefinition} definition.
 *
 * @since 1.1.0
 */
@XmlRootElement(name = "triggerDefinition")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(factoryClass = TriggerDefinitionXmlRegistry.class, factoryMethod = "newTriggerDefinition")
public interface TriggerDefinition extends KapuaNamedEntity {

    String TYPE = "triggerDefinition";

    @Override
    default String getType() {
        return TYPE;
    }

    /**
     * Gets the {@link TriggerType}.
     *
     * @return The {@link TriggerType}.
     * @since 1.1.0
     */
    TriggerType getTriggerType();

    /**
     * Sets the {@link TriggerType}.
     *
     * @param triggerType The {@link TriggerType}.
     * @since 1.1.0
     */
    void setTriggerType(TriggerType triggerType);

    /**
     * Sets the processor name.
     *
     * @return The processor name.
     * @since 1.1.0
     */
    String getProcessorName();

    /**
     * Sets the processor name.
     *
     * @param processorName The processor name.
     * @since 1.1.0
     */
    void setProcessorName(String processorName);

    /**
     * Gets the {@link TriggerProperty}s.
     *
     * @return The {@link TriggerProperty}s.
     * @since 1.1.0
     */
    List<TriggerProperty> getTriggerProperties();

    /**
     * Sets the {@link TriggerProperty}s.
     *
     * @param triggerProperties The {@link TriggerProperty}s.
     * @since 1.1.0
     */
    void setTriggerProperties(List<TriggerProperty> triggerProperties);

}
