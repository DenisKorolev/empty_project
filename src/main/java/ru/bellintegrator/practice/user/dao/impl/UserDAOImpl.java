package ru.bellintegrator.practice.user.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.user.dao.UserDAO;
import ru.bellintegrator.practice.user.model.User;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    private final EntityManager em;

    @Autowired
    public UserDAOImpl(EntityManager em){
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(User user) {
        em.persist(user);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Deprecated
    public User loadByHash(String hash) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);

        Root<User> user = criteria.from(User.class);
        criteria.where(builder.equal(user.get("activationHash"), hash));

        TypedQuery<User> query = em.createQuery(criteria);

        return query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User loadByAccount(String login, String password) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<User> criteria = builder.createQuery(User.class);

        Root<User> user = criteria.from(User.class);
        criteria.where(builder.and(
                builder.equal(user.get("login"), login),
                builder.equal(user.get("password"), password)
                )
        );

        TypedQuery<User> query = em.createQuery(criteria);

        return query.getSingleResult();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User loadByLogin(String login) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE LOWER(u.login) LIKE LOWER(:login)", User.class);
        query.setParameter("login", login);

        List<User> results = query.getResultList();
        User user = null;
        if (!results.isEmpty())
            user = results.get(0);

        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User loadByEmail(String email) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE LOWER(u.email) LIKE LOWER(:email)", User.class);
        query.setParameter("email", email);

        List<User> results = query.getResultList();
        User user = null;
        if (!results.isEmpty())
            user = results.get(0);

        return user;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public User loadByActivationHash(String activationHash) {
        TypedQuery<User> query = em.createQuery("SELECT u FROM User u WHERE u.activationHash = :activationHash", User.class);
        query.setParameter("activationHash", activationHash);

        List<User> results = query.getResultList();
        User user = null;
        if (!results.isEmpty())
            user = results.get(0);

        return user;
    }
}
