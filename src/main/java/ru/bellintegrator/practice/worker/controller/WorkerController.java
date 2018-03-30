package ru.bellintegrator.practice.worker.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.bellintegrator.practice.worker.view.WorkerFilterInView;
import ru.bellintegrator.practice.worker.view.WorkerFilterOutView;
import ru.bellintegrator.practice.worker.view.WorkerView;

import java.util.List;

public interface WorkerController {

    /**
     * Filters Worker objects by Office id and other parameters
     * @param inView request mapping
     * @return List of Worker views if any
     */
    List<WorkerFilterOutView> filterByOfficeId(@RequestBody WorkerFilterInView inView);

    /**
     * Loads Worker object by id
     * @param id Worker id
     * @return Worker view if any
     */
    WorkerView loadById(@PathVariable(value = "id") String id);
}
