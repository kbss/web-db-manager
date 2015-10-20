package org.kbss.webdb.jpa.dao;

import org.kbss.webdb.jpa.entities.User;
import org.springframework.data.jpa.repository.Query;
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

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN 'true' ELSE 'false' END FROM User u WHERE upper(u.email) = upper(?1)")
    boolean existsByEmail(String email);
}