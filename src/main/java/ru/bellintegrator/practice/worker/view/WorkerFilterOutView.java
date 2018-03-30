package ru.bellintegrator.practice.worker.view;

public class WorkerFilterOutView {

    //Employee id
    private String id;

    //Employee full name
    private String fullName;

    //Employee position
    private String position;

    //Office name
    private String officeName;

    //Constructor for Jackson
    public WorkerFilterOutView(){

    }

    //Constructor for Service
    public WorkerFilterOutView(String id, String fullName, String position, String officeName){
        setId(id);
        setFullName(fullName);
        setPosition(position);
        setOfficeName(officeName);
    }

    @Override
    public String toString() {
        return "{id: " + getId() + "; fullName: " + getFullName() + "; position: " +
                getPosition() + "; officeName: " + getOfficeName() + "}";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }
}
