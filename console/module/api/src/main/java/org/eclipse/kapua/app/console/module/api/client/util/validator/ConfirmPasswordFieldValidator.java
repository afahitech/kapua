/*******************************************************************************
 * Copyright (c) 2017, 2020 Eurotech and/or its affiliates and others
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
package org.eclipse.kapua.app.console.module.api.client.util.validator;

import com.extjs.gxt.ui.client.widget.form.Field;
import com.extjs.gxt.ui.client.widget.form.TextField;
import com.google.gwt.core.client.GWT;

import org.eclipse.kapua.app.console.module.api.client.messages.ValidationMessages;

public class ConfirmPasswordFieldValidator extends PasswordFieldValidator {

    private static final ValidationMessages MSGS = GWT.create(ValidationMessages.class);

    private final TextField<String> passwordField;

    public ConfirmPasswordFieldValidator(TextField<String> confirmPasswordField, TextField<String> passwordField, int minLength) {
        super(confirmPasswordField, minLength);
        this.passwordField = passwordField;
    }

    public String validate(Field<?> field, String value) {
        String result = super.validate(field, value);
        if (result == null && !value.equals(passwordField.getValue())) {
            result = MSGS.passwordDoesNotMatch();
        }
        return result;
    }

}
