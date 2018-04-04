package ru.bellintegrator.practice.user.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import ru.bellintegrator.practice.common.view.ResultView;
import ru.bellintegrator.practice.user.view.UserLoginView;
import ru.bellintegrator.practice.user.view.UserRegisterView;

public interface UserController {

    /**
     * Adds user to DB
     * @param inView request mapping
     * @return result
     */
    ResultView register(@RequestBody UserRegisterView inView);

    /**
     * Activates User by hashcode
     * @param hashCode activation hash code
     * @return result
     */
    ResultView activate(@RequestParam(value = "code") String hashCode);

    /**
     * Logs User in
     * @param inView request mapping
     * @return result
     */
    ResultView login(@RequestBody UserLoginView inView);
}
