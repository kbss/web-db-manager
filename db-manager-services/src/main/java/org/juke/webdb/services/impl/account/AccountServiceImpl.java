package org.juke.webdb.services.impl.account;

import org.juke.webdb.dto.AccountDto;
import org.juke.webdb.services.api.account.AccountService;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * @author Serhii Kryvtsov
 * @since 14/10/2015.
 */
@Named
@Singleton
public class AccountServiceImpl implements AccountService {

    @Override
    public AccountDto login(AccountDto loginDto) {
        //TODO: implement
        return null;
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
