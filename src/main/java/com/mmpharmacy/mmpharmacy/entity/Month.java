package com.mmpharmacy.mmpharmacy.entity;

import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "month")
@ToString
public class Month {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "monthid")
    private int monthid;

    @Column(name = "name")
    private String name;

    public Month(int monthid, String name) {
        this.monthid = monthid;
        this.name = name;
    }

    public int getMonthid() {
        return monthid;
    }

    public void setMonthid(int monthid) {
        this.monthid = monthid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
