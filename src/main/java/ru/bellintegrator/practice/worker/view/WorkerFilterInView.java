package ru.bellintegrator.practice.worker.view;

public class WorkerFilterInView {

    //Office id
    private String officeId;

    //Employee first name
    private String firstName;

    //Employee last name
    private String lastName;

    //Employee middle name
    private String middleName;

    //Employee position
    private String position;

    //Employee Country citizenship code
    private String citizenshipCode;

    //Constructor for Jackson
    public WorkerFilterInView(){

    }

    public String getOfficeId() {
        return officeId;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(String citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }
}
