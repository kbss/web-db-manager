package org.juke.webdb.services.exceptions;

/**
 * @author Serhii Kryvtsov
 * @since 14/10/2015.
 */
public class ClientException extends ServiceException {
    private static final int STATUS = 400;

    @Override
    public int getStatus() {
        return STATUS;
    }
}
