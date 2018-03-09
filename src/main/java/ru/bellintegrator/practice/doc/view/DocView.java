package ru.bellintegrator.practice.doc.view;

import io.swagger.annotations.ApiModelProperty;

public class DocView {
    @ApiModelProperty(hidden = true)
    public String id;

    public String docName;

    public String docNumber;

    public DocView (){

    }

    public DocView (String docName, String docNumber){
        this.docName = docName;
        this.docNumber = docNumber;
    }

    @Override
    public String toString(){
        return "{id: " + id + "; name: "+ docName + "; code: " + docNumber + "}";
    }
}
