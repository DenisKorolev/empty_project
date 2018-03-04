package ru.bellintegrator.practice.doc.view;

import io.swagger.annotations.ApiModelProperty;

public class DocView {
    @ApiModelProperty(hidden = true)
    public long id;

    public String docName;

    public long docNumber;

    public DocView (){

    }

    public DocView (String docName, long docNumber){
        this.docName = docName;
        this.docNumber = docNumber;
    }

    @Override
    public String toString(){
        return "{id: " + id + "; name: "+ docName + "; code: " + docNumber + "}";
    }
}
