package ru.bellintegrator.practice.worker.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.common.exception.EntityDoesNotExistException;
import ru.bellintegrator.practice.common.util.ValidationUtils;
import ru.bellintegrator.practice.country.dao.CountryDAO;
import ru.bellintegrator.practice.country.model.Country;
import ru.bellintegrator.practice.doc.dao.DocDAO;
import ru.bellintegrator.practice.doc.model.Doc;
import ru.bellintegrator.practice.office.dao.OfficeDAO;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.worker.dao.WorkerDAO;
import ru.bellintegrator.practice.worker.model.Worker;
import ru.bellintegrator.practice.worker.service.WorkerService;
import ru.bellintegrator.practice.worker.view.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService{

    private final Logger log = LoggerFactory.getLogger(WorkerServiceImpl.class);

    private final WorkerDAO dao;

    private final OfficeDAO officeDAO;

    private final CountryDAO countryDAO;

    private final DocDAO docDAO;

    @Autowired
    public WorkerServiceImpl(WorkerDAO dao, OfficeDAO officeDAO, CountryDAO countryDAO, DocDAO docDAO){
        this.dao = dao;
        this.officeDAO = officeDAO;
        this.countryDAO = countryDAO;
        this.docDAO = docDAO;
    }

    private Country checkCountryExistOnCitizenshipCode(String citizenshipCode){
        Country country = null;

        if (!ValidationUtils.isStringNullOrEmpty(citizenshipCode)){
            if (ValidationUtils.isFieldLong(citizenshipCode, "citizenshipCode")) {

                try {
                    country = countryDAO.loadByCountryCode(Long.parseLong(citizenshipCode));
                }
                catch (EmptyResultDataAccessException ex){
                    throw new EntityDoesNotExistException("Country", "citizenshipCode", citizenshipCode);
                }

            }
        }
        return country;
    }

    private Doc checksDocExistOnDocNumber(String docNumber){
        Doc doc = null;

        ValidationUtils.checkFieldOnNullOrEmpty(docNumber, "docCode");

        if (ValidationUtils.isFieldLong(docNumber, "docCode")){

            try {
                doc = docDAO.loadByDocNumber(docNumber);
            }
            catch (EmptyResultDataAccessException ex){
                throw new EntityDoesNotExistException("Doc Type", "docCode", docNumber);
            }
        }

        return doc;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<WorkerFilterOutView> filterByOfficeId(WorkerFilterInView inView) {

        Worker worker = new Worker();

        //Checks if Office id request field is not null and is Long
        ValidationUtils.checkFieldOnNullAndNotLong(inView.getOfficeId(), "officeId");

        Office office = officeDAO.loadById(Long.parseLong(inView.getOfficeId()));

        //Checks if Office exist
        if (office == null)
            throw new EntityDoesNotExistException("Office", inView.getOfficeId());


        //Checks if Country with citizenship code request field exists and citizenship code is Long
        Country country = checkCountryExistOnCitizenshipCode(inView.getCitizenshipCode());

        //Set Country
        if (country != null)
            worker.setCountry(country);


        //Set Office
        worker.setOffice(office);

        //Set first name
        if ((inView.getFirstName() != null) && (!inView.getFirstName().isEmpty()))
            worker.setFirstName(inView.getFirstName());
        //Set last name
        if ((inView.getLastName() != null) && (!inView.getLastName().isEmpty()))
            worker.setLastName(inView.getLastName());
        //Set middle name
        if ((inView.getMiddleName() != null) && (!inView.getMiddleName().isEmpty()))
            worker.setMiddleName(inView.getMiddleName());
        //Set position
        if ((inView.getPosition() != null) && (!inView.getPosition().isEmpty()))
            worker.setPosition(inView.getPosition());

        List<Worker> all = dao.filterByOfficeId(worker);
        List<WorkerFilterOutView> outViews = new ArrayList<>();

        for (Worker workerLoop:all){

            String fullName = workerLoop.getLastName() + " " + workerLoop.getFirstName();

            if (!ValidationUtils.isStringNullOrEmpty(workerLoop.getMiddleName()))
                fullName = fullName + " " + workerLoop.getMiddleName();

            WorkerFilterOutView outView = new WorkerFilterOutView(workerLoop.getId().toString(), fullName, workerLoop.getPosition(),
                    workerLoop.getOffice().getOfficeName());
            outViews.add(outView);

            log.info(outView.toString());
        }

        return outViews;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public WorkerView loadById(String id) {

        ValidationUtils.checkFieldOnNullAndNotLong(id, "id");

        Worker worker = dao.loadById(Long.parseLong(id));;

        //Checks if Employee exists
        ValidationUtils.checkEntityExists(worker, "Employee", id);

        String middleName = null;

        String position = null;

        String salary = null;
        if (worker.getSalary() != null)
            salary = String.format("%.2f", worker.getSalary());

        String regDate = null;
        if (worker.getRegistrationDate() != null)
            regDate = new SimpleDateFormat("yyyy-MM-dd").format(worker.getRegistrationDate());

        String phone = null;

        String docDate = null;
        if (worker.getDocDate() != null)
            docDate = new SimpleDateFormat("yyyy-MM-dd").format(worker.getDocDate());

        String countryCode = null;
        String countryName = null;
        if (worker.getCountry() != null) {
            countryCode = worker.getCountry().getCountryCode().toString();
            countryName = worker.getCountry().getCountryName();
        }





        WorkerView view = new WorkerView(worker.getId().toString(), worker.getOffice().getId().toString(),
                worker.getFirstName(), worker.getLastName(), worker.getMiddleName(), worker.getPosition(), salary,
                regDate, worker.getPhone(), worker.getDoc().getDocNumber(), worker.getDoc().getDocName(),
                worker.getDocNumber(), docDate, countryCode, countryName);

        log.info(view.toString());

        return view;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateById(WorkerUpdateInView inView) {

        //Checks if Employee id request field is not null and is Long
        ValidationUtils.checkFieldOnNullAndNotLong(inView.getId(), "id");

        Worker worker = dao.loadById(Long.parseLong(inView.getId()));

        //Checks if Employee exist
        if (worker == null)
            throw new EntityDoesNotExistException("Employee", inView.getId());

        //Set Employee first name
        if (!ValidationUtils.isStringNullOrEmpty(inView.getFirstName())){
            worker.setFirstName(inView.getFirstName());
        }

        //Set Employee second name
        if (!ValidationUtils.isStringNullOrEmpty(inView.getSecondName())){
            worker.setLastName(inView.getSecondName());
        }

        //Set Employee middle name
        if (!ValidationUtils.isStringNullOrEmpty(inView.getMiddleName())){
            worker.setMiddleName(inView.getMiddleName());
        }

        //Set Employee position
        if (!ValidationUtils.isStringNullOrEmpty(inView.getPosition())){
            worker.setPosition(inView.getPosition());
        }

        //Checks if Employee salary request field is Float
        if (!ValidationUtils.isStringNullOrEmpty(inView.getSalary())) {
            ValidationUtils.checkFieldOnNotFloat(inView.getSalary(), "salary");
            //Set Employee salary
            worker.setSalary(Float.parseFloat(inView.getSalary()));
        }

        //Checks if Employee registration date is Date
        if (!ValidationUtils.isStringNullOrEmpty(inView.getRegistrationDate())){
            Date registrationDate = ValidationUtils.checkFieldOnNotDate(inView.getRegistrationDate(), "registrationDate");
            //Set Employee registration date
            worker.setRegistrationDate(registrationDate);
        }

        //Set Employee phone number
        if (!ValidationUtils.isStringNullOrEmpty(inView.getPhone())){
            worker.setPhone(inView.getPhone());
        }

        //Checks if Employee Doc Type code is Long

        if (!ValidationUtils.isStringNullOrEmpty(inView.getDocCode())){

            if (ValidationUtils.isFieldLong(inView.getDocCode(), "docCode")){

                Doc doc;

                try {
                    doc = docDAO.loadByDocNumber(inView.getDocCode());
                }
                catch (EmptyResultDataAccessException ex){
                    throw new EntityDoesNotExistException("Doc Type", "docCode", inView.getDocCode());
                }

                //Set Doc Type
                worker.setDoc(doc);
            }

        }

        //Set Employee doc number
        if (!ValidationUtils.isStringNullOrEmpty(inView.getDocNumber())){
            worker.setDocNumber(inView.getDocNumber());
        }

        //Checks if Employee document date is Date
        if (!ValidationUtils.isStringNullOrEmpty(inView.getDocDate())){
            Date docDate = ValidationUtils.checkFieldOnNotDate(inView.getDocDate(), "docDate");
            //Set Employee registration date
            worker.setDocDate(docDate);
        }

        //Checks if Country with citizenship code request field exists and citizenship code is Long
        Country country = checkCountryExistOnCitizenshipCode(inView.getCitizenshipCode());
        //Set Country
        if (country != null)
            worker.setCountry(country);


    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void deleteById(String id) {

        ValidationUtils.checkFieldOnNullAndNotLong(id, "id");

        Worker worker = dao.loadById(Long.parseLong(id));

        ValidationUtils.checkEntityExists(worker, "Employee", id);

        Office office = worker.getOffice();
        office.removeWorker(worker);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public WorkerIdOutView save(WorkerSaveView inView) {

        Worker worker = new Worker();


        //Obligatory part

        //Checks if Office id request field is not null and is Long
        ValidationUtils.checkFieldOnNullAndNotLong(inView.getOfficeId(), "officeId");

        Office office = officeDAO.loadById(Long.parseLong(inView.getOfficeId()));

        //Checks if Office exist
        if (office == null)
            throw new EntityDoesNotExistException("Office", inView.getOfficeId());

        //Set office
        worker.setOffice(office);

        //Set Employee first name
        ValidationUtils.checkFieldOnNullOrEmpty(inView.getFirstName(), "firstName");
        worker.setFirstName(inView.getFirstName());

        //Set Employee last name
        ValidationUtils.checkFieldOnNullOrEmpty(inView.getSecondName(), "secondName");
        worker.setLastName(inView.getSecondName());

        //Set Employee Doc Type code
        Doc doc = checksDocExistOnDocNumber(inView.getDocCode());
        worker.setDoc(doc);

        //Set Employee document number
        ValidationUtils.checkFieldOnNullOrEmpty(inView.getDocNumber(), "docNumber");
        worker.setDocNumber(inView.getDocNumber());

        //Set Employee document date
        ValidationUtils.checkFieldOnNullOrEmpty(inView.getDocDate(), "docDate");
        Date docDate = ValidationUtils.checkFieldOnNotDate(inView.getDocDate(), "docDate");
        worker.setDocDate(docDate);


        //Optional part

        //Set Employee middle name
        if (!ValidationUtils.isStringNullOrEmpty(inView.getMiddleName()))
            worker.setMiddleName(inView.getMiddleName());

        //Set Employee position
        if (!ValidationUtils.isStringNullOrEmpty(inView.getPosition()))
            worker.setPosition(inView.getPosition());

        //Set Employee salary
        if (!ValidationUtils.isStringNullOrEmpty(inView.getSalary())){
            ValidationUtils.checkFieldOnNotFloat(inView.getSalary(), "salary");
            worker.setSalary(Float.parseFloat(inView.getSalary()));
        }

        //Set Employee registration date
        if (!ValidationUtils.isStringNullOrEmpty(inView.getRegistrationDate())){
            Date regDate = ValidationUtils.checkFieldOnNotDate(inView.getRegistrationDate(), "registrationDate");
            worker.setRegistrationDate(regDate);
        }

        //Set Employee phone number
        if (!ValidationUtils.isStringNullOrEmpty(inView.getPhone()))
            worker.setPhone(inView.getPhone());

        //Set country
        Country country = checkCountryExistOnCitizenshipCode(inView.getCitizenshipCode());
        if (country != null)
            worker.setCountry(country);

        dao.save(worker);
        office.addWorker(worker);

        return new WorkerIdOutView(worker.getId().toString());
    }
}
