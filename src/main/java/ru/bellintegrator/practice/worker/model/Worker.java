package ru.bellintegrator.practice.worker.model;

import ru.bellintegrator.practice.country.model.Country;
import ru.bellintegrator.practice.doc.model.Doc;
import ru.bellintegrator.practice.office.model.Office;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Worker")
public class Worker {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    /**
     * Serive field of hibernate
     */
    @Version
    private Integer version;


    //office_id @ Office
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "office_id")
    private Office office;

    public Office getOffice() {
        return office;
    }

    public void setOffice(Office office) {
        this.office = office;
    }


    //doc_id @ Doc_type
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "doc_id")
    private Doc doc;

    public Doc getDoc() {
        return doc;
    }

    public void setDoc(Doc doc) {
        this.doc = doc;
    }


    //citezenship_code @ Country
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    /*
    @Column(name = "citezenship_code")
    private Long citezenshipCode;
    */


    @Column(name = "first_name")
    private String firstName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }


    @Column(name = "last_name")
    private String lastName;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }


    @Column(name = "middle_name")
    private String middleName;

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }


    @Column(name = "position")
    private String position;

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }


    @Column(name = "phone")
    private String phone;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Column(name = "doc_date")
    private Date docDate;

    public Date getDocDate() {
        return docDate;
    }

    public void setDocDate(Date docDate) {
        this.docDate = docDate;
    }


    @Column(name = "is_identified")
    private Boolean isIdentified;

    public Boolean getIdentified() {
        return isIdentified;
    }

    public void setIdentified(Boolean identified) {
        isIdentified = identified;
    }
}
