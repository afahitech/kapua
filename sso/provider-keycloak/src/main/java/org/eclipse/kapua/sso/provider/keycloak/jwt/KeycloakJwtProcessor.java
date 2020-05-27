/*******************************************************************************
 * Copyright (c) 2019, 2020 Eurotech and/or its affiliates and others.
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
package org.eclipse.kapua.sso.provider.keycloak.jwt;

import org.apache.commons.collections.CollectionUtils;
import org.eclipse.kapua.sso.exception.SsoException;
import org.eclipse.kapua.sso.exception.SsoIllegalArgumentException;
import org.eclipse.kapua.sso.provider.jwt.AbstractJwtProcessor;
import org.eclipse.kapua.sso.provider.keycloak.KeycloakSingleSignOnUtils;
import org.eclipse.kapua.sso.provider.setting.SsoSetting;
import org.eclipse.kapua.sso.provider.setting.SsoSettingKeys;

import java.util.Collections;
import java.util.List;

/**
 * The Keycloak JWT Processor.
 */
public class KeycloakJwtProcessor extends AbstractJwtProcessor {

    private static final SsoSetting SSO_SETTING = SsoSetting.getInstance();

    public KeycloakJwtProcessor() throws SsoException {
    }

    @Override
    protected List<String> getJwtExpectedIssuers() throws SsoIllegalArgumentException {
        return Collections.singletonList(
                KeycloakSingleSignOnUtils.getProviderUri() + KeycloakSingleSignOnUtils.KEYCLOAK_URI_COMMON_PART +
                        KeycloakSingleSignOnUtils.getRealm());
    }

    @Override
    protected List<String> getJwtAudiences() throws SsoIllegalArgumentException {
        List<String> jwtAudiences = SSO_SETTING.getList(String.class, SsoSettingKeys.SSO_OPENID_CLIENT_ID);
        if (CollectionUtils.isEmpty(jwtAudiences)) {
            throw new SsoIllegalArgumentException(SsoSettingKeys.SSO_OPENID_CLIENT_ID.key(), (jwtAudiences == null ? null : "") );
        }
        return jwtAudiences;
    }
}
