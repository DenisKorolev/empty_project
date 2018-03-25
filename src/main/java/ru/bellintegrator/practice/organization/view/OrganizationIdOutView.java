package ru.bellintegrator.practice.organization.view;

public class OrganizationIdOutView {
    /**
     * Org id
     */
    private String id;

    /**
     * Constructor for Jackson
     */
    public OrganizationIdOutView(){

    }

    /**
     * Constructor for Service
     * @param id Org id
     */
    public OrganizationIdOutView(String id){
        setId(id);
    }

    @Override
    public String toString() {
        return "{id:" + getId() + "}";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
