package ru.bellintegrator.practice.worker.dao;

import ru.bellintegrator.practice.worker.model.Worker;

import java.util.Date;
import java.util.List;

public interface WorkerDAO {

    /**
     * Filters Worker (Employee) objects
     * @param worker Worker object to filter
     * @return List of filtered Worker objects if any
     */
    List<Worker> filterByOfficeId(Worker worker);


    /**
     * Gets Worker object by id
     * @param id Worker id
     * @return Worker object if any
     */
    Worker loadById(Long id);


    /**
     * Deletes Worker from DB by id
     * @param worker Worker object to delete
     */
    void deleteById(Worker worker);


    /**
     * Adds Worker to DB
     * @param worker Worker object to add
     */
    void save(Worker worker);
}
