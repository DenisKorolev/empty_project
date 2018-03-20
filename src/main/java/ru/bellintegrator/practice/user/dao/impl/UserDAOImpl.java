package ru.bellintegrator.practice.user.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.user.dao.UserDAO;
import ru.bellintegrator.practice.user.model.User;

import javax.persistence.EntityManager;

@Repository
public class UserDAOImpl implements UserDAO {

    private final EntityManager em;

    @Autowired
    public UserDAOImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public void save(User user) {
        em.persist(user);
    }

    @Override
    public User loadByHash(String hash) {
        return null;
    }

    @Override
    public User loadByAccount(String login, String password) {
        return null;
    }
}
