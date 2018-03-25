package ru.bellintegrator.practice.office.view;

public class OfficeIdOutView {
    /**
     * Office id
     */
    private String id;

    /**
     * Constructor for Jackson
     */
    public OfficeIdOutView(){

    }

    /**
     * Constructor for Service
     * @param id Office id
     */
    public OfficeIdOutView(String id){
        setId(id);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
