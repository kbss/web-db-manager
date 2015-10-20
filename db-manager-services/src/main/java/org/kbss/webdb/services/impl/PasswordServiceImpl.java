package org.kbss.webdb.services.impl;

import org.kbss.webdb.services.api.account.PasswordService;
import org.kbss.webdb.services.exceptions.ServiceException;
import org.kbss.webdb.services.exceptions.WrongCredentialException;
import org.springframework.security.crypto.codec.Base64;

import javax.inject.Named;
import javax.inject.Singleton;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Serhii Kryvtsov
 * @since 10/14/2015.
 */
@Named
@Singleton
public class PasswordServiceImpl implements PasswordService {

    private static final String UTF_8 = "UTF-8";
    private static final String ALGORITHM = "SHA-256";
    private MessageDigest digest;

    public PasswordServiceImpl() {
        try {
            digest = MessageDigest.getInstance(ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            throw new ServiceException(e.getMessage());
        }
    }

    @Override
    public String encryptPassword(String password) {
        try {
            byte[] encryptedPassword = digest.digest(password.getBytes(UTF_8));
            return new String(Base64.encode(encryptedPassword));
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