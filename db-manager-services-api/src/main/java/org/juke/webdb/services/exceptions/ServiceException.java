package org.juke.webdb.services.exceptions;

/**
 * @author Serhii Kryvtsov
 * @since 14/10/2015.
 */
public class ServiceException extends RuntimeException {
    private static final int STATUS = 500;


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

    public int getStatus() {
        return STATUS;
    }
}
