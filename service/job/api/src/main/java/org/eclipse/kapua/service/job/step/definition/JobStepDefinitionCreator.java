/*******************************************************************************
 * Copyright (c) 2017, 2019 Eurotech and/or its affiliates and others
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.service.job.step.definition;

import org.eclipse.kapua.model.KapuaNamedEntityCreator;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

/**
 * {@link JobStepDefinitionCreator} {@link org.eclipse.kapua.model.KapuaEntityCreator} definition
 *
 * @since 1.0.0
 */
@XmlRootElement(name = "jobStepDefinitionCreator")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(factoryClass = JobStepDefinitionXmlRegistry.class, factoryMethod = "newJobStepDefinitionCreator")
public interface JobStepDefinitionCreator extends KapuaNamedEntityCreator<JobStepDefinition> {

    JobStepType getStepType();

    void setStepType(JobStepType jobStepType);

    String getReaderName();

    void setReaderName(String readerName);

    String getProcessorName();

    void setProcessorName(String processorName);

    String getWriterName();

    void setWriterName(String writesName);

    List<JobStepProperty> getStepProperties();

    void setStepProperties(List<JobStepProperty> jobStepProperties);
}
