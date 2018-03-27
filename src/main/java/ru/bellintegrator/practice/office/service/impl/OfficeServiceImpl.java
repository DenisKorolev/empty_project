package ru.bellintegrator.practice.office.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.common.exception.OrgDoesNotExistException;
import ru.bellintegrator.practice.office.dao.OfficeDAO;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.office.service.OfficeService;
import ru.bellintegrator.practice.office.view.*;
import ru.bellintegrator.practice.organization.dao.OrganizationDAO;
import ru.bellintegrator.practice.organization.dao.impl.OrganizationDAOImpl;
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
        Organization org = orgDAO.loadById(Long.parseLong(officeView.orgId));
        if (org == null) throw new OrgDoesNotExistException(officeView.orgId);

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
    public OfficeView loadById(Long id) {
        Office office = dao.loadById(id);

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
        Office office = dao.loadById(Long.parseLong(officeView.getId()));

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
    public void deleteById(Long id) {
        Office office = dao.loadById(id);
        dao.deleteById(office);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public OfficeIdOutView save(OfficeIdView officeView) {

        Office office = new Office();

        Organization org = orgDAO.loadById(Long.parseLong(officeView.getOrgId()));
        if (org == null) throw new OrgDoesNotExistException(officeView.getOrgId());

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
