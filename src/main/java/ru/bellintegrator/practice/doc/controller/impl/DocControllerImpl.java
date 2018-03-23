package ru.bellintegrator.practice.doc.controller.impl;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.bellintegrator.practice.doc.controller.DocController;
import ru.bellintegrator.practice.doc.model.Doc;
import ru.bellintegrator.practice.doc.service.DocService;
import ru.bellintegrator.practice.doc.view.DocView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping(value = "/api/docs", produces = APPLICATION_JSON_VALUE)
public class DocControllerImpl implements DocController{

    private final DocService docService;

    @Autowired
    public DocControllerImpl(DocService docService){
        this.docService = docService;
    }


    @Override
    @ApiOperation(value = "Gets list of Doc types", responseContainer = "List", httpMethod = "POST")
    @RequestMapping(value = "/", method = {POST})
    public List<DocView> docs() {
        return docService.docs();
    }
}
