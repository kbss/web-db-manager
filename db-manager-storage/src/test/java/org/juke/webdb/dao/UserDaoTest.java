package org.juke.webdb.dao;


import org.juke.webdb.configuration.StorageConfiguration;
import org.juke.webdb.jpa.dao.UserDao;
import org.juke.webdb.jpa.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by skrivtsov on 13/10/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = StorageConfiguration.class)
public class UserDaoTest {


    @Autowired
    private UserDao userDao;

    @Test
    @Transactional
    public void escalationConfiguration() {

        User usr = new User();
        usr.setEmail("email@example.com");
        usr.setPassword("pwd");
        userDao.save(usr);

        User user = userDao.findByEmail(usr.getEmail());
//        Assert.assertEquals(usr.getEmail(), user.getEmail());
//        userDao.delete(user);
//        user = userDao.findByEmail(usr.getEmail());
//        Assert.assertNull(user.getEmail());
    }
}
