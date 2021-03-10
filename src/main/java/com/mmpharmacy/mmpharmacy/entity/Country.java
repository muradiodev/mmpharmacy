package com.mmpharmacy.mmpharmacy.entity;

import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="country")
@ToString
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "country_id")
    private int country_id;

    @Column(name = "name")
    private String name;

    public Country() {
    }

    public Country(int id, String name) {
        this.country_id = id;
        this.name = name;
    }

    public int getCountry_id() {
        return country_id;
    }

    public void setCountry_id(int country_id) {
        this.country_id = country_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
