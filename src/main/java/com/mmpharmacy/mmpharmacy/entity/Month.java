package com.mmpharmacy.mmpharmacy.entity;

import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "month")
@ToString
public class Month {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "month_id")
    private int month_id;

    @Column(name = "name")
    private String name;

    public Month(int month_id, String name) {
        this.month_id = month_id;
        this.name = name;
    }

    public int getMonth_id() {
        return month_id;
    }

    public void setMonth_id(int month_id) {
        this.month_id = month_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
