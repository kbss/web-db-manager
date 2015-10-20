package org.kbss.webdb.services.validation;

import org.kbss.webdb.dto.AccountDto;
import org.kbss.webdb.services.exceptions.ClientException;

/**
 * @author Serhii Kryvtsov
 * @since 10/14/2015.
 */
public interface ValidationService {
    void assertRequestNotEmpty(Object obj) throws ClientException;

    void assertAccountCreationDtoValid(AccountDto accountDto) throws ClientException;
}
