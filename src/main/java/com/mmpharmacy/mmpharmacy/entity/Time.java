package com.mmpharmacy.mmpharmacy.entity;


import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="time")
@ToString
public class Time {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;

    @Column(name = "name")
    private String name;

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
}
