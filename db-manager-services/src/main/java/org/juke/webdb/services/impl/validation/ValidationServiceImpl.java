package org.juke.webdb.services.impl.validation;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.juke.webdb.dto.AccountDto;
import org.juke.webdb.services.exceptions.ClientException;
import org.juke.webdb.services.exceptions.EmptyRequestException;
import org.juke.webdb.services.validation.ValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * @author Serhii Kryvtsov
 * @since 10/14/2015.
 */
@Named
@Singleton
public class ValidationServiceImpl implements ValidationService {
    private final static Logger LOGGER = LoggerFactory.getLogger(ValidationServiceImpl.class);

    @Override
    public void assertRequestNotEmpty(Object obj) throws ClientException {
        if (obj == null) {
            throw new EmptyRequestException();
        }
    }

    @Override
    public void assertAccountCreationDtoValid(AccountDto accountDto) throws ClientException {
        assertRequestNotEmpty(accountDto);
        if (StringUtils.isBlank(accountDto.getEmail())) {
            throw new ClientException("Email should not be empty");
        }
        if (StringUtils.isBlank(accountDto.getPassword())) {
            throw new ClientException("Password should not be empty");
        }
        if (!EmailValidator.getInstance().isValid(accountDto.getEmail())) {
            LOGGER.debug("Invalid email: {}", accountDto.getEmail());
            throw new ClientException("Not valid email");
        }
    }
}
