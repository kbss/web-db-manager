package org.juke.webdb.jpa.entities;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Collection;

/**
 * @author Serhii Kryvtsov
 * @since 12/10/2015
 */
@Entity
@Table(name = "USER")
public class User {

    @Id
    @Column(name = "USER_ID", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    @Column(name = "email", length = 255)
    private String email;
    @Column(name = "password", length = 255)
    private String password;
    @Column(name = "EXTERANL_ID")
    private String externalId;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
    private Collection<UserToken> userTokens;

    public Collection<UserToken> getUserTokens() {
        return userTokens;
    }

    public void setUserTokens(Collection<UserToken> userTokens) {
        this.userTokens = userTokens;
    }

    @Override
    public String toString() {

        return "User{" +
                "userId=" + userId +
                ", email='" + email + '\'' +
                ", externalId='" + externalId + '\'' +
                '}';
    }

    public String getExternalId() {
        return externalId;
    }

    public void setExternalId(String externalId) {
        this.externalId = externalId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
