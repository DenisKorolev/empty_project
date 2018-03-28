package ru.bellintegrator.practice.organization.model;

import ru.bellintegrator.practice.office.model.Office;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Organization")
public class Organization {
    @Id
    @GeneratedValue
    @Column(name = "org_id")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Service field of hibernate
     */
    @Version
    private Integer version;

    /**
     * Bidirectional OneToMany relationship with Office table
     */
    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Office> offices;

    public List<Office> getOffices() {
        if (offices == null){
            offices = new ArrayList<>();
        }
        return offices;
    }

    public void addOffice(Office office){
        offices.add(office);
        office.setOrganization(this);
    }

    public void removeOffice(Office office){
        offices.remove(office);
        office.setOrganization(null);
    }

    /**
     * Short organization name
     */
    @Column(name = "org_name")
    private String orgName;

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }


    /**
     * Full organization name
     */
    @Basic(optional = false)
    @Column(name = "org_full_name")
    private String orgFullName;

    public String getOrgFullName() {
        return orgFullName;
    }

    public void setOrgFullName(String orgFullName) {
        this.orgFullName = orgFullName;
    }


    /**
     * INN
     */
    @Basic(optional = false)
    @Column(name = "org_inn")
    private String inn;

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }


    /**
     * KPP
     */
    @Basic(optional = false)
    @Column(name = "kpp")
    private String kpp;

    public String getKpp() {
        return kpp;
    }

    public void setKpp(String kpp) {
        this.kpp = kpp;
    }


    /**
     * Address of organization
     */
    @Basic(optional = false)
    @Column(name = "org_address")
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    /**
     * Company phone number
     */
    @Column(name = "org_phone")
    private String phoneNumber;

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    /**
     * Field that identifies whether company is active or not
     */
    @Column(name = "is_active")
    private Boolean isActive;

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
