package org.juke.webdb.services.api.account;

/**
 * @author Serhii Kryvtsov
 * @since 10/14/2015.
 */
public interface PasswordService {
    String encryptPassword(String password);

    void validatePassword(String password, String encryptedPassword);
}
