package ru.bellintegrator.practice.worker.service;

import ru.bellintegrator.practice.worker.view.WorkerFilterInView;
import ru.bellintegrator.practice.worker.view.WorkerFilterOutView;
import ru.bellintegrator.practice.worker.view.WorkerView;

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
}
