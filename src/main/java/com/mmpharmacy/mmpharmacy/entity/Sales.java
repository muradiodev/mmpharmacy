package com.mmpharmacy.mmpharmacy.entity;

import lombok.ToString;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "sales")
@ToString
public class Sales {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "quantity")
    private int quantity;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "sales_date",
            joinColumns = @JoinColumn(name = "sales_id"),
            inverseJoinColumns = @JoinColumn(name = "date_id"))
    Set<Date> date;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "sales_product",
            joinColumns = @JoinColumn(name = "sales_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    Set<Product> product;

    @Column(name = "isActive")
    private String isActive;

    public Sales(int id, int quantity, Set<Date> date, Set<Product> product, String isActive) {
        this.id = id;
        this.quantity = quantity;
        this.date = date;
        this.product = product;
        this.isActive = isActive;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Set<Date> getDate() {
        return date;
    }

    public void setDate(Set<Date> date) {
        this.date = date;
    }

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }

    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
}
