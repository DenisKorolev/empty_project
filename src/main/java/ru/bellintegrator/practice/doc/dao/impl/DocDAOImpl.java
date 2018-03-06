package ru.bellintegrator.practice.doc.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.doc.dao.DocDAO;
import ru.bellintegrator.practice.doc.model.Doc;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class DocDAOImpl implements DocDAO{

    private final EntityManager em;

    @Autowired
    public DocDAOImpl(EntityManager em){
        this.em = em;
    }

    @Override
    public List<Doc> all(){
        TypedQuery<Doc> query = em.createQuery("SELECT d FROM Doc d", Doc.class);
        return query.getResultList();
    }

    @Override
    public Doc loadById(Long id){
        return em.find(Doc.class, id);
    }

}
