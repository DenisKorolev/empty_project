package ru.bellintegrator.practice.user.service.impl;

import com.google.common.hash.Hashing;
import org.apache.commons.validator.routines.EmailValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.common.exception.EntityDoesNotExistException;
import ru.bellintegrator.practice.common.exception.EntityExistsException;
import ru.bellintegrator.practice.common.exception.FieldIsNotDataTypeException;
import ru.bellintegrator.practice.common.util.ValidationUtils;
import ru.bellintegrator.practice.user.dao.UserDAO;
import ru.bellintegrator.practice.user.model.User;
import ru.bellintegrator.practice.user.service.UserService;
import ru.bellintegrator.practice.user.view.UserLoginView;
import ru.bellintegrator.practice.user.view.UserRegisterView;



import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class UserServiceImpl implements UserService {

    private final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);

    private final UserDAO dao;

    public UserServiceImpl(UserDAO dao){
        this.dao = dao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void register(UserRegisterView inView) {

        ValidationUtils.checkFieldOnNullOrEmpty(inView.getLogin(), "login");
        //Checks if user already exist
        User user = dao.loadByLogin(inView.getLogin());
        if (user != null)
            throw new EntityExistsException("User", "login", inView.getLogin());

        User newUser = new User();
        //Set login
        newUser.setLogin(inView.getLogin());

        ValidationUtils.checkFieldOnNullOrEmpty(inView.getEmail(), "email");
        if (EmailValidator.getInstance().isValid(inView.getEmail()) == false)
            throw new FieldIsNotDataTypeException("email", "Email type");

        user = dao.loadByEmail(inView.getEmail());
        if (user != null)
            throw new EntityExistsException("User", "email", inView.getEmail());
        //Set email
        newUser.setEmail(inView.getEmail());

        ValidationUtils.checkFieldOnNullOrEmpty(inView.getPassword(), "password");
        String hashedPassword = Hashing.sha256().hashString(inView.getPassword(), StandardCharsets.UTF_8).toString();
        //Set password
        newUser.setPassword(hashedPassword);

        ValidationUtils.checkFieldOnNullOrEmpty(inView.getName(), "name");
        //Set name
        newUser.setUserName(inView.getName());

        //Set is active
        newUser.setUserActive(false);

        //Set User activation hash
        String userHashData = inView.getLogin() + " " + inView.getEmail() + " " + inView.getName() + new Date(System.currentTimeMillis());
        String userActivationHash = Hashing.sha256().hashString(userHashData, StandardCharsets.UTF_8).toString();
        newUser.setActivationHash(userActivationHash);

        dao.save(newUser);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void activate(String hashCode) {

        User user = dao.loadByActivationHash(hashCode);
        if (user == null)
            throw new EntityDoesNotExistException("User", "code", hashCode);
        else {
            user.setActivationHash(null);
            user.setUserActive(true);
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void login(UserLoginView inView) {

    }
}
