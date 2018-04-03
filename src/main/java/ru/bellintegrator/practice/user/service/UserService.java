package ru.bellintegrator.practice.user.service;

import ru.bellintegrator.practice.user.view.UserRegisterView;

public interface UserService {

    /**
     *
     * @param inView
     */
    void register(UserRegisterView inView);
}
