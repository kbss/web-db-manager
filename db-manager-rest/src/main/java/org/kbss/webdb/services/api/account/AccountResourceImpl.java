package org.kbss.webdb.services.api.account;

import org.kbss.webdb.dto.AccountDto;
import org.kbss.webdb.resources.AccountResource;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

/**
 * @author Serhii Kryvtsov
 * @since 14/10/2015.
 */
@Named
@Singleton
public class AccountResourceImpl implements AccountResource {

    @Inject
    private AccountService accountService;

    @Override
    public AccountDto login(AccountDto loginDto) {
        return accountService.login(loginDto);
    }

    @Override
    public AccountDto registerAccount(AccountDto accountDto) {
        return accountService.registerAccount(accountDto);
    }

    @Override
    public void logout() {
        accountService.logout();
    }
}
