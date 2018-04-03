package ru.bellintegrator.practice.user.controller.impl;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.common.view.ResultView;
import ru.bellintegrator.practice.user.controller.UserController;
import ru.bellintegrator.practice.user.service.UserService;
import ru.bellintegrator.practice.user.view.UserRegisterView;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api", produces = APPLICATION_JSON_VALUE)
public class UserControllerImpl implements UserController {

    private final UserService userService;

    @Autowired
    public UserControllerImpl(UserService userService){
        this.userService = userService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ApiOperation(value = "Adds User to DB", httpMethod = "POST")
    @RequestMapping(value = "/register", method = {POST})
    public ResultView register(UserRegisterView inView) {

        userService.register(inView);
        return new ResultView("success");
    }
}
