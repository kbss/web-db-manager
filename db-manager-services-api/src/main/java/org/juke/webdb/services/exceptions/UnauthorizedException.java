package org.juke.webdb.services.exceptions;

/**
 * @author Serhii Kryvtsov
 * @since 10/14/2015.
 */
public class UnauthorizedException extends ClientException {
    private static final int STATUS = 401;

    @Override
    public int getStatus() {
        return STATUS;
    }
}
