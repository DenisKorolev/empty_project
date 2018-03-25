package ru.bellintegrator.practice.organization.view;

public class OrganizationFilterInView {
    /**
     * Org name
     */
    private String name;

    /**
     * Org inn
     */
    private String inn;

    /**
     * Is Org active
     */
    private Boolean isActive;

    /**
     * Constructor for Jackson
     */
    public OrganizationFilterInView(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean isActive) {
        isActive = isActive;
    }
}
