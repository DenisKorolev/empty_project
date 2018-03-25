package ru.bellintegrator.practice.office.service;

import ru.bellintegrator.practice.office.view.OfficeFilterOutView;
import ru.bellintegrator.practice.office.view.OfficeFilterView;
import ru.bellintegrator.practice.office.view.OfficeIdView;
import ru.bellintegrator.practice.office.view.OfficeView;

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
    OfficeView loadById(Long id);

    /**
     * Updates Office in DB
     * @param officeView Request mapping
     */
    void updateById(OfficeView officeView);

    /**
     * Deletes Office by id
     * @param id Office id
     */
    void deleteById(Long id);

    /**
     * Adds Office to db
     * @param officeView Request mapping
     * @return JSON Office id value
     */
    OfficeIdView save(OfficeIdView officeView);
}
