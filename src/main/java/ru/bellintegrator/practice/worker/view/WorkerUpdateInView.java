package ru.bellintegrator.practice.worker.view;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

public class WorkerUpdateInView {
    /**
     * Employee id
     */
    @JsonPropertyOrder(value = "1")
    private String id;

    /**
     * Employee first name
     */
    @JsonPropertyOrder(value = "2")
    private String firstName;

    /**
     * Employee second name
     */
    @JsonPropertyOrder(value = "3")
    private String secondName;

    /**
     * Employee middle name
     */
    @JsonPropertyOrder(value = "4")
    private String middleName;

    /**
     * Employee position
     */
    @JsonPropertyOrder(value = "5")
    private String position;

    /**
     * Employee salary
     */
    @JsonPropertyOrder(value = "6")
    private String salary;

    /**
     * Employee registration date
     */
    @JsonPropertyOrder(value = "7")
    private String registrationDate;

    /**
     * Employee phone number
     */
    @JsonPropertyOrder(value = "8")
    private String phone;

    /**
     * Employee Doc type code
     */
    @JsonPropertyOrder(value = "9")
    private String docCode;

    /**
     * Employee document number
     */
    @JsonPropertyOrder(value = "10")
    private String docNumber;

    /**
     * Employee document date
     */
    @JsonPropertyOrder(value = "11")
    private String docDate;

    /**
     * Employee Country code
     */
    @JsonPropertyOrder(value = "12")
    private String citizenshipCode;

    /**
     * Constructor for Jackson
     */
    @JsonPropertyOrder(value = "13")
    public WorkerUpdateInView(){

    }

    /**
     * Constructor for Service
     */
    public WorkerUpdateInView(String id, String firstName, String secondName, String middleName, String position,
                              String salary, String registrationDate, String phone, String docCode, String docNumber,
                              String docDate, String citizenshipCode){
        setId(id);
        setFirstName(firstName);
        setSecondName(secondName);
        setMiddleName(middleName);
        setPosition(position);
        setSalary(salary);
        setRegistrationDate(registrationDate);
        setPhone(phone);
        setDocCode(docCode);
        setDocNumber(docNumber);
        setDocDate(docDate);
        setCitizenshipCode(citizenshipCode);
    }


    @Override
    public String toString() {
        return "{id: " + getId();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
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

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDocCode() {
        return docCode;
    }

    public void setDocCode(String docCode) {
        this.docCode = docCode;
    }

    public String getDocNumber() {
        return docNumber;
    }

    public void setDocNumber(String docNumber) {
        this.docNumber = docNumber;
    }

    public String getDocDate() {
        return docDate;
    }

    public void setDocDate(String docDate) {
        this.docDate = docDate;
    }

    public String getCitizenshipCode() {
        return citizenshipCode;
    }

    public void setCitizenshipCode(String citizenshipCode) {
        this.citizenshipCode = citizenshipCode;
    }
}
