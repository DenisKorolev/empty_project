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
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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

        List<Predicate> predicates = new ArrayList<Predicate>();
        //Office name
        if (!officeEntity.getOfficeName().isEmpty())
            predicates.add(
                    builder.equal(office.get("officeName"), officeEntity.getOfficeName())
            );
        //Office phone
        if (!officeEntity.getOfficePhone().isEmpty())
            predicates.add(
                    builder.equal(office.get("officePhone"), officeEntity.getOfficePhone())
            );
        //Is Office active
        if (!(officeEntity.getOfficeActive() == null))
            predicates.add(
                    builder.equal(office.get("isOfficeActive"), officeEntity.getOfficeActive())
            );

        //Org id
        if (predicates.isEmpty()) {
            criteria.where(
                    builder.equal(office.join("organization").get("id"), officeEntity.getOrganization().getId())
            );
        }
        else {
            predicates.add(
                    builder.equal(office.join("organization").get("id"), officeEntity.getOrganization().getId())
            );
            criteria.where(builder.and(
                        predicates.toArray(new Predicate[predicates.size()])
                    )
            );
        }


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