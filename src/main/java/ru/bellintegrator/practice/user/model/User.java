package ru.bellintegrator.practice.user.model;

import javax.persistence.*;

@Entity
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Service field of hibernate
     */
    @Version
    private Integer version;

    /**
     * User login
     */
    @Basic(optional = false)
    @Column(name = "login", unique = true)
    private String login;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * User password
     */
    @Basic(optional = false)
    @Column(name = "password")
    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * User name
     */

    @Basic(optional = false)
    @Column(name = "user_name")
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    /**
     * User email
     */
    @Basic(optional = false)
    @Column(name = "email")
    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Field to identify whether user was verified after registration or not
     */
    @Basic(optional = false)
    @Column(name = "is_user_active")
    private Boolean isUserActive;

    public Boolean getUserActive() {
        return isUserActive;
    }

    public void setUserActive(Boolean userActive) {
        isUserActive = userActive;
    }

    /**
     * Hash to verify user's activation
     */
    @Column(name = "activation_hash", unique = true)
    private String activationHash;

    public String getActivationHash() {
        return activationHash;
    }

    public void setActivationHash(String activationHash) {
        this.activationHash = activationHash;
    }
}
