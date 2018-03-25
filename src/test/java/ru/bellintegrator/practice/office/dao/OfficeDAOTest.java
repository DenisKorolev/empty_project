package ru.bellintegrator.practice.office.dao;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.Application;
import ru.bellintegrator.practice.office.model.Office;
import ru.bellintegrator.practice.organization.dao.OrganizationDAO;
import ru.bellintegrator.practice.organization.model.Organization;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OfficeDAOTest {

    @Autowired
    private OfficeDAO officeDAO;

    @Autowired
    private OrganizationDAO orgDAO;

    @Test
    public void filterByOrgId() {
        Organization org = new Organization();
        org.setId(3L);
        Office office = new Office();
        office.setOrganization(org);

        List<Office> offices = officeDAO.filterByOrgId(office);
        Assert.assertEquals(3, offices.size());
    }

    @Test
    public void deleteById(){
        Office office = officeDAO.loadById(2L);
        officeDAO.deleteById(office);

        List<Office> offices = officeDAO.all();
        Assert.assertEquals(4, offices.size());
    }

    @Test
    public void save(){
        Organization org = orgDAO.loadById(2L);

        Office office = new Office();
        office.setOrganization(org);
        office.setOfficeName("Test office");
        office.setOfficeAddress("Test address");
        office.setOfficePhone("Test phone");
        office.setOfficeActive(true);

        officeDAO.save(office);

        List<Office> offices = officeDAO.all();
        Assert.assertEquals(6, offices.size());
    }
}
