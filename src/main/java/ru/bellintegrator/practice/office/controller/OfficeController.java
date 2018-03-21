package ru.bellintegrator.practice.office.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.view.OfficeView;

import java.util.List;

public interface OfficeController {

    /**
     * Filters Office objects by Organization id and other parameters
     * @param officeView Office view object to map request fields
     * @return List of Office views if any
     */
    List<OfficeView> filterByOrgId(@RequestBody OfficeView officeView);

    /**
     * Gets Office object by id
     * @param id Office id
     * @return Office view object if any
     */
    OfficeView loadById(@PathVariable(value = "id") Long id);

    /**
     * Updates Office in DB
     * @param officeView Office view object to map request fields
     */
    void updateById(@RequestBody OfficeView officeView);

    /**
     * Deletes Office in DB by id
     * @param id Office id to delete
     */
    void deleteById(@PathVariable(value = "id") Long id);

    /**
     * Adds Office to DB
     * @param officeView Office view object to map request fields
     */
    void save(@RequestBody OfficeView officeView);
}
