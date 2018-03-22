package ru.bellintegrator.practice.office.controller.impl;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.office.controller.OfficeController;
import ru.bellintegrator.practice.office.service.OfficeService;
import ru.bellintegrator.practice.office.view.OfficeFilterView;
import ru.bellintegrator.practice.office.view.OfficeView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
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
    public OfficeView loadById(Long id) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateById(OfficeView officeView) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(Long id) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void save(OfficeView officeView) {

    }
}
