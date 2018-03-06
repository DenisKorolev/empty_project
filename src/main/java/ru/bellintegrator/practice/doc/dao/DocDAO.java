package ru.bellintegrator.practice.doc.dao;

import ru.bellintegrator.practice.doc.model.Doc;

import java.util.List;

public interface DocDAO {
    //Get all Doc objects
    List<Doc> all();

    //Get Doc by Id
    Doc loadById(Long Id);
}
