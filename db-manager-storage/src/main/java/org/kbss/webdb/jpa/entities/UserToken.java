package org.kbss.webdb.jpa.entities;

import javax.persistence.*;

/**
 * @author Serhii Kryvtsov
 * @since 12/10/2015
 */
@Entity
@Table(name = "USER_TOKEN")
public class UserToken {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tokenId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "USER_ID", nullable = false)
    private User user;
    @Column
    private String token;
    @Column
    private Long expiration;

    public Long getTokenId() {
        return tokenId;
    }

    public void setTokenId(Long tokenId) {
        this.tokenId = tokenId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getExpiration() {
        return expiration;
    }

    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }
}
