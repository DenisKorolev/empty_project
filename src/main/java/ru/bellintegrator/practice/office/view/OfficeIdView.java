package ru.bellintegrator.practice.office.view;

import io.swagger.annotations.ApiModelProperty;

public class OfficeIdView {
    /**
     * Office id
     */
    @ApiModelProperty(hidden = true)
    private Long id;

    /**
     * Office name
     */
    private String name;

    /**
     * Organization id
     */
    private String orgId;

    /**
     * Office address
     */
    private String address;

    /**
     * Office phone
     */
    private String phone;

    /**
     * Office isActive parameter
     */
    private String isActive;

    /**
     * Constructor for Jackson
     */
    public OfficeIdView(){

    }

    /**
     * Constructor for Service
     * @param id Office id
     */
    public OfficeIdView(Long id){
        setId(id);
    }

    @Override
    public String toString() {
        return "{id:" + getId() + "}";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
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

    public String getActive() {
        return isActive;
    }

    public void setActive(String active) {
        isActive = active;
    }
}
