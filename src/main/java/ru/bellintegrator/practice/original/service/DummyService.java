package ru.bellintegrator.practice.original.service;

import ru.bellintegrator.practice.original.view.PersonView;

import java.util.List;

/**
 * Some service. Just for test
 */
public interface DummyService {

    void test();

    /**
     *
     * @param person
     */
    void add(PersonView person);

    /**
     * Dummy service method
     * @return {@Person}
     */
    List<PersonView> persons();
}