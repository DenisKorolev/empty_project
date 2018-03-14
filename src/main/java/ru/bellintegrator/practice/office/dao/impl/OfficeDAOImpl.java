package ru.bellintegrator.practice.office.dao.impl;

import org.hibernate.Criteria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.office.dao.OfficeDAO;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.organization.model.Organization;


import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class OfficeDAOImpl implements OfficeDAO{

    private final EntityManager em;

    @Autowired
    public OfficeDAOImpl(EntityManager em){
        this.em = em;
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Office> all() {
        TypedQuery<Office> query = em.createQuery("SELECT o FROM Office o", Office.class);
        return query.getResultList();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public Office loadById(Long id) {
        return em.find(Office.class, id);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public List<Office> filterByOrgId(Office officeEntity) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Office> criteria = builder.createQuery(Office.class);

        Root<Office> office = criteria.from(Office.class);
        criteria.where(builder.and(
                builder.equal(office.join("organization").get("id"), officeEntity.getOrganization().getId())),
                builder.equal(office.get("officeName"), officeEntity.getOfficeName()),
                builder.equal(office.get("officePhone"), officeEntity.getOfficePhone()),
                builder.equal(office.get("isOfficeActive"), officeEntity.getOfficeActive())
        );

        TypedQuery<Office> query = em.createQuery(criteria);
        return query.getResultList();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void updateById(Office office) {
        em.merge(office);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(Office office) {
        em.remove(office);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Office office) {
        em.persist(office);
    }
}