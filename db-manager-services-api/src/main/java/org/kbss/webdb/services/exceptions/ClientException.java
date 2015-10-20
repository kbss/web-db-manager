package org.kbss.webdb.services.exceptions;

/**
 * @author Serhii Kryvtsov
 * @since 14/10/2015.
 */
public class ClientException extends ServiceException {
    private static final int STATUS = 400;
    private static final String ERROR_CODE = "CL";

    public ClientException(String message) {
        super(message);
    }

    public ClientException() {
        super();
    }

    @Override
    public String getErrorCode() {
        return ERROR_CODE;
    }

    @Override
    public int getStatus() {
        return STATUS;
    }
}
