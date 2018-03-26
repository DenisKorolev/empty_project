package ru.bellintegrator.practice.office.view;

import io.swagger.annotations.ApiModelProperty;

public class OfficeView {
    //@ApiModelProperty(hidden = true)
    private String id;

    //@ApiModelProperty(hidden = true)
    private String orgId;

    //@ApiModelProperty(hidden = true)
    private String name;

    //@ApiModelProperty(hidden = true)
    private String address;

    //@ApiModelProperty(hidden = true)
    private String phone;

    //@ApiModelProperty(hidden = true)
    private Boolean isActive;

    public OfficeView(){

    }

    public OfficeView(String id, String orgId, String name, String address,
                      String phone, boolean isActive) {
        setId(id);
        setOrgId(orgId);
        setName(name);
        setAddress(address);
        setPhone(phone);
        setIsActive(isActive);
    }

    @Override
    public String toString() {
        return "{id:" + getId() + "; orgId:" + getOrgId() + "; name:" + getName() +
                "; address:" + getAddress() + "; phone:" + getPhone() +
                "; isActive:" + getIsActive() + "}";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
