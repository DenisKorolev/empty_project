package ru.bellintegrator.practice.user.controller;

import org.springframework.web.bind.annotation.RequestBody;
import ru.bellintegrator.practice.common.view.ResultView;
import ru.bellintegrator.practice.user.view.UserRegisterView;

public interface UserController {

    /**
     * Adds user to DB
     * @param inView reques mapping
     * @return result
     */
    ResultView register(@RequestBody UserRegisterView inView);
}
