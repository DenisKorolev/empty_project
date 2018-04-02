package ru.bellintegrator.practice.organization.controller.impl;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.common.advice.WebRestControllerAdvice;
import ru.bellintegrator.practice.common.exception.FieldIsNotBooleanException;
import ru.bellintegrator.practice.common.exception.FieldIsNotLongException;
import ru.bellintegrator.practice.common.exception.RequiredFieldIsNullException;
import ru.bellintegrator.practice.common.util.ValidationUtils;
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

        //Checks if Org name request field is not null
        if ((inView.getName() == null) || (inView.getName().isEmpty()))
            throw new RequiredFieldIsNullException("name");

        //Checks if isActive request field is boolean
        if ((inView.getActive() != null) && (!inView.getActive().isEmpty()))
            if (!ValidationUtils.isStringBoolean(inView.getActive()))
                throw new FieldIsNotBooleanException("isActive");

        return orgService.filterByName(inView);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ApiOperation(value = "Loads Org by id", httpMethod = "GET")
    @RequestMapping(value = "/{id}", method = {GET})
    public OrganizationView loadById(@PathVariable(value = "id") String id) {

        //Checks if Org id request field is not null
        if ((id == null) || (id.isEmpty()))
            throw new RequiredFieldIsNullException("id");
        //Checks if Org id request filed is Long
        try {
            Long.parseLong(id);
        }
        catch (Exception ex){
            throw new FieldIsNotLongException("id");
        }

        return orgService.loadById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ApiOperation(value = "Updates Org by id", httpMethod = "POST")
    @RequestMapping(value = "/update", method = {POST})
    public ResultView updateById(@RequestBody OrganizationView inView) {

        //Checks if id request field is not null
        if ((inView.getId() == null) || (inView.getId().isEmpty()))
            throw new RequiredFieldIsNullException("id");
        //Checks if id request field is Long
        try {
            Long.parseLong(inView.getId());
        }
        catch (Exception ex){
            throw new FieldIsNotLongException("id");
        }

        //Checks if isActive request field is boolean
        if ((inView.getActive() != null) && (!inView.getActive().isEmpty()))
            if (!ValidationUtils.isStringBoolean(inView.getActive()))
                throw new FieldIsNotBooleanException("isActive");

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

        //Checks if full name request field is not null
        if ((inView.getFullName() == null) || (inView.getFullName().isEmpty()))
            throw new RequiredFieldIsNullException("fullName");

        //Checks if inn request field is not null
        if ((inView.getInn() == null) || (inView.getInn().isEmpty()))
            throw new RequiredFieldIsNullException("inn");

        //Checks if kpp request field is not null
        if ((inView.getKpp() == null) || (inView.getKpp().isEmpty()))
            throw new RequiredFieldIsNullException("kpp");

        //Checks if address request field is not null
        if ((inView.getAddress() == null) || (inView.getAddress().isEmpty()))
            throw new RequiredFieldIsNullException("address");

        //Checks if isActive request field is boolean
        if ((inView.getActive() != null) && (!inView.getActive().isEmpty()))
            if (!ValidationUtils.isStringBoolean(inView.getActive()))
                throw new FieldIsNotBooleanException("isActive");

        return orgService.save(inView);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ApiOperation(value = "Deletes Org by id", httpMethod = "POST")
    @RequestMapping(value = "/delete/{id}", method = {POST})
    public ResultView deleteById(@PathVariable(value = "id") String id) {

        //Checks if Org id request field is not null
        if ((id == null) || (id.isEmpty()))
            throw new RequiredFieldIsNullException("id");
        //Checks if Org id request filed is Long
        try {
            Long.parseLong(id);
        }
        catch (Exception ex){
            throw new FieldIsNotLongException("id");
        }

        orgService.deleteById(id);

        return new ResultView("success");
    }
}
