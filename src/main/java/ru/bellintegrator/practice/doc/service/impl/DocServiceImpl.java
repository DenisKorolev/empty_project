package ru.bellintegrator.practice.doc.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.doc.dao.DocDAO;
import ru.bellintegrator.practice.doc.model.Doc;
import ru.bellintegrator.practice.doc.service.DocService;
import ru.bellintegrator.practice.doc.view.DocView;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
@Scope(proxyMode = ScopedProxyMode.INTERFACES)
public class DocServiceImpl implements DocService{

    private final Logger log = LoggerFactory.getLogger(DocServiceImpl.class);

    private final DocDAO dao;

    @Autowired
    public DocServiceImpl(DocDAO dao){
        this.dao = dao;
    }

    @Override
    @Transactional(readOnly = true)
    public List<DocView> docs(){
        List<Doc> all = dao.all();

        Function<Doc, DocView> mapDoc = d -> {
            DocView view = new DocView();
            view.id = String.valueOf(d.getId());
            view.docName = d.getDocName();
            view.docNumber = String.valueOf(d.getDocNumber());

            log.info(view.toString());

            return view;
        };

        return all.stream()
                .map(mapDoc)
                .collect(Collectors.toList());
    }
}
