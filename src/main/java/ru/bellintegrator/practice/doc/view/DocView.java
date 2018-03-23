package ru.bellintegrator.practice.doc.view;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

public class DocView {
    @ApiModelProperty(hidden = true)
    public String id;

    @JsonProperty("name")
    public String docName;

    @JsonProperty("code")
    public String docNumber;

    public DocView (){

    }

    public DocView (String docName, String docNumber){
        this.docName = docName;
        this.docNumber = docNumber;
    }

    @Override
    public String toString(){
        return "{name:"+ docName + "; code:" + docNumber + "}";
    }

    @JsonIgnore
    public String getId() {
        return id;
    }
}
