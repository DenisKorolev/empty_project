package ru.bellintegrator.practice.user.view;

public class UserRegisterView {

    /**
     * User login
     */
    private String login;

    /**
     * User password
     */
    private String password;

    /**
     * User name
     */
    private String name;

    /**
     * User email
     */
    private String email;

    /**
     * Constructor for Jackson
     */
    public UserRegisterView(){

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
