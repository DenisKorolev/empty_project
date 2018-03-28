package ru.bellintegrator.practice.organization.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.common.exception.EntityDoesNotExistException;
import ru.bellintegrator.practice.common.exception.OrgDoesNotExistException;
import ru.bellintegrator.practice.office.dao.OfficeDAO;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.organization.dao.OrganizationDAO;
import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.organization.service.OrganizationService;
import ru.bellintegrator.practice.organization.view.*;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class OrganizationServiceImpl implements OrganizationService {

    private final Logger log = LoggerFactory.getLogger(OrganizationServiceImpl.class);

    private final OrganizationDAO dao;
    private final OfficeDAO officeDAO;

    @Autowired
    public OrganizationServiceImpl(OrganizationDAO dao, OfficeDAO officeDAO){
        this.dao = dao;
        this.officeDAO = officeDAO;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<OrganizationFilterOutView> filterByName(OrganizationFilterInView inView) {
        Organization org = new Organization();

        //Set Org name
        org.setOrgName(inView.getName());
        //Set Org inn
        if ((inView.getInn() != null) && (!inView.getInn().isEmpty()))
            org.setInn(inView.getInn());
        //Set Org isActive
        if ((inView.getActive() != null) && (!inView.getActive().isEmpty()))
            org.setActive(Boolean.parseBoolean(inView.getActive()));

        List<Organization> all = dao.filterByName(org);
        List<OrganizationFilterOutView> outViews = new ArrayList<>();

        for (Organization orgLoop:all) {
            //officesCount
            Organization orgId = new Organization();
            orgId.setId(orgLoop.getId());

            Office office = new Office();
            office.setOrganization(orgId);

            List<Office> allOffices = officeDAO.filterByOrgId(office);

            OrganizationFilterOutView outView = new OrganizationFilterOutView(orgLoop.getId().toString(),
                    orgLoop.getOrgName(), String.valueOf(allOffices.size()), orgLoop.getActive().toString());
            outViews.add(outView);

            log.info(outView.toString());
        }


        return outViews;
    }

    @Override
    @Transactional
    public OrganizationView loadById(String id) {
        Organization org = dao.loadById(Long.parseLong(id));

        //Checks if Org exist
        if (org == null)
            throw new EntityDoesNotExistException("Org", id);

        OrganizationView view = new OrganizationView(org.getId().toString(), org.getOrgName(), org.getOrgFullName(),
                org.getInn(), org.getKpp(), org.getAddress(), org.getPhoneNumber(), org.getActive().toString());

        log.info(view.toString());

        return view;
    }

    @Override
    @Transactional
    public void updateById(OrganizationView inView) {
        Organization org = dao.loadById(Long.parseLong(inView.getId()));

        //Checks if Org exist
        if (org == null)
            throw new EntityDoesNotExistException("Org", inView.getId());

        //Org name
        if ((inView.getName() != null) && (!inView.getName().isEmpty()))
            org.setOrgName(inView.getName());
        //Org full name
        if ((inView.getFullName() != null) && (!inView.getFullName().isEmpty()))
            org.setOrgFullName(inView.getFullName());
        //Org inn
        if ((inView.getInn() != null) && (!inView.getInn().isEmpty()))
            org.setInn(inView.getInn());
        //Org kpp
        if ((inView.getKpp() != null) && (!inView.getKpp().isEmpty()))
            org.setKpp(inView.getKpp());
        //Org address
        if ((inView.getAddress() != null) && (!inView.getAddress().isEmpty()))
            org.setAddress(inView.getAddress());
        //Org phone
        if ((inView.getPhone() != null) && (!inView.getPhone().isEmpty()))
            org.setPhoneNumber(inView.getPhone());
        //Is Org active
        if ((inView.getActive() != null) && (!inView.getActive().isEmpty()))
            org.setActive(Boolean.parseBoolean(inView.getActive()));
    }

    @Override
    @Transactional
    public OrganizationIdOutView save(OrganizationSaveView inView) {
        Organization org = new Organization();

        //Obligatory part
        //Org name
        org.setOrgName(inView.getName());
        //Org full name
        org.setOrgFullName(inView.getFullName());
        //inn
        org.setInn(inView.getInn());
        //kpp
        org.setKpp(inView.getKpp());
        //Org address
        org.setAddress(inView.getAddress());

        //Optional part
        //Org phone
        if ((inView.getPhone() != null) && (!inView.getPhone().isEmpty()))
            org.setPhoneNumber(inView.getPhone());
        //Is Org active
        if ((inView.getActive() != null) && (!inView.getActive().isEmpty()))
            org.setActive(Boolean.parseBoolean(inView.getActive()));
        else {
            org.setActive(true);
            inView.setActive("true");
        }

        log.info(inView.toString());

        dao.save(org);

        OrganizationIdOutView outView = new OrganizationIdOutView(org.getId().toString());

        return outView;
    }

    @Override
    @Transactional
    public void deleteById(String id) {
        Organization org = dao.loadById(Long.parseLong(id));

        //Checks if Org exist
        if (org == null)
            throw new EntityDoesNotExistException("Org", id);

        dao.deleteById(org);
    }
}
