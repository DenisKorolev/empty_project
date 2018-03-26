package ru.bellintegrator.practice.office.controller.impl;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.common.exception.FieldIsNotBooleanException;
import ru.bellintegrator.practice.common.exception.FieldIsNotLongException;
import ru.bellintegrator.practice.common.view.ResultView;
import ru.bellintegrator.practice.office.controller.OfficeController;
import ru.bellintegrator.practice.common.exception.RequiredFieldIsNullException;
import ru.bellintegrator.practice.office.service.OfficeService;
import ru.bellintegrator.practice.office.view.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/office", produces = APPLICATION_JSON_VALUE)
public class OfficeControllerImpl implements OfficeController {

    private final OfficeService officeService;

    @Autowired
    public OfficeControllerImpl(OfficeService officeService){
        this.officeService = officeService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ApiOperation(value = "Filters Offices by OrgId and other parameters", responseContainer = "List", httpMethod = "POST")
    @RequestMapping(value = "/list", method = {POST})
    public List<OfficeFilterOutView> filterByOrgId(@RequestBody OfficeFilterView officeView) {

        //Checks if orgId request field is not null
        if ((officeView.orgId == null) || (officeView.orgId.isEmpty()))
            throw new RequiredFieldIsNullException("orgId");

        //TODO: delete
        //Checks if isActive boolean
        if ((officeView.isActive != null) && (!officeView.isActive.isEmpty()))
            try {
                Boolean.parseBoolean(officeView.isActive);
            }
            catch (Exception ex){
                throw new FieldIsNotBooleanException("isActive");
            }

        return officeService.filterByOrgId(officeView);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ApiOperation(value = "Loads Office by id", httpMethod = "GET")
    @RequestMapping(value = "/{id}", method = {GET})
    public OfficeView loadById(@PathVariable(value = "id") String id) {

        //Checks if id request field is not null
        if ((id == null) || id.isEmpty())
            throw new RequiredFieldIsNullException("id");

        //Checks if id request field is Long
        try {
            Long.parseLong(id);
        }
        catch (Exception ex){
            throw new FieldIsNotLongException("id");
        }

        return officeService.loadById(Long.parseLong(id));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ApiOperation(value = "Updates Office by id", httpMethod = "POST")
    @RequestMapping(value = "/update", method = {POST})
    public ResultView updateById(@RequestBody OfficeView officeView) {

        //Checks if id request field is not null
        if ((officeView.getId() == null) || (officeView.getId().isEmpty()))
            throw new RequiredFieldIsNullException("id");

        //Checks if id request field is Long
        try {
            Long.parseLong(officeView.getId());
        }
        catch (Exception ex){
            throw new FieldIsNotLongException("id");
        }

        //TODO: delete
        //Checks if isActive boolean
        if ((officeView.getIsActive() != null) && (!officeView.getIsActive().isEmpty()))
            try {
                Boolean.parseBoolean(officeView.getIsActive());
            }
            catch (Exception ex){
                throw new FieldIsNotBooleanException("isActive");
            }

        officeService.updateById(officeView);
        return new ResultView("success");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ApiOperation(value = "Deletes Office by id", httpMethod = "POST")
    @RequestMapping(value = "/delete/{id}", method = {POST})
    public ResultView deleteById(@PathVariable(value = "id") String id) {

        //Checks if id request field is not null
        if ((id == null) || id.isEmpty())
            throw new RequiredFieldIsNullException("id");

        //Checks if id request field is Long
        try {
            Long.parseLong(id);
        }
        catch (Exception ex){
            throw new FieldIsNotLongException("id");
        }

        officeService.deleteById(Long.parseLong(id));
        return new ResultView("success");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ApiOperation(value = "Adds new Office", httpMethod = "POST")
    @RequestMapping(value = "/create", method = {POST})
    public OfficeIdOutView save(@RequestBody OfficeIdView officeView) {

        //Checks if name request field is not null
        if ((officeView.getName() == null) || officeView.getName().isEmpty())
            throw new RequiredFieldIsNullException("name");

        //Checks if orgId request field is not null
        if ((officeView.getOrgId() == null) || officeView.getOrgId().isEmpty())
            throw new RequiredFieldIsNullException("orgId");
        //Checks if orgId request field is Long
        try {
            Long.parseLong(officeView.getOrgId());
        }
        catch (Exception ex){
            throw new FieldIsNotLongException("orgId");
        }

        //Checks if address request field is not null
        if ((officeView.getAddress() == null) || officeView.getAddress().isEmpty())
            throw new RequiredFieldIsNullException("name");

        //TODO: delete
        //Checks if isActive request field boolean
        if ((officeView.getActive() != null) && (!officeView.getActive().isEmpty()))
            try {
                Boolean.parseBoolean(officeView.getActive());
            }
            catch (Exception ex){
                throw new FieldIsNotBooleanException("isActive");
            }

        return officeService.save(officeView);
    }
}
