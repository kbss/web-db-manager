package org.kbss.webdb.context;

import org.kbss.webdb.jpa.entities.User;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

/**
 * @author Serhii Kryvtsov
 * @since 14/10/2015
 */
public class SecurityContext extends UsernamePasswordAuthenticationToken {
    private User user;

    public SecurityContext(User user, Collection<? extends GrantedAuthority> authorities) {
        super(user.getUserId(), user.getUserId(), authorities);
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
