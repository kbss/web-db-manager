package org.juke.webdb.services.impl.account;

import org.apache.commons.lang3.StringUtils;
import org.juke.webdb.dto.AccountDto;
import org.juke.webdb.jpa.dao.UserDao;
import org.juke.webdb.jpa.dao.UserTokenDao;
import org.juke.webdb.jpa.entities.User;
import org.juke.webdb.jpa.entities.UserToken;
import org.juke.webdb.services.api.account.AccountService;
import org.juke.webdb.services.api.account.PasswordService;
import org.juke.webdb.services.exceptions.WrongCredentialException;
import org.juke.webdb.services.validation.ValidationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import java.util.UUID;

/**
 * @author Serhii Kryvtsov
 * @since 14/10/2015.
 */
@Named
@Singleton
public class AccountServiceImpl implements AccountService {

    //30 days
    private static final long TOKEN_LIFE_TIME = 1000 * 60 * 60 * 24 * 30;

    private final static Logger LOGGER = LoggerFactory.getLogger(AccountServiceImpl.class);

    @Inject
    private UserTokenDao userTokenDao;
    @Inject
    private UserDao userDao;
    @Inject
    private PasswordService passwordService;
    @Inject
    private ValidationService validationService;

    @Override
    public AccountDto login(AccountDto loginDto) {
        LOGGER.debug("Authentication user...");
        validationService.assertRequestNotEmpty(loginDto);
        validateLoginDto(loginDto);
        User user = userDao.findFirstByEmail(loginDto.getEmail());
        if (user == null) {
            throw new WrongCredentialException();
        }
        passwordService.validatePassword(loginDto.getPassword(), user.getPassword());

        UserToken token = new UserToken();
        token.setUser(user);
        token.setToken(UUID.randomUUID().toString());
        token.setExpiration(System.currentTimeMillis() + TOKEN_LIFE_TIME);
        userTokenDao.save(token);
        AccountDto response = new AccountDto();
        response.setToken(token.getToken());
        return response;
    }

    private void validateLoginDto(AccountDto loginDto) {
        if (StringUtils.isBlank(loginDto.getEmail()) || StringUtils.isBlank(loginDto.getPassword())) {
            throw new WrongCredentialException();
        }
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
