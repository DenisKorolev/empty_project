package ru.bellintegrator.practice.doc.dao;

import ru.bellintegrator.practice.doc.model.Doc;

import java.util.List;

public interface DocDAO {
    //Get all Doc objects
    List<Doc> all();

    //Get Doc by Id
    Doc loadById(Long Id);

    /**
     * Gets Doc Type object by document number
     * @param docNumber Doc Type document number
     * @return Doc Type object if any
     */
    Doc loadByDocNumber(String docNumber);
}
