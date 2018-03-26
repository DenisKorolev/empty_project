package ru.bellintegrator.practice.office.view;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class OfficeFilterOutView {
    /**
     * Office id
     */
    public String id;

    /**
     * Office name
     */
    public String name;

    /**
     * Organization name
     */
    public String organizationName;

    /**
     * Office is active
     */
    public String isActive;

    /**
     * Constructor for Jackson
     */
    public OfficeFilterOutView(){

    }

    /**
     * Constructor for Service
     * @param id Office id
     * @param name Office name
     * @param orgName Organization name
     * @param isActive Is Office active
     */
    public OfficeFilterOutView(String id, String name, String orgName, String isActive){
        setId(id);
        setName(name);
        setOrganizationName(orgName);
        setActive(isActive);

    }

    @Override
    public String toString() {
        return "{id:" + id + "; name:" + name + "; organizationName:" + organizationName + "; isActive:" +
                isActive + "}";
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

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    @JsonIgnore
    public String getActive() {
        return isActive;
    }

    public void setActive(String active) {
        isActive = active;
    }
}
