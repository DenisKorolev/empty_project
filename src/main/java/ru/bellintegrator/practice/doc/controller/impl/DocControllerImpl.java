package ru.bellintegrator.practice.doc.controller.impl;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.doc.controller.DocController;
import ru.bellintegrator.practice.doc.model.Doc;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/", produces = APPLICATION_JSON_VALUE)
public class DocControllerImpl implements DocController{

    //TODO
    @Override
    public List<Doc> docs() {
        return null;
    }
}
