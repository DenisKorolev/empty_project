package ru.bellintegrator.practice.office.service;

import ru.bellintegrator.practice.office.view.*;

import java.util.List;

public interface OfficeService {

    /**
     * Filters Office objects by Organization id and other parameters
     * @param officeView Request mapping
     * @return JSON Offices values
     */
    List<OfficeFilterOutView> filterByOrgId(OfficeFilterView officeView);

    /**
     * Gets Office object by id
     * @param id Office id
     * @return JSON Office value
     */
    OfficeView loadById(String id);

    /**
     * Updates Office in DB
     * @param officeView Request mapping
     */
    void updateById(OfficeView officeView);

    /**
     * Deletes Office by id
     * @param id Office id
     */
    void deleteById(String id);

    /**
     * Adds Office to db
     * @param officeView Request mapping
     * @return JSON Office id value
     */
    OfficeIdOutView save(OfficeIdView officeView);
}
