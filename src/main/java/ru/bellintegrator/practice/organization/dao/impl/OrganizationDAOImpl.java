package ru.bellintegrator.practice.organization.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.organization.dao.OrganizationDAO;
import ru.bellintegrator.practice.organization.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class OrganizationDAOImpl implements OrganizationDAO {

    private final EntityManager em;

    @Autowired
    public OrganizationDAOImpl(EntityManager em){
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Organization> filterByName(Organization orgEntity) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteria = builder.createQuery(Organization.class);

        Root<Organization> organization = criteria.from(Organization.class);
        criteria.where(builder.and(
                builder.equal(organization.get("orgName"), orgEntity.getOrgName()),
                builder.equal(organization.get("inn"), orgEntity.getInn()),
                builder.equal(organization.get("isActive"), orgEntity.getActive())
                )
        );

        TypedQuery<Organization> query = em.createQuery(criteria);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Organization loadById(Long id) {
        return em.find(Organization.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateById(Organization organization) {
        em.merge(organization);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Organization organization) {
        em.persist(organization);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(Organization organization) {
        em.remove(organization);
    }
}