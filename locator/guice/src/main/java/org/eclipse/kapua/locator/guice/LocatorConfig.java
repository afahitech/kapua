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
package org.eclipse.kapua.locator.guice;

import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.XMLConfiguration;
import org.eclipse.kapua.locator.KapuaLocatorErrorCodes;
import org.eclipse.kapua.locator.KapuaLocatorException;

public class LocatorConfig {

    private static final String SERVICE_RESOURCE_INTERFACES = "provided.api";
    private static final String SERVICE_RESOURCE_INCLUDED_PACKAGES = "packages.package";
    private static final String SERVICE_RESOURCE_EXCLUDED_PACKAGES = "packages.excludes.package";

    private final URL url;
    private final List<String> includedPkgNames;
    private final List<String> excludedPkgNames;
    private final List<String> providedInterfaceNames;

    private LocatorConfig(final URL url, final List<String> includedPkgNames, final List<String> excludedPkgNames, final List<String> providedInterfaceNames) {
        this.url = url;
        this.includedPkgNames = includedPkgNames;
        this.excludedPkgNames = excludedPkgNames;
        this.providedInterfaceNames = providedInterfaceNames;
    }

    public static LocatorConfig fromURL(final URL url) throws KapuaLocatorException {

        if (url == null) {
            throw new IllegalArgumentException("'url' must not be null");
        }

        final List<String> includedPkgNames = new ArrayList<>();
        final List<String> excludedPkgNames = new ArrayList<>();
        final List<String> providedInterfaceNames = new ArrayList<>();

        final XMLConfiguration xmlConfig;
        try {
            xmlConfig = new XMLConfiguration(url);
        } catch (ConfigurationException e) {
            throw new KapuaLocatorException(KapuaLocatorErrorCodes.INVALID_CONFIGURATION, e);
        }

        Object props = xmlConfig.getProperty(SERVICE_RESOURCE_INCLUDED_PACKAGES);
        if (props instanceof Collection<?>) {
            addAllStrings(includedPkgNames, (Collection<?>) props);
        }
        if (props instanceof String) {
            includedPkgNames.add((String) props);
        }

        props = xmlConfig.getProperty(SERVICE_RESOURCE_EXCLUDED_PACKAGES);
        if (props instanceof Collection<?>) {
            addAllStrings(excludedPkgNames, (Collection<?>) props);
        }
        if (props instanceof String) {
            excludedPkgNames.add((String) props);
        }

        props = xmlConfig.getProperty(SERVICE_RESOURCE_INTERFACES);
        if (props instanceof Collection<?>) {
            addAllStrings(providedInterfaceNames, (Collection<?>) props);
        }
        if (props instanceof String) {
            providedInterfaceNames.add((String) props);
        }

        return new LocatorConfig(url, Collections.unmodifiableList(includedPkgNames), Collections.unmodifiableList(excludedPkgNames), Collections.unmodifiableList(providedInterfaceNames));
    }

    private static void addAllStrings(final List<String> list, Collection<?> other) {
        for (Object entry : other) {
            if (entry instanceof String) {
                list.add((String) entry);
            }
        }
    }

    public URL getURL() {
        return url;
    }

    public Collection<String> getIncludedPackageNames() {
        return includedPkgNames;
    }

    public Collection<String> getExcludedPackageNames() {
        return excludedPkgNames;
    }

    public Collection<String> getProvidedInterfaceNames() {
        return providedInterfaceNames;
    }
}
