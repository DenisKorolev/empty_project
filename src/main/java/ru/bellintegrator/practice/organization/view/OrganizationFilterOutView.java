package ru.bellintegrator.practice.organization.view;

import com.fasterxml.jackson.annotation.JsonProperty;

public class OrganizationFilterOutView {
    /**
     * Org id
     */
    private String id;

    /**
     * Org name
     */
    private String name;

    /**
     * Number of offices which an Org has
     */
    private String officesCount;

    /**
     * Is Org active
     */
    @JsonProperty("isActive")
    private String isActive;

    /**
     * Constructor for Jackson
     */
    public OrganizationFilterOutView(){

    }

    /**
     * Constructor for Service
     */
    public OrganizationFilterOutView(String id, String name, String officesCount, String isActive){
        setId(id);
        setName(name);
        setOfficesCount(officesCount);
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

    public String getOfficesCount() {
        return officesCount;
    }

    public void setOfficesCount(String officesCount) {
        this.officesCount = officesCount;
    }

    @JsonProperty("isActive")
    public String getActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setActive(String isActive) {
        this.isActive = isActive;
    }
}
