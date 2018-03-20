package ru.bellintegrator.practice.worker.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.worker.dao.WorkerDAO;
import ru.bellintegrator.practice.worker.model.Worker;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
    public List<Worker> filter(Worker workerEntity) {

        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Worker> criteria = builder.createQuery(Worker.class);

        Root<Worker> worker = criteria.from(Worker.class);
        criteria.where(builder.and(
                builder.equal(
                        worker.join("office").get("id"), workerEntity.getOffice().getId()
                ),

                builder.equal(
                        worker.join("doc").get("docNumber"), workerEntity.getDoc().getDocNumber()
                ),

                builder.equal(
                        worker.join("country").get("countryCode"), workerEntity.getCountry().getCountryCode()
                ),

                builder.equal(worker.get("firstName"), workerEntity.getFirstName()),
                builder.equal(worker.get("lastName"), workerEntity.getLastName()),
                builder.equal(worker.get("middleName"), workerEntity.getMiddleName()),
                builder.equal(worker.get("position"), workerEntity.getPosition())
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
