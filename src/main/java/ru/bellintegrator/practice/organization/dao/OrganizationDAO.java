package ru.bellintegrator.practice.organization.dao;

import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.organization.model.Organization;

import java.util.List;

public interface OrganizationDAO {
    /**
     * Filters Organization objects
     * @param orgName Organization name
     * @param inn Organization inn
     * @param isOrgActive Is Organization Active parameter
     * @return List of Organization objects if any
     */
    List<Organization> filter(String orgName, String inn, Boolean isOrgActive);


    /**
     * Gets office object by id
     * @param id Organization id
     * @return Office object if any
     */
    Office loadById(Long id);


    /**
     * Updates Organization in DB by id
     * @param id Organization id
     * @param orgName Organization name
     * @param orgFullName Organization full name
     * @param inn Organization inn
     * @param kpp Organization kpp
     * @param orgAddress Organization address
     * @param orgPhone Organization phone
     * @param isOrgActive Is Organization Active parameter
     */
    void updateById(Long id, String orgName, String orgFullName, String inn, String kpp, String orgAddress, String orgPhone, Boolean isOrgActive);


    /**
     * Adds Organization to DB
     * @param orgName
     * @param orgFullName
     * @param inn
     * @param kpp
     * @param orgAddress
     * @param orgPhone
     * @param isOrgActive
     */
    void save(String orgName, String orgFullName, String inn, String kpp, String orgAddress, String orgPhone, Boolean isOrgActive);


    /**
     * Deletes Organization from DB by id
     * @param id Organization id
     */
    void deleteById(Long id);
}
