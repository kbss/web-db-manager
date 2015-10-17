package org.juke.webdb.services.exceptions;

/**
 * @author Serhii Kryvtsov
 * @since 10/14/2015.
 */
public class UnauthorizedException extends ClientException {
    private static final int STATUS = 401;

    private static final String MESSAGE = "Unauthorized";

    public UnauthorizedException() {
        super(MESSAGE);
    }

    public UnauthorizedException(String message) {
        super(message);
    }

    @Override
    public int getStatus() {
        return STATUS;
    }
}
