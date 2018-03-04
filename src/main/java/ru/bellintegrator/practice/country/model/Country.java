package ru.bellintegrator.practice.country.model;

import ru.bellintegrator.practice.worker.model.Worker;

import javax.persistence.*;
import java.util.Set;

/**
 * Country directory
 */

@Entity
@Table(name = "Country")
public class Country {
    @Id
    @GeneratedValue
    @Column(name = "country_id")
    private Long id;

    /**
     * Service field of hibernate
     */
    @Version
    private Integer version;


    /**
     * Country name
     */
    @Column(name = "country_name")
    private String countryName;

    /*

    @OneToMany(mappedBy = "country")
    private Set<Worker> workerObj;

    */

    @Column(name = "country_code")
    private Long countryCode;

    public Long getId() {

        return id;
    }

    public String getCountryName() {

        return countryName;
    }

    public Long getCountryCode() {
        return countryCode;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public void setCountryName(String countryName) {

        this.countryName = countryName;
    }

    public void setCountryCode(Long countryCode) {
        this.countryCode = countryCode;
    }
}
