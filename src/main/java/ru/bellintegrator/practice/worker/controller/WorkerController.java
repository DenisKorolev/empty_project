package ru.bellintegrator.practice.worker.controller;

import org.springframework.web.bind.annotation.RequestBody;
import ru.bellintegrator.practice.worker.view.WorkerFilterInView;
import ru.bellintegrator.practice.worker.view.WorkerFilterOutView;

import java.util.List;

public interface WorkerController {

    /**
     * Filters Worker objects by Office id and other parameters
     * @param inView request mapping
     * @return List of Worker views if any
     */
    List<WorkerFilterOutView> filterByOfficeId(@RequestBody WorkerFilterInView inView);
}
