package com.mmpharmacy.mmpharmacy.entity;

import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "user")
@ToString
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String name;

    @Column(name = "name")
    private String name;

    @Column(name = "name")
    private String name;

    @Column(name = "phone_number")
    private String phone_number;

    @Column(name = "password")
    private String password;

    @Column(name = "isActive")
    private String isActive;
}
