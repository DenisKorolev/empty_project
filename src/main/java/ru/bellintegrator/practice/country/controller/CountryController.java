package ru.bellintegrator.practice.country.controller;

import ru.bellintegrator.practice.country.view.CountryView;

import java.util.List;

public interface CountryController {

    /**
     * Get all countries
     * @return JSON Countries value
     */
    List<CountryView> countries();
}
