package org.juke.webdb.services.api.account;

import org.juke.webdb.dto.AccountDto;
import org.juke.webdb.resources.AccountResource;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * @author Serhii Kryvtsov
 * @since 14/10/2015.
 */
@Named
@Singleton
public class AccountResourceImpl implements AccountResource {

    @Named
    private AccountService accountService;

    @Override
    public AccountDto login(AccountDto loginDto) {
        System.out.println(loginDto);
        System.out.println(accountService);
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
