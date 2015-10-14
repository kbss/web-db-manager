package org.juke.webdb.services.impl.account;

import org.apache.commons.lang3.StringUtils;
import org.juke.webdb.dto.AccountDto;
import org.juke.webdb.jpa.dao.UserDao;
import org.juke.webdb.jpa.dao.UserTokenDao;
import org.juke.webdb.jpa.entities.User;
import org.juke.webdb.services.api.account.AccountService;
import org.juke.webdb.services.api.account.PasswordService;
import org.juke.webdb.services.exceptions.WrongCredentialException;
import org.juke.webdb.services.validation.ValidationService;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * @author Serhii Kryvtsov
 * @since 14/10/2015.
 */
@Named
@Singleton
public class AccountServiceImpl implements AccountService {

    @Inject
    private UserTokenDao userTokenDao;
    @Inject
    private UserDao userDao;
    @Inject
    private ValidationService validationService;
    @Inject
    private PasswordService passwordService;

    @Override
    public AccountDto login(AccountDto loginDto) {
        validationService.assertRequestNotEmpty(loginDto);
        validateLoginDto(loginDto);
        User user = userDao.findFirstByEmail(loginDto.getEmail());
        if (user == null) {
            throw new WrongCredentialException();
        }
        passwordService.validatePassword(loginDto.getPassword(), user.getPassword());
        //TODO: implement
        return null;
    }

    private void validateLoginDto(AccountDto loginDto) {
        if (StringUtils.isBlank(loginDto.getEmail()) || StringUtils.isBlank(loginDto.getPassword())) {
            throw new WrongCredentialException();
        }
    }

    private void validateRequest(Object request) {

    }

    @Override
    public AccountDto registerAccount(AccountDto loginDto) {
        //TODO: implement
        return null;
    }

    @Override
    public void logout() {
        //TODO: implement
    }
}
