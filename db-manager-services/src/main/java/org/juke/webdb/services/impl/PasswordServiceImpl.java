package org.juke.webdb.services.impl;

import org.juke.webdb.services.api.account.PasswordService;
import org.juke.webdb.services.exceptions.ServiceException;
import org.juke.webdb.services.exceptions.WrongCredentialException;
import org.springframework.security.crypto.codec.Base64;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Serhii Kryvtsov
 * @since 10/14/2015.
 */
public class PasswordServiceImpl implements PasswordService {

    private static final String UTF_8 = "UTF-8";
    private static final String ALGORITHM = "SHA-256";

    @Override
    public String encryptPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance(ALGORITHM);
            byte[] encryptedPassword = digest.digest(password.getBytes(UTF_8));
            return new String(Base64.encode(encryptedPassword));
        } catch (NoSuchAlgorithmException e) {
            throw new ServiceException(e.getMessage());
        } catch (UnsupportedEncodingException e1) {
            throw new ServiceException(e1.getMessage());
        }
    }

    @Override
    public void validatePassword(String password, String encryptedPassword) {
        String actualPassword = encryptPassword(password);
        if (!actualPassword.equals(encryptedPassword)) {
            throw new WrongCredentialException();
        }
    }
}
