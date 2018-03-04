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
    @Column(name = "id")
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

    @OneToMany(mappedBy = "country")
    private Set<Worker> workerObj;

    public Long getId() {
        return id;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
