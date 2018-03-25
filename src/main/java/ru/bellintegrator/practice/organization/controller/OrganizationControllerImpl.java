package ru.bellintegrator.practice.organization.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.organization.service.OrganizationService;
import ru.bellintegrator.practice.organization.view.OrganizationFilterInView;
import ru.bellintegrator.practice.organization.view.OrganizationFilterOutView;
import ru.bellintegrator.practice.organization.view.OrganizationView;

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

    @Override
    @ApiOperation(value = "Loads Org by id", httpMethod = "POST")
    @RequestMapping(value = "/update", method = {POST})
    public void updateById(@RequestBody OrganizationView inView) {
        orgService.updateById(inView);
    }
}
