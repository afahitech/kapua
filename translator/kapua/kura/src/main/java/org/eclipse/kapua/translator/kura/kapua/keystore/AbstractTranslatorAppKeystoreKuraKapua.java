/*******************************************************************************
 * Copyright (c) 2021 Eurotech and/or its affiliates and others
 *
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 *
 * Contributors:
 *     Eurotech - initial API and implementation
 *******************************************************************************/
package org.eclipse.kapua.translator.kura.kapua.keystore;

import org.eclipse.kapua.locator.KapuaLocator;
import org.eclipse.kapua.service.device.call.kura.model.keystore.KeystoreMetrics;
import org.eclipse.kapua.service.device.call.kura.model.keystore.KuraKeystore;
import org.eclipse.kapua.service.device.call.kura.model.keystore.KuraKeystoreItem;
import org.eclipse.kapua.service.device.call.kura.model.keystore.KuraKeystoreSignedCertificate;
import org.eclipse.kapua.service.device.call.message.kura.app.response.KuraResponseChannel;
import org.eclipse.kapua.service.device.call.message.kura.app.response.KuraResponseMessage;
import org.eclipse.kapua.service.device.management.keystore.DeviceKeystoreManagementFactory;
import org.eclipse.kapua.service.device.management.keystore.message.internal.response.KeystoreResponseChannel;
import org.eclipse.kapua.service.device.management.keystore.message.internal.response.KeystoreResponseMessage;
import org.eclipse.kapua.service.device.management.keystore.message.internal.response.KeystoreResponsePayload;
import org.eclipse.kapua.service.device.management.keystore.model.DeviceKeystore;
import org.eclipse.kapua.service.device.management.keystore.model.DeviceKeystoreItem;
import org.eclipse.kapua.service.device.management.keystore.model.DeviceKeystoreItems;
import org.eclipse.kapua.service.device.management.keystore.model.DeviceKeystoreSignedCertificate;
import org.eclipse.kapua.service.device.management.keystore.model.DeviceKeystoreSubjectAN;
import org.eclipse.kapua.service.device.management.keystore.model.DeviceKeystores;
import org.eclipse.kapua.translator.exception.InvalidChannelException;
import org.eclipse.kapua.translator.kura.kapua.AbstractSimpleTranslatorResponseKuraKapua;
import org.eclipse.kapua.translator.kura.kapua.TranslatorKuraKapuaUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Date;
import java.util.stream.Collectors;

/**
 * {@link org.eclipse.kapua.translator.Translator} {@code abstract} implementation from {@link KuraResponseMessage} to {@link KeystoreResponseMessage}
 *
 * @since 1.5.0
 */
public abstract class AbstractTranslatorAppKeystoreKuraKapua<M extends KeystoreResponseMessage> extends AbstractSimpleTranslatorResponseKuraKapua<KeystoreResponseChannel, KeystoreResponsePayload, M> {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractTranslatorAppKeystoreKuraKapua.class);

    private static final KapuaLocator LOCATOR = KapuaLocator.getInstance();

    private final static DeviceKeystoreManagementFactory DEVICE_KEYSTORE_MANAGEMENT_FACTORY = LOCATOR.getFactory(DeviceKeystoreManagementFactory.class);

    /**
     * Constructor.
     *
     * @param responseMessageClass The type of the {@link KeystoreResponseMessage}.
     * @since 1.5.0
     */
    public AbstractTranslatorAppKeystoreKuraKapua(Class<M> responseMessageClass) {
        super(responseMessageClass, KeystoreResponsePayload.class);
    }

    @Override
    protected KeystoreResponseChannel translateChannel(KuraResponseChannel kuraResponseChannel) throws InvalidChannelException {
        try {
            TranslatorKuraKapuaUtils.validateKuraResponseChannel(kuraResponseChannel, KeystoreMetrics.APP_ID, KeystoreMetrics.APP_VERSION);

            return new KeystoreResponseChannel();
        } catch (Exception e) {
            throw new InvalidChannelException(e, kuraResponseChannel);
        }
    }

    /**
     * Translates a {@link KuraKeystore}[] to {@link DeviceKeystores}.
     *
     * @param kuraKeystoreArray The {@link KuraKeystore}[] to translate.
     * @return The translated {@link DeviceKeystores}.
     * @since 1.5.0
     */
    protected DeviceKeystores translate(KuraKeystore[] kuraKeystoreArray) {

        DeviceKeystores deviceKeystores = DEVICE_KEYSTORE_MANAGEMENT_FACTORY.newDeviceKeystores();

        deviceKeystores.setKeystores(
                Arrays.stream(kuraKeystoreArray).map(kuraKeystore -> {
                    DeviceKeystore deviceKeystore = DEVICE_KEYSTORE_MANAGEMENT_FACTORY.newDeviceKeystore();

                    deviceKeystore.setId(kuraKeystore.getKeystoreServicePid());
                    deviceKeystore.setKeystoreType(kuraKeystore.getType());
                    deviceKeystore.setSize(kuraKeystore.getSize());

                    return deviceKeystore;
                }).collect(Collectors.toList())
        );

        return deviceKeystores;
    }

    /**
     * Translates a {@link KuraKeystoreItem}[] to {@link DeviceKeystoreItems}.
     *
     * @param kuraKeystoreItemArray The {@link KuraKeystoreItem}[] to translate.
     * @return The translated {@link DeviceKeystoreItems}.
     * @since 1.5.0
     */
    protected DeviceKeystoreItems translate(KuraKeystoreItem[] kuraKeystoreItemArray) {

        DeviceKeystoreItems deviceKeystoreItems = DEVICE_KEYSTORE_MANAGEMENT_FACTORY.newDeviceKeystoreItems();

        deviceKeystoreItems.setKeystoreItems(
                Arrays.stream(kuraKeystoreItemArray)
                        .map(this::translate)
                        .collect(Collectors.toList())
        );

        return deviceKeystoreItems;
    }

    /**
     * Translates a {@link KuraKeystoreItem}to {@link DeviceKeystoreItems}.
     *
     * @param kuraKeystoreItem The {@link KuraKeystoreItem} to translate.
     * @return The translated {@link DeviceKeystoreItems}.
     * @since 1.5.0
     */
    protected DeviceKeystoreItem translate(KuraKeystoreItem kuraKeystoreItem) {

        DeviceKeystoreItem deviceKeystore = DEVICE_KEYSTORE_MANAGEMENT_FACTORY.newDeviceKeystoreItem();

        deviceKeystore.setKeystoreId(kuraKeystoreItem.getKeystoreServicePid());
        deviceKeystore.setItemType(kuraKeystoreItem.getType());
        deviceKeystore.setSize(kuraKeystoreItem.getSize());
        deviceKeystore.setAlgorithm(kuraKeystoreItem.getAlgorithm());
        deviceKeystore.setAlias(kuraKeystoreItem.getAlias());
        deviceKeystore.setSubjectDN(kuraKeystoreItem.getSubjectDN());
        deviceKeystore.setIssuer(kuraKeystoreItem.getIssuer());
        deviceKeystore.setCertificate(kuraKeystoreItem.getCertificate());
        deviceKeystore.setCertificateChain(kuraKeystoreItem.getCertificateChain());

        for (String[] kuraSubjectAN : kuraKeystoreItem.getSubjectAN()) {
            DeviceKeystoreSubjectAN deviceSubjectAN = DEVICE_KEYSTORE_MANAGEMENT_FACTORY.newDeviceKeystoreSubjectAN();

            if (kuraSubjectAN == null || kuraSubjectAN.length != 2) {
                LOG.warn("Invalid Subject Alternative Names provided from the device: {}", (Object) kuraSubjectAN);
                continue;
            }

            deviceSubjectAN.setANType(kuraSubjectAN[0]);
            deviceSubjectAN.setValue(kuraSubjectAN[1]);

            deviceKeystore.addSubjectAN(deviceSubjectAN);
        }

        if (kuraKeystoreItem.getStartDate() != null) {
            deviceKeystore.setNotBefore(new Date(kuraKeystoreItem.getStartDate()));
        }

        if (kuraKeystoreItem.getExpirationDate() != null) {
            deviceKeystore.setNotAfter(new Date(kuraKeystoreItem.getExpirationDate()));
        }

        return deviceKeystore;
    }

    /**
     * Translates a {@link KuraKeystoreSignedCertificate} to {@link DeviceKeystoreSignedCertificate}.
     *
     * @param kuraKeystoreSignedCertificate The {@link KuraKeystoreSignedCertificate} to translate.
     * @return The translated {@link DeviceKeystoreSignedCertificate}.
     * @since 1.5.0
     */
    protected DeviceKeystoreSignedCertificate translate(KuraKeystoreSignedCertificate kuraKeystoreSignedCertificate) {
        DeviceKeystoreSignedCertificate deviceKeystoreSignedCertificate = DEVICE_KEYSTORE_MANAGEMENT_FACTORY.newDeviceKeystoreSignedCertificate();

        deviceKeystoreSignedCertificate.setSignedCertificate(kuraKeystoreSignedCertificate.getSignedCertificate());

        return deviceKeystoreSignedCertificate;
    }
}
