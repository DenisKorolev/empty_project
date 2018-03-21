package ru.bellintegrator.practice.country.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.country.model.Country;
import ru.bellintegrator.practice.country.service.CountryService;
import ru.bellintegrator.practice.country.view.CountryView;


import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;


@RestController
@RequestMapping(value = "/api/country", produces = APPLICATION_JSON_VALUE)
public class CountryControllerImpl implements CountryController {

    private final CountryService countryService;

    @Autowired
    public CountryControllerImpl(CountryService countryService){
        this.countryService = countryService;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @ApiOperation(value = "Gets list of countries", responseContainer = "List", httpMethod = "POST")
    @RequestMapping(value = "/", method = {POST})
    public List<CountryView> countries() {
        return countryService.countries();
    }
}
