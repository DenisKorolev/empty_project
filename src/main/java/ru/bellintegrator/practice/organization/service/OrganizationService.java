package ru.bellintegrator.practice.organization.service;

import ru.bellintegrator.practice.organization.view.*;

import java.util.List;

public interface OrganizationService {

    /**
     * Filters Org objects by Org name and other parameters
     * @param inView request mapping
     * @return JSON Orgs values
     */
    List<OrganizationFilterOutView> filterByName(OrganizationFilterInView inView);

    /**
     * Loads Org object by id
     * @param id Org id
     * @return JSON Org values
     */
    OrganizationView loadById(String id);

    /**
     * Updates organization in DB
     * @param inView request mapping
     */
    void updateById(OrganizationView inView);

    /**
     * Adds Org to DB
     * @param inView request mapping
     * @return JSON Org id value
     */
    OrganizationIdOutView save(OrganizationSaveView inView);

    /**
     * Deletes Org in DB by id
     * @param id Org id
     */
    void deleteById(String id);
}
