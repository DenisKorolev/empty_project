package ru.bellintegrator.practice.country.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.country.dao.CountryDAO;
import ru.bellintegrator.practice.country.model.Country;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class CountryDAOImpl implements CountryDAO{
    private final EntityManager em;

    @Autowired
    public CountryDAOImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public List<Country> all(){
        TypedQuery<Country> query = em.createQuery("SELECT c FROM Country c", Country.class);
        return query.getResultList();
    }

    @Override
    public Country loadById(Long id){
        return em.find(Country.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Country loadByCountryCode(Long countryCode) {

        TypedQuery<Country> query = em.createQuery("SELECT c FROM Country c WHERE c.countryCode = :countryCode", Country.class);
        query.setParameter("countryCode", countryCode);

        return query.getSingleResult();
    }
}
