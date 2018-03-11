package ru.bellintegrator.practice.country.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.Application;
import ru.bellintegrator.practice.country.dao.CountryDAO;
import ru.bellintegrator.practice.country.model.Country;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {Application.class})
@WebAppConfiguration(value = "src/main/resources")
@Transactional
@DirtiesContext
public class CountryDAOTest {

    @Autowired
    private CountryDAO countryDAO;

    @Test
    public void all() {
        System.out.println("Test 1");
        List<Country> countries = countryDAO.all();
    }

    @Test
    public void loadById() {
        System.out.println("Test 2");
        Country  country = countryDAO.loadById(new Long(1));
    }
}