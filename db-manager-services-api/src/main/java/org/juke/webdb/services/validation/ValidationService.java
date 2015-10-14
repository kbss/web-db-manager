package org.juke.webdb.services.validation;

import org.juke.webdb.services.exceptions.ClientException;

/**
 * @author Serhii Kryvtsov
 * @since 10/14/2015.
 */
public interface ValidationService {
    void assertRequestNotEmpty(Object obj) throws ClientException;
}
