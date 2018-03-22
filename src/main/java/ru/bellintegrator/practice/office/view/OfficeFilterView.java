package ru.bellintegrator.practice.office.view;

import io.swagger.annotations.ApiModelProperty;

public class OfficeFilterView {
    public String orgId;

    public String name;

    public String phone;

    public boolean isActive;

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