package ru.bellintegrator.practice.worker.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Worker")
public class Worker {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private Long id;

    /**
     * Serive field of hibernate
     */
    @Version
    private Integer version;

    //TODO office_id

    //TODO doc_id

    //TODO citezenship_code

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "position")
    private String positionStr;

    @Column(name = "phone")
    private String phoneStr;

    @Column(name = "doc_date")
    private Date docDate;

    @Column(name = "is_identified")
    private Boolean isIdentified;

    //TODO establish getters and setters
}
