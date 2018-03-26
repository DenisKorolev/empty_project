package ru.bellintegrator.practice.office.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.bellintegrator.practice.common.view.ResultView;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.view.*;

import java.util.List;

public interface OfficeController {

    /**
     * Filters Office objects by Organization id and other parameters
     * @param officeView Office view object to map request fields
     * @return List of Office views if any
     */
    List<OfficeFilterOutView> filterByOrgId(@RequestBody OfficeFilterView officeView);

    /**
     * Gets Office object by id
     * @param id Office id
     * @return Office view object if any
     */
    OfficeView loadById(@PathVariable(value = "id") String id);

    /**
     * Updates Office in DB
     * @param officeView Office view object to map request fields
     */
    ResultView updateById(@RequestBody OfficeView officeView);

    /**
     * Deletes Office in DB by id
     * @param id Office id to delete
     */
    ResultView deleteById(@PathVariable(value = "id") String id);

    /**
     * Adds Office to DB
     * @param officeView Office view object to map request fields
     */
    OfficeIdOutView save(@RequestBody OfficeIdView officeView);
}
