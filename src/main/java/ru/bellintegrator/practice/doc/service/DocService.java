package ru.bellintegrator.practice.doc.service;

import ru.bellintegrator.practice.doc.view.DocView;

import java.util.List;

public interface DocService {

    void test();

    void add(DocView doc);

    List<DocView> docs();
}
