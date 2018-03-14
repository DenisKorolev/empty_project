package ru.bellintegrator.practice.office.dao;

import ru.bellintegrator.practice.office.model.Office;

import java.util.List;

public interface OfficeDAO {

    /**
     * Gets all Office objects
     * @return List of Office objects if any
     */
    List<Office> all();


    /**
     * Gets Office object by id
     * @param id Office id
     * @return Office object if any
     */
    Office loadById(Long id);


    /**
     * Gets Office object by Organization id
     * @param orgId Organization id
     * @return
     */
    Office loadByOrgId(Long orgId, String officeName, String officePhone, Boolean isOfficeActive);


    /**
     * Updates Office in DB
     * @param office Office object to update
     */
    void updateById(Office office);


    /**
     * Deletes Office from DB
     * @param office Office object to delete
     */
    void deleteById(Office office);


    /**
     * Adds Office to DB
     * @param office Office object to add
     */
    void save(Office office);
}
