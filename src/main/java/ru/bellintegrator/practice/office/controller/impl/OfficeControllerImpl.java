package ru.bellintegrator.practice.office.controller.impl;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.office.controller.OfficeController;
import ru.bellintegrator.practice.office.service.OfficeService;
import ru.bellintegrator.practice.office.view.OfficeFilterView;
import ru.bellintegrator.practice.office.view.OfficeView;

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
    public List<OfficeFilterView> filterByOrgId(@RequestBody OfficeFilterView officeView) {
        return officeService.filterByOrgId(officeView);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ApiOperation(value = "Loads Office by id", httpMethod = "GET")
    @RequestMapping(value = "/{id}", method = {GET})
    public OfficeView loadById(@PathVariable(value = "id") Long id) {
        return officeService.loadById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ApiOperation(value = "Updates Office by id", httpMethod = "POST")
    @RequestMapping(value = "/update", method = {POST})
    public void updateById(@RequestBody OfficeView officeView) {
        officeService.updateById(officeView);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ApiOperation(value = "Deletes Office by id", httpMethod = "POST")
    @RequestMapping(value = "/delete/{id}", method = {POST})
    public void deleteById(@PathVariable(value = "id") Long id) {
        officeService.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ApiOperation(value = "Adds new Office", httpMethod = "POST")
    @RequestMapping(value = "/create", method = {POST})
    public void save(OfficeView officeView) {

    }
}
