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
    Office loadByOrgId(Long orgId);


    /**
     * Updates Office in DB by id
     * @param id Office id
     * @param officeName Office name
     * @param officeAddress Office address
     * @param officePhone Office phone
     * @param isOfficeActive Is Office Active parameter
     */
    void updateById(Long id, String officeName, String officeAddress, String officePhone, Boolean isOfficeActive);


    /**
     * Deletes Office from DB by id
     * @param id Office id
     */
    void deleteById(Long id);


    /**
     * Adds Office to DB
     * @param officeName Office name
     * @param officeAddress Office address
     * @param officePhone Office phone
     * @param isOfficeActive Is Office Active parameter
     */
    void save(String officeName, String officeAddress, String officePhone, Boolean isOfficeActive);
}
