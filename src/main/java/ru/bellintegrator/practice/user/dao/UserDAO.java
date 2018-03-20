package ru.bellintegrator.practice.user.dao;

import ru.bellintegrator.practice.user.model.User;

public interface UserDAO {

    /**
     * Adds (registers) user to DB
     * @param user User object to add
     */
    public void save(User user);

    /**
     * Gets User object by hash
     * @param hash User activation hash
     * @return User object if any
     */
    public User loadByHash(String hash);

    /**
     * Gets User object by login and password
     * @param login
     * @param password
     * @return User object if any
     */
    public User loadByAccount(String login, String password);
}
