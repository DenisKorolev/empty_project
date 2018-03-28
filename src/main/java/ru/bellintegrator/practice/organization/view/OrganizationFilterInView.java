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
    private String isActive;

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

    public String getActive() {
        return isActive;
    }

    public void setActive(String isActive) {
        this.isActive = isActive;
    }
}
