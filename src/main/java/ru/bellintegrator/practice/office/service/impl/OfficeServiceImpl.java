package ru.bellintegrator.practice.office.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.common.exception.EntityDoesNotExistException;
import ru.bellintegrator.practice.common.exception.FieldIsNotDataTypeException;
import ru.bellintegrator.practice.common.exception.RequiredFieldIsNullException;
import ru.bellintegrator.practice.common.util.ValidationUtils;
import ru.bellintegrator.practice.office.dao.OfficeDAO;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.service.OfficeService;
import ru.bellintegrator.practice.office.view.*;
import ru.bellintegrator.practice.organization.dao.OrganizationDAO;
import ru.bellintegrator.practice.organization.model.Organization;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class OfficeServiceImpl implements OfficeService {

    private final Logger log = LoggerFactory.getLogger(OfficeServiceImpl.class);

    private final OfficeDAO dao;

    private final OrganizationDAO orgDAO;

    @Autowired
    public OfficeServiceImpl(OfficeDAO dao, OrganizationDAO orgDAO){
        this.dao = dao;
        this.orgDAO = orgDAO;
    }



    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<OfficeFilterOutView> filterByOrgId(OfficeFilterView officeView) {

        //Validation
        //Checks if orgId request field is not null
        if ((officeView.orgId == null) || (officeView.orgId.isEmpty()))
            throw new RequiredFieldIsNullException("orgId");
        //Checks if id request field is Long
        try {
            Long.parseLong(officeView.orgId);
        }
        catch (Exception ex){
            throw new FieldIsNotDataTypeException("id", "Long");
        }

        //Checks if isActive boolean
        if ((officeView.isActive != null) && (!officeView.isActive.isEmpty()))
            if (!ValidationUtils.isStringBoolean(officeView.isActive))
                throw new FieldIsNotDataTypeException("isActive", "Boolean");


        Organization org = orgDAO.loadById(Long.parseLong(officeView.orgId));
        if (org == null) throw new EntityDoesNotExistException("Organization", officeView.orgId);

        Organization organization = new Organization();
        organization.setId(Long.parseLong(officeView.orgId));

        Office office = new Office();
        office.setOrganization(organization);
        office.setOfficeName(officeView.name);
        office.setOfficePhone(officeView.phone);
        //Set Office isActive
        if ((officeView.isActive != null) && (!officeView.isActive.isEmpty()))
            office.setOfficeActive(Boolean.parseBoolean(officeView.isActive));

        List<Office> all = dao.filterByOrgId(office);
        List<OfficeFilterOutView> officeViews = new ArrayList<>();

        for (Office officeLoop:all) {
            OfficeFilterOutView view = new OfficeFilterOutView(officeLoop.getId().toString(), officeLoop.getOfficeName(),
                    officeLoop.getOrganization().getOrgName(), officeLoop.getOfficeActive().toString());
            officeViews.add(view);

            log.info(view.toString());
        }

        return officeViews;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public OfficeView loadById(String id) {

        //Validation
        //Checks if id request field is not null
        if ((id == null) || id.isEmpty())
            throw new RequiredFieldIsNullException("id");
        //Checks if id request field is Long
        try {
            Long.parseLong(id);
        }
        catch (Exception ex){
            throw new FieldIsNotDataTypeException("id", "Long");
        }


        Office office = dao.loadById(Long.parseLong(id));

        //Checks if Office exists
        ValidationUtils.checkEntityExists(office, "Office", id);

        OfficeView view = new OfficeView(office.getId().toString(), office.getOrganization().getId().toString(),
                office.getOfficeName(), office.getOfficeAddress(), office.getOfficePhone(), office.getOfficeActive().toString());

        log.info(view.toString());

        return view;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void updateById(OfficeView officeView) {

        //Validation
        //Checks if id request field is not null
        if ((officeView.getId() == null) || (officeView.getId().isEmpty()))
            throw new RequiredFieldIsNullException("id");
        //Checks if id request field is Long
        try {
            Long.parseLong(officeView.getId());
        }
        catch (Exception ex){
            throw new FieldIsNotDataTypeException("id", "Long");
        }

        //Checks if isActive request field is boolean
        if ((officeView.getIsActive() != null) && (!officeView.getIsActive().isEmpty()))
            if (!ValidationUtils.isStringBoolean(officeView.getIsActive()))
                throw new FieldIsNotDataTypeException("isActive", "Boolean");


        Office office = dao.loadById(Long.parseLong(officeView.getId()));
        //Checks if Office exists
        if (office == null)
            throw new EntityDoesNotExistException("Office", officeView.getId());

        if ((officeView.getName() != null) && (!officeView.getName().isEmpty()))
            office.setOfficeName(officeView.getName());

        if ((officeView.getAddress() != null) && (!officeView.getAddress().isEmpty()))
            office.setOfficeAddress(officeView.getAddress());

        if ((officeView.getPhone() != null) && (!officeView.getPhone().isEmpty()))
            office.setOfficePhone(officeView.getPhone());

        //Set Office isActive
        if ((officeView.getIsActive() != null) && (!officeView.getIsActive().isEmpty()))
            office.setOfficeActive(Boolean.parseBoolean(officeView.getIsActive()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public void deleteById(String id) {

        //Validation
        //Checks if id request field is not null
        if ((id == null) || id.isEmpty())
            throw new RequiredFieldIsNullException("id");
        //Checks if id request field is Long
        try {
            Long.parseLong(id);
        }
        catch (Exception ex){
            throw new FieldIsNotDataTypeException("id", "Long");
        }


        Office office = dao.loadById(Long.parseLong(id));

        //Checks if Office exists
        if (office == null)
            throw new EntityDoesNotExistException("Office", id);

        dao.deleteById(office);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public OfficeIdOutView save(OfficeIdView officeView) {

        //Validation
        //Checks if name request field is not null
        if ((officeView.getName() == null) || officeView.getName().isEmpty())
            throw new RequiredFieldIsNullException("name");

        //Checks if orgId request field is not null
        if ((officeView.getOrgId() == null) || officeView.getOrgId().isEmpty())
            throw new RequiredFieldIsNullException("orgId");
        //Checks if orgId request field is Long
        try {
            Long.parseLong(officeView.getOrgId());
        }
        catch (Exception ex){
            throw new FieldIsNotDataTypeException("orgId", "Long");
        }

        //Checks if address request field is not null
        if ((officeView.getAddress() == null) || officeView.getAddress().isEmpty())
            throw new RequiredFieldIsNullException("name");

        //Checks if isActive request field is boolean
        if ((officeView.getActive() != null) && (!officeView.getActive().isEmpty()))
            if (!ValidationUtils.isStringBoolean(officeView.getActive()))
                throw new FieldIsNotDataTypeException("isActive", "Boolean");


        Office office = new Office();

        Organization org = orgDAO.loadById(Long.parseLong(officeView.getOrgId()));
        if (org == null)
            throw new EntityDoesNotExistException("Organization", officeView.getOrgId());

        //Obligatory part
        //Set Office name
        office.setOfficeName(officeView.getName());
        //Set orgId
        office.setOrganization(org);
        //Set Office address
        office.setOfficeAddress(officeView.getAddress());

        //Optional part
        //Set Office phone
        if ((officeView.getPhone() != null) && (!officeView.getPhone().isEmpty()))
            office.setOfficePhone(officeView.getPhone());
        //Set Office isActive
        if ((officeView.getActive() == null) || (officeView.getActive().isEmpty()))
            office.setOfficeActive(true);
        else
            office.setOfficeActive(Boolean.parseBoolean(officeView.getActive()));

        dao.save(office);

        OfficeIdOutView outView = new OfficeIdOutView(office.getId().toString());
        officeView.setId(office.getId());
        return outView;
    }
}
