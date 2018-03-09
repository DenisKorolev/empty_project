package ru.bellintegrator.practice.doc.model;

import javax.persistence.*;

@Entity
@Table(name = "Doc_type")
public class Doc {
    @Id
    @GeneratedValue
    @Column(name = "doc_id")
    private Long id;

    @Column(name = "doc_name", unique = true)
    private String docName;

    @Column(name = "doc_number", unique = true)
    private String docNumber;

    public Long getId() {

        return id;
    }

    public String getDocName() {

        return docName;
    }

    public String getDocNumber() {

        return docNumber;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public void setDocName(String docName) {

        this.docName = docName;
    }

    public void setDocNumber(String docNumber) {

        this.docNumber = docNumber;
    }
}
