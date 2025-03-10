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
 *******************************************************************************/
package org.eclipse.kapua;

import javax.validation.constraints.NotNull;
import java.util.Locale;

/**
 * The {@link KapuaException} is the superclass of exceptions in Kapua project.
 * <p>
 * It extends the JDK Exception class by requesting its invokers to provide an error code when building its instances.
 * <p>
 * The code is one value of {@link KapuaErrorCode}. The code is used to document the possible error conditions generated by the platform as well as to identify the localized
 * exception messages to be reported.
 * <p>
 * Exceptions messages are stored in the KapuaExceptionMessagesBundle Properties Bundle and they are keyed on the exception code.
 *
 * @since 1.0.0
 */
public class KapuaException extends Exception {

    private static final long serialVersionUID = -2911004777156433206L;

    private static final String KAPUA_ERROR_MESSAGES = "kapua-service-error-messages";

    private final KapuaErrorCode code;
    private final Object[] args;

    /**
     * Constructor.
     *
     * @param code The {@link KapuaErrorCode} associated with the {@link Exception}
     * @since 1.0.0
     */
    public KapuaException(@NotNull KapuaErrorCode code) {
        this(code, (Object[]) null);
    }

    /**
     * Constructor.
     *
     * @param code      The {@link KapuaErrorCode} associated with the {@link Exception}.
     * @param arguments The arguments associated with the {@link Exception}.
     * @since 1.0.0
     */
    public KapuaException(@NotNull KapuaErrorCode code, Object... arguments) {
        this(code, null, arguments);
    }

    /**
     * Constructor.
     *
     * @param code      The {@link KapuaErrorCode} associated with the {@link Exception}.
     * @param cause     The original {@link Throwable}.
     * @param arguments The arguments associated with the {@link Exception}.
     * @since 1.0.0
     */
    public KapuaException(@NotNull KapuaErrorCode code, Throwable cause, Object... arguments) {
        super(cause);

        this.code = code;
        this.args = arguments;
    }

    /**
     * Factory method to build a {@link KapuaException} with the {@link KapuaErrorCodes#INTERNAL_ERROR}.
     *
     * @param cause   The original {@link Throwable}.
     * @param message The message associated with the {@link Exception}.
     * @return A {@link KapuaException} with {@link KapuaErrorCodes#INTERNAL_ERROR}.
     * @since 1.0.0
     */
    public static KapuaException internalError(@NotNull Throwable cause, String message) {
        return new KapuaException(KapuaErrorCodes.INTERNAL_ERROR, cause, message);
    }

    /**
     * Factory method to build a {@link KapuaException} with the {@link KapuaErrorCodes#INTERNAL_ERROR}.
     *
     * @param cause The original {@link Throwable}.
     * @return A {@link KapuaException} with {@link KapuaErrorCodes#INTERNAL_ERROR}.
     * @since 1.0.0
     */
    public static KapuaException internalError(@NotNull Throwable cause) {
        String arg = cause.getMessage();
        if (arg == null) {
            arg = cause.getClass().getName();
        }
        return new KapuaException(KapuaErrorCodes.INTERNAL_ERROR, cause, arg);
    }

    /**
     * Factory method to build a {@link KapuaException} with the {@link KapuaErrorCodes#INTERNAL_ERROR}.
     *
     * @param message The message associated with the {@link Exception}.
     * @return A {@link KapuaException} with {@link KapuaErrorCodes#INTERNAL_ERROR}.
     * @since 1.0.0
     */
    public static KapuaException internalError(@NotNull String message) {
        return new KapuaException(KapuaErrorCodes.INTERNAL_ERROR, null, message);
    }

    //
    // Getters
    //

    /**
     * Gets the {@link java.util.ResourceBundle} name from which to source the error messages for {@link KapuaException}s.
     *
     * @return The {@link java.util.ResourceBundle} name.
     * @since 1.0.0
     */
    protected String getKapuaErrorMessagesBundle() {
        return KAPUA_ERROR_MESSAGES;
    }

    /**
     * Gets the {@link KapuaErrorCode}.
     *
     * @return The {@link KapuaErrorCode}.
     * @since 1.0.0
     */
    public KapuaErrorCode getCode() {
        return code;
    }

    /**
     * Gets the arguments.
     *
     * @return The arguments.
     * @since 1.0.0
     */
    private Object[] getArgs() {
        return args;
    }

    //
    // Exception messages.
    //

    /**
     * Gets the defined message by the {@link #getCode()}.
     * <p>
     * It uses {@link ExceptionMessageUtils#getLocalizedMessage(String, Locale, KapuaErrorCode, Object[])} using {@link Locale#US}.
     *
     * @see ExceptionMessageUtils#getLocalizedMessage(String, Locale, KapuaErrorCode, Object[])
     * @since 1.0.0
     */
    @Override
    public String getMessage() {
        return ExceptionMessageUtils.getLocalizedMessage(getKapuaErrorMessagesBundle(), Locale.US, getCode(), getArgs());
    }

    /**
     * Gets the defined message by the {@link #getCode()}.
     * <p>
     * It uses {@link ExceptionMessageUtils#getLocalizedMessage(String, Locale, KapuaErrorCode, Object[])} using {@link Locale#getDefault()}.
     *
     * @see ExceptionMessageUtils#getLocalizedMessage(String, Locale, KapuaErrorCode, Object[])
     * @since 1.0.0
     */
    @Override
    public String getLocalizedMessage() {
        return ExceptionMessageUtils.getLocalizedMessage(getKapuaErrorMessagesBundle(), Locale.getDefault(), getCode(), getArgs());
    }
}
