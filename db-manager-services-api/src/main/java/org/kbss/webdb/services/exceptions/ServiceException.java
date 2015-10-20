package org.kbss.webdb.services.exceptions;

/**
 * @author Serhii Kryvtsov
 * @since 14/10/2015.
 */
public class ServiceException extends RuntimeException {
    private static final int STATUS = 500;
    private static final String ERROR_CODE = "SRV";

    public ServiceException(String message, Throwable t) {
        super(message, t);
    }


    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Throwable t) {
        super(t);
    }

    public ServiceException() {
        super();
    }

    public String getErrorCode() {
        return ERROR_CODE;
    }

    public int getStatus() {
        return STATUS;
    }
}
