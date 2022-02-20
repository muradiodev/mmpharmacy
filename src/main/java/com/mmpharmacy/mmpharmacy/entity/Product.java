package com.mmpharmacy.mmpharmacy.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@ToString
@Table(name = "product")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "productid")
    private int productid;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "qtystock")
    private String qtystock;

    @Column(name = "price")
    private String price;

    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_category",
            joinColumns = @JoinColumn(name = "productid"),
            inverseJoinColumns = @JoinColumn(name = "categoryid"))
    Set<Category> categories;

    @ToString.Exclude
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "product_type",
            joinColumns = @JoinColumn(name = "productid"),
            inverseJoinColumns = @JoinColumn(name = "typeid"))
    Set<Type> types;

    @Column(name = "isactive")
    private String isactive;

}
