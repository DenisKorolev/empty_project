package ru.bellintegrator.practice.organization.dao;

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
import ru.bellintegrator.practice.organization.model.Organization;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class OrganizationDAOTest {

    @Autowired
    private OrganizationDAO orgDAO;

    @Test
    public void filterByName() {
        Organization org = new Organization();
        org.setOrgName("Гугл");

        List<Organization> orgs = orgDAO.filterByName(org);
        Assert.assertEquals(1, orgs.size());
    }

    @Test
    public void loadById() {
    }

    @Test
    public void updateById() {
    }

    @Test
    public void save() {
    }

    @Test
    public void deleteById() {
    }
}
