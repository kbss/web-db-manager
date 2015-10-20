package org.kbss.webdb.service.tests;

import org.kbss.webdb.services.api.account.PasswordService;
import org.kbss.webdb.services.impl.PasswordServiceImpl;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Serhii Kryvtsov
 * @since 10/14/2015.
 */
@Test(groups = {"integrity"})
public class PasswordServiceTest {

    @Test
    public void passwordServiceTest() {
        String testPassword = "te5t@_" + System.currentTimeMillis();
        PasswordService service = new PasswordServiceImpl();
        String encryptPwd = service.encryptPassword(testPassword);
        assertThat(encryptPwd).isNotEmpty();
        service.validatePassword(testPassword, encryptPwd);
    }
}
