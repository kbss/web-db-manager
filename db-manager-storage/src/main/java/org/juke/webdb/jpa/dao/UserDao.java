package org.juke.webdb.jpa.dao;

import org.juke.webdb.jpa.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Serhii Kryvtsov
 * @since 12/10/2015
 */
@Repository
public interface UserDao extends CrudRepository<User, Long> {

    User findByEmail(String email);
}