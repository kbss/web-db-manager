package org.juke.webdb.dao;


import org.juke.webdb.configuration.StorageConfiguration;
import org.juke.webdb.jpa.dao.UserDao;
import org.juke.webdb.jpa.dao.UserTokenDao;
import org.juke.webdb.jpa.entities.User;
import org.juke.webdb.jpa.entities.UserToken;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author Serhii Kryvtsov
 * @since 13/10/2015
 */
@Test(groups = {"integrity"})
@ContextConfiguration(classes = StorageConfiguration.class)
public class UserDaoTest extends AbstractTestNGSpringContextTests {
    @Inject
    private UserDao userDao;
    @Inject
    private UserTokenDao tokenDao;
    private User testUser;
    private String userToken;

    @BeforeClass
    public void userSaveTest() {
        testUser = new User();
        testUser.setEmail(System.currentTimeMillis() + "_email@example.com");
        testUser.setPassword("pwd");
        userDao.save(testUser);
        assertThat(testUser.getUserId()).isNotNull();
    }

    @Test
    public void findUserByEmailTest() {
        assertThat(testUser).isNotNull();
        User user = userDao.findFirstByEmail(testUser.getEmail());
        assertThat(user).isNotNull();
        assertThat(user.getUserId()).isNotNull();
        assertThat(testUser.getEmail()).isEqualTo(user.getEmail());
        assertThat(testUser.getUserId()).isEqualTo(user.getUserId());
        testUser = user;
    }

    @Test(dependsOnMethods = "findUserByEmailTest")
    @Transactional
    public void tokenSaveTest() {
        assertThat(testUser).isNotNull();
        assertThat(testUser.getUserId()).isNotNull();
        userToken = UUID.randomUUID().toString();
        UserToken token = new UserToken();
        token.setExpiration(System.currentTimeMillis() + 10000);
        token.setToken(userToken);
        token.setUser(testUser);
        tokenDao.save(token);
    }

    @Test(dependsOnMethods = "tokenSaveTest")
    public void findUserByTokenTest() {
        assertThat(userToken).isNotNull();
        User byToken = tokenDao.findUserByToken(userToken);
        assertThat(byToken.getEmail()).isEqualTo(testUser.getEmail());
    }

    @AfterClass
    public void afterTest() {
        userDao.delete(testUser);
        User user = userDao.findFirstByEmail(testUser.getEmail());
        assertThat(user).isNull();
    }
}
