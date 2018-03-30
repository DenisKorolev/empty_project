package ru.bellintegrator.practice.worker.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.worker.dao.WorkerDAO;
import ru.bellintegrator.practice.worker.model.Worker;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class WorkerDAOImpl implements WorkerDAO{

    private final EntityManager em;

    @Autowired
    public WorkerDAOImpl(EntityManager em){
        this.em = em;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Worker> filterByOfficeId(Worker workerEntity) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Worker> criteria = builder.createQuery(Worker.class);

        Root<Worker> worker = criteria.from(Worker.class);

        List<Predicate> predicates = new ArrayList<>();

        //Worker Office id
        predicates.add(
                builder.equal(
                        worker.join("office").get("id"), workerEntity.getOffice().getId()
                )
        );

        //Worker first name
        if ((workerEntity.getFirstName() != null) && (!workerEntity.getFirstName().isEmpty()))
            predicates.add(
                    builder.like(worker.get("firstName"), "%" + workerEntity.getFirstName() + "%")
            );
        //Worker last name
        if ((workerEntity.getLastName() != null) && (!workerEntity.getLastName().isEmpty()))
            predicates.add(
                    builder.like(worker.get("lastName"), "%" + workerEntity.getLastName() + "%")
            );
        //Worker middle name
        if ((workerEntity.getMiddleName() != null) && (!workerEntity.getMiddleName().isEmpty()))
            predicates.add(
                    builder.like(worker.get("middleName"), "%" + workerEntity.getMiddleName() + "%")
            );
        //Worker position
        if ((workerEntity.getPosition() != null) && (!workerEntity.getPosition().isEmpty()))
            predicates.add(
                    builder.like(worker.get("position"), "%" + workerEntity.getPosition() + "%")
            );

        //Worker Country citizenship code
        if (workerEntity.getCountry() != null)
            predicates.add(
                    builder.equal(
                            worker.join("country").get("id"), workerEntity.getCountry().getId()
                    )
            );


        criteria.where(builder.and(
                predicates.toArray(new Predicate[predicates.size()])
                )
        );


        TypedQuery<Worker> query = em.createQuery(criteria);
        return query.getResultList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Worker loadById(Long id) {
        return em.find(Worker.class, id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(Worker worker) {
        em.remove(worker);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(Worker worker) {
        em.persist(worker);
    }
}
