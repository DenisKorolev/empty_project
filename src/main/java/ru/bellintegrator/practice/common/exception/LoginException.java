package ru.bellintegrator.practice.common.exception;

public class LoginException extends ValidationException {
    public LoginException(){
        super("Login/password pair is incorrect!");
    }

    public LoginException(String email){
        super("Email " + email + " is not confirmed!");
    }
}
