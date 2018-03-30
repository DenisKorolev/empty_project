package ru.bellintegrator.practice.worker.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.common.advice.WebRestControllerAdvice;
import ru.bellintegrator.practice.common.exception.EntityDoesNotExistException;
import ru.bellintegrator.practice.country.dao.CountryDAO;
import ru.bellintegrator.practice.country.model.Country;
import ru.bellintegrator.practice.office.dao.OfficeDAO;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.worker.dao.WorkerDAO;
import ru.bellintegrator.practice.worker.model.Worker;
import ru.bellintegrator.practice.worker.service.WorkerService;
import ru.bellintegrator.practice.worker.view.WorkerFilterInView;
import ru.bellintegrator.practice.worker.view.WorkerFilterOutView;
import ru.bellintegrator.practice.worker.view.WorkerView;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WorkerServiceImpl implements WorkerService{

    private final Logger log = LoggerFactory.getLogger(WorkerServiceImpl.class);

    private final WorkerDAO dao;

    private final OfficeDAO officeDAO;

    private final CountryDAO countryDAO;

    @Autowired
    public WorkerServiceImpl(WorkerDAO dao, OfficeDAO officeDAO, CountryDAO countryDAO){
        this.dao = dao;
        this.officeDAO = officeDAO;
        this.countryDAO = countryDAO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<WorkerFilterOutView> filterByOfficeId(WorkerFilterInView inView) {

        Worker worker = new Worker();

        //Checks if Office id request field is not null and is Long
        WebRestControllerAdvice.checkFieldOnNullAndNotLong(inView.getOfficeId(), "officeId");

        Office office = officeDAO.loadById(Long.parseLong(inView.getOfficeId()));

        //Checks if Office exist
        if (office == null)
            throw new EntityDoesNotExistException("Office", inView.getOfficeId());

        //Checks if Country with citizenship code request field exists and citizenship code is Long
        if ((inView.getCitizenshipCode() != null) && (!inView.getCitizenshipCode().isEmpty())){
            if (WebRestControllerAdvice.isFieldLong(inView.getCitizenshipCode(), "citizenshipCode")) {

                Country country;

                try {
                    country = countryDAO.loadByCountryCode(Long.parseLong(inView.getCitizenshipCode()));
                }
                catch (EmptyResultDataAccessException ex){
                    throw new EntityDoesNotExistException("Country", "citizenshipCode", inView.getCitizenshipCode());
                }

                //Set Country
                worker.setCountry(country);
            }
        }


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

            String fullName = workerLoop.getLastName() + " " + workerLoop.getFirstName() +
                    " " + workerLoop.getMiddleName();

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
        return null;
    }
}
