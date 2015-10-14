package org.juke.webdb.jpa.dao;

import org.juke.webdb.jpa.entities.User;
import org.juke.webdb.jpa.entities.UserToken;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.inject.Named;
import javax.inject.Singleton;

/**
 * @author Serhii Kryvtsov
 * @since 14/10/2015
 */
@Named
@Singleton
public interface UserTokenDao extends CrudRepository<UserToken, Long> {

    @Query("select t.user from UserToken t where t.token=?1")
    User findUserByToken(String token);
}