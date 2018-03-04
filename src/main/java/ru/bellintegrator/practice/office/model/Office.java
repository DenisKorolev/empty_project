package ru.bellintegrator.practice.office.model;

import javax.persistence.*;

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

    //TODO org_id @ Organization


    @Column(name = "office_name")
    private String officeName;

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }


    @Column(name = "office_phone")
    private String officePhone;

    public String getOfficePhone() {
        return officePhone;
    }

    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }


    @Column(name = "is_office_Active")
    private Boolean isOfficeActive;

    public Boolean getOfficeActive() {
        return isOfficeActive;
    }

    public void setOfficeActive(Boolean officeActive) {
        isOfficeActive = officeActive;
    }
}
