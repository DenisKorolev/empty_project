package ru.bellintegrator.practice.worker.service;

import ru.bellintegrator.practice.worker.view.*;

import java.util.List;

public interface WorkerService {

    /**
     * Filters Employee by Office id and other parameters
     * @param inView request mapping
     * @return JSON Employees values
     */
    List<WorkerFilterOutView> filterByOfficeId(WorkerFilterInView inView);

    /**
     * Loads Employee object by id
     * @param id Worker id
     * @return JSON Employee value
     */
    WorkerView loadById(String id);

    /**
     * Updates Employee object by id
     * @param inView request mapping
     */
    void updateById(WorkerUpdateInView inView);

    /**
     * Deletes Employee object by id
     * @param id Employee id
     */
    void deleteById(String id);

    /**
     * Adds Employee object to DB
     * @param inView request mapping
     * @return JSON Employee id
     */
    WorkerIdOutView save(WorkerSaveView inView);
}
