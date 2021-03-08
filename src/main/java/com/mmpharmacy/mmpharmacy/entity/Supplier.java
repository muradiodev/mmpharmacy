package com.mmpharmacy.mmpharmacy.entity;

import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Table(name = "country")
@ToString
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "supplier_country",
            joinColumns = @JoinColumn(name = "supplier_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id"))
    Country country;

    @Column(name = "address")
    private String address;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "email")
    @Email
    private String email;

    @Column(name = "isActive")
    private String isActive;

    public Supplier(int id, String name, Country country, String address, String phone_number, @Email String email, String isActive) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.address = address;
        this.phone_number = phone_number;
        this.email = email;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
}
