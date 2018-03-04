package ru.bellintegrator.practice.organization.model;

import javax.persistence.*;

@Entity
@Table(name = "Organization")
public class Organization {
    @Id
    @GeneratedValue
    @Column(name = "org_id")
    private Long id;

    /**
     * Service field of hibernate
     */
    @Version
    private Integer version;

    @Column(name = "org_name")
    private String orgName;

    @Column(name = "org_full_name")
    private String orgFullName;

    @Column(name = "inn")
    private Long inn;

    @Column(name = "kpp")
    private Long kpp;


}
