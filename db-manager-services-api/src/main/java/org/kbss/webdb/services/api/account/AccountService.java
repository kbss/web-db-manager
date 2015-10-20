package org.kbss.webdb.services.api.account;

import org.kbss.webdb.dto.AccountDto;

/**
 * @author Serhii Kryvtsov
 * @since 14/10/2015.
 */
public interface AccountService {
    AccountDto login(AccountDto loginDto);

    AccountDto registerAccount(AccountDto loginDto);

    void logout();
}
