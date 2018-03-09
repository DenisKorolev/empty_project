package ru.bellintegrator.practice.worker.dao;

import ru.bellintegrator.practice.worker.model.Worker;

import java.util.Date;
import java.util.List;

public interface WorkerDAO {

    /**
     * Filters Worker (Employee) objects
     * @param officeId Worker Office id
     * @param firstName Worker first name
     * @param secondName Worker last name
     * @param middleName Worker middle name
     * @param position Worker position
     * @param docTypeCode Worker Document Type code
     * @param countryCitizenshipCode Worker Country code
     * @return List of filtered Worker objects if any
     */
    List<Worker> filter(Long officeId, String firstName, String secondName, String middleName, String position, String docTypeCode, String countryCitizenshipCode);


    /**
     * Gets Worker object by id
     * @param id Worker id
     * @return Worker object if any
     */
    Worker loadById(Long id);


    /**
     * Updates Worker in DB by id
     * @param id Worker id
     * @param firstName Worker first name
     * @param secondName Worker last name
     * @param middleName Worker middle name
     * @param position Worker position
     * @param phoneNumber Worker phone number
     * @param docTypeName Worker Document Type name
     * @param workerDocNumber Worker document number
     * @param workerDocDate Worker document date
     * @param countryCitizenshipName Worker Country citizenship name
     * @param countryCitizenshipCode Worker Country citizenship code
     * @param isIdentified Is Worker identified parameter
     */
    void updateById(Long id, String firstName, String secondName, String middleName, String position,
                    String phoneNumber, String docTypeName, String workerDocNumber, Date workerDocDate,
                    String countryCitizenshipName, String countryCitizenshipCode, Boolean isIdentified);


    /**
     * Deletes Worker from DB by id
     * @param id Worker id
     */
    void deleteById(Long id);


    /**
     * Adds Worker to DB
     * @param firstName Worker first name
     * @param secondName Worker last name
     * @param middleName Worker middle name
     * @param position Worker position
     * @param phoneNumber Worker phone number
     * @param docTypeNumber Worker Document Type number
     * @param docTypeName Worker Document Type name
     * @param workerDocNumber Worker document number
     * @param workerDocDate Worker document date
     * @param countryCitizenshipName Worker Country citizenship name
     * @param countryCitizenshipCode Worker Country citizenship code
     * @param isIdentified Is Worker identified parameter
     */
    void save(String firstName, String secondName, String middleName, String position,
              String phoneNumber, String docTypeNumber, String docTypeName, String workerDocNumber, Date workerDocDate,
              String countryCitizenshipName, String countryCitizenshipCode, Boolean isIdentified);
}
