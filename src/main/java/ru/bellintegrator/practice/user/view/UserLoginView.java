package ru.bellintegrator.practice.user.view;

public class UserLoginView {

    /**
     * User login
     */
    private String login;

    /**
     * User password
     */
    private String password;

    /**
     * Constructor for Jackson
     */
    public UserLoginView(){

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
}
