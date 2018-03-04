package ru.bellintegrator.practice.office.model;

import javax.persistence.*;

@Entity
@Table(name = "Office")
public class Office {
    @Id
    @GeneratedValue
    @Column(name = "office_id")
    private Long id;

    /**
     * Service field of hibernate
     */
    @Version
    private Integer version;

    //TODO org_id

    @Column(name = "office_name")
    private String officeName;

    @Column(name = "office_phone")
    private String officePhone;

    @Column(name = "is_office_Active")
    private Boolean isOfficeActive;

    //TODO establish getters and setters
}
