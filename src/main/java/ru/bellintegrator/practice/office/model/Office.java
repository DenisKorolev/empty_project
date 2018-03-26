package ru.bellintegrator.practice.office.model;

import ru.bellintegrator.practice.organization.model.Organization;
import ru.bellintegrator.practice.user.model.User;
import ru.bellintegrator.practice.worker.model.Worker;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Office")
public class Office {
    @Id
    @GeneratedValue
    @Column(name = "office_id")
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
     * Bidirectional ManyToOne relationship with Organization table
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_id")
    private Organization organization;

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }


    /**
     * Bidirectional OneToMany relationship with Worker table
     */
    @OneToMany(mappedBy = "office", cascade = CascadeType.ALL)
    private List<Worker> workers;

    public List<Worker> getWorkers() {
        if (workers == null){
            workers = new ArrayList<>();
        }
        return workers;
    }

    public void addWorker(Worker worker){
        workers.add(worker);
        worker.setOffice(this);
    }

    public void removeWorker(Worker worker) {
        workers.remove(worker);
        worker.setOffice(null);
    }


    /**
     * Office address
     */
    @Basic(optional = false)
    @Column(name = "office_address")
    private String officeAddress;

    public String getOfficeAddress(){
        return officeAddress;
    }

    public void setOfficeAddress(String officeAddress){
        this.officeAddress = officeAddress;
    }

    /**
     * Office name
     */
    @Basic(optional = false)
    @Column(name = "office_name")
    private String officeName;

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }


    /**
     * Office phone number
     */
    @Column(name = "office_phone")
    private String officePhone;

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }


    /**
     * Field that identifies whether office is active or not
     */
    @Basic(optional = false)
    @Column(name = "is_office_Active")
    private Boolean isOfficeActive;

    public Boolean getOfficeActive() {
        return isOfficeActive;
    }

    public void setOfficeActive(Boolean officeActive) {
        isOfficeActive = officeActive;
    }
}
