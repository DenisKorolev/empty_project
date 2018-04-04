package ru.bellintegrator.practice.organization.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.organization.dao.OrganizationDAO;
import ru.bellintegrator.practice.organization.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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

        List<Predicate> predicates = new ArrayList();
        //Org inn
        if ((orgEntity.getInn() != null) && (!orgEntity.getInn().isEmpty()))
            predicates.add(
                    builder.like(builder.upper(organization.get("inn")), ("%" + orgEntity.getInn() + "%").toUpperCase())
            );
        //Is Org active
        if (!(orgEntity.getActive() == null))
            predicates.add(
                    builder.equal(organization.get("isActive"), orgEntity.getActive())
            );


        //Org name
        if (predicates.isEmpty())
            criteria.where(
                    builder.like(builder.upper(organization.get("orgName")), ("%" + orgEntity.getOrgName() + "%").toUpperCase())
            );
        else {
            predicates.add(
                    builder.like(builder.upper(organization.get("orgName")), ("%" + orgEntity.getOrgName() + "%").toUpperCase())
            );
            criteria.where(builder.and(
                    predicates.toArray(new Predicate[predicates.size()])
                    )
            );
        }

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