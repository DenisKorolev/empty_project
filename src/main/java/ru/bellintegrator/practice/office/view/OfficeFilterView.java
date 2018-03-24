package ru.bellintegrator.practice.office.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import io.swagger.annotations.ApiModelProperty;

public class OfficeFilterView {
    @JsonPropertyOrder(value = "1")
    public String orgId;

    @JsonPropertyOrder(value = "2")
    public String name;

    @JsonPropertyOrder(value = "3")
    public String phone;

    @JsonPropertyOrder(value = "4")
    public Boolean isActive;

    @ApiModelProperty(hidden = true)
    public String id;

    @ApiModelProperty(hidden = true)
    public String organizationName;

    public OfficeFilterView(){

    }


    public OfficeFilterView(String id, String name, String organizationName, boolean isActive){
        this.id = id;
        this.name = name;
        this.organizationName = organizationName;
        this.isActive = isActive;
    }

    @Override
    public String toString() {
        return "{id:" + id + "; name:" + organizationName + "; organizationName:" + organizationName + "; isActive:" +
                isActive + "}";
    }

}