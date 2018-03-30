package ru.bellintegrator.practice.worker.controller.impl;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.worker.controller.WorkerController;
import ru.bellintegrator.practice.worker.service.WorkerService;
import ru.bellintegrator.practice.worker.view.WorkerFilterInView;
import ru.bellintegrator.practice.worker.view.WorkerFilterOutView;
import ru.bellintegrator.practice.worker.view.WorkerView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/employee", produces = APPLICATION_JSON_VALUE)
public class WorkerControllerImpl implements WorkerController{

    private final WorkerService wrkService;

    @Autowired
    public WorkerControllerImpl(WorkerService wrkService){
        this.wrkService = wrkService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ApiOperation(value = "Filters Employees by Office id and other parameters", responseContainer = "List", httpMethod = "POST")
    @RequestMapping(value = "/list", method = {POST})
    public List<WorkerFilterOutView> filterByOfficeId(@RequestBody WorkerFilterInView inView) {

        return wrkService.filterByOfficeId(inView);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ApiOperation(value = "Loads Worker by id", httpMethod = "GET")
    @RequestMapping(value = "/{id}", method = {GET})
    public WorkerView loadById(@PathVariable(value = "id") String id) {

        return wrkService.loadById(id);
    }
}
