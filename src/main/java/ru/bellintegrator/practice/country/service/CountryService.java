package ru.bellintegrator.practice.country.service;

import ru.bellintegrator.practice.country.view.CountryView;

import java.util.List;

public interface CountryService {

    /**
     * Get all Countries
     * @return JSON Countries value
     */
    List<CountryView> countries();
}
