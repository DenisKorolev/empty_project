package ru.bellintegrator.practice.organization.controller.impl;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.common.view.ResultView;
import ru.bellintegrator.practice.organization.controller.OrganizationController;
import ru.bellintegrator.practice.organization.service.OrganizationService;
import ru.bellintegrator.practice.organization.view.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationControllerImpl implements OrganizationController {

    private final OrganizationService orgService;

    @Autowired
    public OrganizationControllerImpl(OrganizationService orgService){
        this.orgService = orgService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ApiOperation(value = "Filters Orgs by org name and other parameters", responseContainer = "List", httpMethod = "POST")
    @RequestMapping(value = "/list", method = {POST})
    public List<OrganizationFilterOutView> filterByName(@RequestBody OrganizationFilterInView inView) {

        return orgService.filterByName(inView);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ApiOperation(value = "Loads Org by id", httpMethod = "GET")
    @RequestMapping(value = "/{id}", method = {GET})
    public OrganizationView loadById(@PathVariable(value = "id") String id) {

        return orgService.loadById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ApiOperation(value = "Updates Org by id", httpMethod = "POST")
    @RequestMapping(value = "/update", method = {POST})
    public ResultView updateById(@RequestBody OrganizationView inView) {

        orgService.updateById(inView);
        return new ResultView("success");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ApiOperation(value = "Adds Org to DB", httpMethod = "POST")
    @RequestMapping(value = "/create", method = {POST})
    public OrganizationIdOutView save(@RequestBody OrganizationSaveView inView) {

        return orgService.save(inView);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ApiOperation(value = "Deletes Org by id", httpMethod = "POST")
    @RequestMapping(value = "/delete/{id}", method = {POST})
    public ResultView deleteById(@PathVariable(value = "id") String id) {

        orgService.deleteById(id);
        return new ResultView("success");
    }
}
