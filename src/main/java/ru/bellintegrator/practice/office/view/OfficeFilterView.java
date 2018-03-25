package ru.bellintegrator.practice.office.view;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    /**
     * Constructor for Jackson
     */
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
        return "{id:" + id + "; name:" + name + "; organizationName:" + organizationName + "; isActive:" +
                isActive + "}";
    }

    /*
    @JsonIgnore
    public String getOrgId() {
        return orgId;
    }

    @JsonIgnore
    public String getPhone() {
        return phone;
    }
    */
}