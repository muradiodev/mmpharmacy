package com.mmpharmacy.mmpharmacy.entity;

import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@ToString
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "product_id")
    private int product_id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "qty_stock")
    private String qty_stock;

    @Column(name = "string")
    private String price;


//    @ToString.Exclude
//    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "product_supplier",
//            joinColumns = @JoinColumn(name = "product_id"),
//            inverseJoinColumns = @JoinColumn(name = "supplier_id"))
//    private Set<Type> product_supplier;

    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    Set<Category> product_category;


    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_type",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "type_id"))
    Set<Type> product_type;


    @Column(name = "isActive")
    private String isActive;

}
