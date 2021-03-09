package com.mmpharmacy.mmpharmacy.entity;

import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "category")
@ToString
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "category_id")
    private int category_id;

    @Column(name = "name")
    private String name;

    public Category() {
    }

    public Category(int id, String name) {
        this.category_id = id;
        this.name = name;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
