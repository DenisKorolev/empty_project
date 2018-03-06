package ru.bellintegrator.practice.country.dao;

import ru.bellintegrator.practice.country.model.Country;

import java.util.List;

public interface CountryDAO {
    //Get all Country objects
    List<Country> all();

    //Get Country by Id
    Country loadById(Long Id);
}
