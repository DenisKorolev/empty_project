package ru.bellintegrator.practice.user.dao;

import ru.bellintegrator.practice.user.model.User;

public interface UserDAO {

    /**
     * Adds (registers) user to DB
     * @param user User object to add
     */
    void save(User user);

    /**
     * Gets User object by hash
     * @param hash User activation hash
     * @return User object if any
     */
    User loadByHash(String hash);

    /**
     * Gets User object by login and password
     * @param login User login
     * @param password User password
     * @return User object if any
     */
    User loadByAccount(String login, String password);

    /**
     * Gets User object by login
     * @param login User login
     * @return User object if any
     */
    User loadByLogin(String login);

    /**
     * Gets User object by email
     * @param email User email
     * @return User object if any
     */
    User loadByEmail(String email);

    /**
     * Gets User object by activation hash
     * @param activationHash User activation hash
     * @return User object if any
     */
    User loadByActivationHash(String activationHash);
}
