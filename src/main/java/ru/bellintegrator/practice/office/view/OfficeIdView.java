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
    private Long orgId;

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
    private Boolean isActive;

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

    public Long getOrgId() {
        return orgId;
    }

    public void setOrgId(Long orgId) {
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
