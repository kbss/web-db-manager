package org.juke.webdb.services.impl.validation;

import org.juke.webdb.services.exceptions.ClientException;
import org.juke.webdb.services.exceptions.EmptyRequestException;
import org.juke.webdb.services.validation.ValidationService;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * @author Serhii Kryvtsov
 * @since 10/14/2015.
 */
@Named
@Singleton
public class ValidationServiceImpl implements ValidationService {
    @Override
    public void assertRequestNotEmpty(Object obj) throws ClientException {
        if (obj == null) {
            throw new EmptyRequestException();
        }
    }
}
