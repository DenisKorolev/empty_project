package ru.bellintegrator.practice.organization.view;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrganizationView {
    /**
     * Org id
     */
    private String id;

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
    private String isActive;

    /**
     * Constructor for Jackson
     */
    public OrganizationView(){

    }

    /**
     * Constructor for Service
     */
    public OrganizationView(String id, String name, String fullName, String inn,
                            String kpp, String address, String phone, String isActive){
        setId(id);
        setName(name);
        setFullName(fullName);
        setInn(inn);
        setKpp(kpp);
        setAddress(address);
        setPhone(phone);
        setActive(isActive);
    }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    public String getActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setActive(String active) {
        this.isActive = active;
    }
}
