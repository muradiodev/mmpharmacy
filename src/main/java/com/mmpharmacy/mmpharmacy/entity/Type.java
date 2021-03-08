package com.mmpharmacy.mmpharmacy.entity;

import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "type")
@ToString
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "type_id")
    private int type_id;

    @Column(name = "name")
    private String name;

    public Type() {
    }

    public Type(int type_id, String name) {
        this.type_id = type_id;
        this.name = name;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
