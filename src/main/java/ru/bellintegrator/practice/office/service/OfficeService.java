package ru.bellintegrator.practice.office.service;

import ru.bellintegrator.practice.office.view.OfficeFilterView;

import java.util.List;

public interface OfficeService {

    /**
     * Filters Office objects by Organization id and other parameters
     * @param officeView
     * @return JSON Offices values
     */
    List<OfficeFilterView> filterByOrgId(OfficeFilterView officeView);
}
