package ru.bellintegrator.practice.user.service;

import ru.bellintegrator.practice.user.view.UserLoginView;
import ru.bellintegrator.practice.user.view.UserRegisterView;

public interface UserService {

    /**
     * Adds new User to DB
     * @param inView request maping
     */
    void register(UserRegisterView inView);

    /**
     * Activates User by hash code
     * @param hashCode hash code
     */
    void activate(String hashCode);

    /**
     * Logs User in
     * @param inView request mapping
     */
    void login(UserLoginView inView);


}
