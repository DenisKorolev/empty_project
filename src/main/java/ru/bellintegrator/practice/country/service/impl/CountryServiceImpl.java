package ru.bellintegrator.practice.country.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import ru.bellintegrator.practice.country.dao.CountryDAO;
import ru.bellintegrator.practice.country.model.Country;
import ru.bellintegrator.practice.country.service.CountryService;
import ru.bellintegrator.practice.country.view.CountryView;

import java.util.ArrayList;
import java.util.List;

@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class CountryServiceImpl implements CountryService {

    private final Logger log = LoggerFactory.getLogger(CountryServiceImpl.class);

    private final CountryDAO dao;

    @Autowired
    public CountryServiceImpl(CountryDAO dao){
        this.dao = dao;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<CountryView> countries() {
        List<Country> all = dao.all();
        List<CountryView> countries = new ArrayList<>();

        for (Country country:all) {
            CountryView view = new CountryView(country.getCountryName(), country.getCountryCode());
            countries.add(view);

            log.info(view.toString());
        }

        return countries;
    }
}
