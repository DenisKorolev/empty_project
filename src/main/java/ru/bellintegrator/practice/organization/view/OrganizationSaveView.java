package ru.bellintegrator.practice.organization.view;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.org.apache.xpath.internal.operations.Bool;

public class OrganizationSaveView {
    /**
     * Org name
     */
    private String name;

    /**
     * Org full name
     */
    private String fullName;

    /**
     * Org inn
     */
    private String inn;

    /**
     * Org kpp
     */
    private String kpp;

    /**
     * Org address
     */
    private String address;

    /**
     * Org phone
     */
    private String phone;

    @JsonProperty("isActive")
    private Boolean isActive;

    /**
     * Constructor for Jackson
     */
    public OrganizationSaveView(){

    }


    @Override
    public String toString() {
        return "{name:" + getName() + "; fullName:" + getFullName() + "; inn:" + getInn() +
                "; kpp:" + getKpp() + "; address:" + getAddress() + "; phone:" + getPhone() +
                "; isActive:" + getActive();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
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

    @JsonProperty("isActive")
    public Boolean getActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setActive(Boolean active) {
        this.isActive = active;
    }
}
