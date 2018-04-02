package ru.bellintegrator.practice.worker.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.bellintegrator.practice.common.view.ResultView;
import ru.bellintegrator.practice.worker.view.*;

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

    /**
     * Updates Worker object by id
     * @param inView request mapping
     * @return update result
     */
    ResultView updateById(@RequestBody WorkerUpdateInView inView);

    /**
     * Deletes Worker object by id
     * @param id Worker id
     * @return delete result
     */
    ResultView deleteById(@PathVariable(value = "id") String id);

    /**
     * Adds Worker object to DB
     * @param inView request mapping
     * @return id of created object
     */
    WorkerIdOutView save(@RequestBody WorkerSaveView inView);
}
