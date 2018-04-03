package ru.bellintegrator.practice.worker.view;

public class WorkerView {
    /**
     * Employee id
     */
    private String id;

    /**
     * Employee Office id
     */
    private String officeId;

    /**
     * Employee first name
     */
    private String firstName;

    /**
     * Employee second name
     */
    private String secondName;

    /**
     * Employee middle name
     */
    private String middleName;

    /**
     * Employee position
     */
    private String position;

    /**
     * Employee salary
     */
    private String salary;

    /**
     * Employee registration date
     */
    private String registrationDate;

    /**
     * Employee phone number
     */
    private String phone;

    /**
     * Employee Doc type code
     */
    private String docCode;

    /**
     * Employee Doc type name
     */
    private String docName;

    /**
     * Employee document number
     */
    private String docNumber;

    /**
     * Employee document date
     */
    private String docDate;

    /**
     * Employee Country code
     */
    private String citizenshipCode;

    /**
     * Employee Country name
     */
    private String citizenshipName;

    /**
     * Constructor for Jackson
     */
    public WorkerView(){

    }

    /**
     * Constructor for Service
     */
    public WorkerView(String id, String officeId, String firstName, String secondName, String middleName, String position,
                      String salary, String registrationDate, String phone, String docCode, String docName,
                      String docNumber, String docDate, String citizenshipCode, String citizenshipName){
        setId(id);
        setOfficeId(officeId);
        setFirstName(firstName);
        setSecondName(secondName);
        setMiddleName(middleName);
        setPosition(position);
        setSalary(salary);
        setRegistrationDate(registrationDate);
        setPhone(phone);
        setDocCode(docCode);
        setDocName(docName);
        setDocNumber(docNumber);
        setDocDate(docDate);
        setCitizenshipCode(citizenshipCode);
        setCitizenshipName(citizenshipName);
    }


    @Override
    public String toString() {
        return "{id: " + getId() + "; officeId: " + getOfficeId() + "; firstName: " + getFirstName();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
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

    public String getCitizenshipName() {
        return citizenshipName;
    }

    public void setCitizenshipName(String citizenshipName) {
        this.citizenshipName = citizenshipName;
    }
}