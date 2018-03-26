package ru.bellintegrator.practice.organization.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import ru.bellintegrator.practice.organization.view.*;

import java.util.List;

public interface OrganizationController {

    /**
     * Filters Organization objects by org name and other parameters
     * @param inView View to map request fields
     * @return List of Org views if any
     */
    List<OrganizationFilterOutView> filterByName(@RequestBody OrganizationFilterInView inView);

    /**
     * Loads Org object by org id
     * @param id
     * @return Org view if any
     */
    OrganizationView loadById(@PathVariable(value = "id") String id);

    /**
     * Updates Org in DB by id
     * @param inView request mapping
     */
    void updateById(@RequestBody OrganizationView inView);

    /**
     * Adds Org to DB
     * @param inView request mapping
     * @return Org view
     */
    public OrganizationIdOutView save(@RequestBody OrganizationSaveView inView);

    /**
     * Deletes Org in DB by id
     * @param id Org id
     */
    void deleteById(@PathVariable(value = "id") String  id);


}
