package ru.bellintegrator.practice.country.dao;

import ru.bellintegrator.practice.country.model.Country;

import java.util.List;

public interface CountryDAO {
    //Get all Country objects
    List<Country> all();

    //Get Country by Id
    Country loadById(Long Id);

    /**
     * Gets Country object by country_code
     * @param countryCode Country country_code
     * @return Country object if any
     */
    Country loadByCountryCode(Long countryCode);
}
