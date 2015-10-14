package org.juke.webdb.jpa.dao;

import org.juke.webdb.jpa.entities.User;
import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * @author Serhii Kryvtsov
 * @since 12/10/2015
 */
@Named
@Singleton
public interface UserDao extends CrudRepository<User, Long> {

    User findFirstByEmail(String email);
}