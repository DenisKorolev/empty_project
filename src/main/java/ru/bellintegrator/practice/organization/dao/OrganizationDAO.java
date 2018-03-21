package ru.bellintegrator.practice.organization.dao;

import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.organization.model.Organization;

import java.util.List;

public interface OrganizationDAO {
    /**
     * Filters Organization objects by name and other parameters
     * @param organization Organization name
     * @return List of Organization objects if any
     */
    List<Organization> filterByName(Organization organization);


    /**
     * Gets organization object by id
     * @param id Organization id
     * @return Organization object if any
     */
    Organization loadById(Long id);


    /**
     * Updates Organization in DB
     * @param organization Organization object to update
     */
    void updateById(Organization organization);


    /**
     * Adds Organization to DB
     * @param organization Organization object to add
     */
    void save(Organization organization);


    /**
     * Deletes Organization from DB
     * @param organization Office object to delete
     */
    void deleteById(Organization organization);
}
