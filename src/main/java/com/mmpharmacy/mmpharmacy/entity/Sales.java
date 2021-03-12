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
    @Column(name = "salesid")
    private int salesid;

    @Column(name = "quantity")
    private int quantity;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "sales_date",
            joinColumns = @JoinColumn(name = "salesid"),
            inverseJoinColumns = @JoinColumn(name = "dateid"))
    Set<Date> date;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "sales_product",
            joinColumns = @JoinColumn(name = "salesid"),
            inverseJoinColumns = @JoinColumn(name = "productid"))
    Set<Product> product;

    @Column(name = "isactive")
    private String isactive;

    public Sales(int id, int quantity, Set<Date> date, Set<Product> product, String isactivective) {
        this.salesid = id;
        this.quantity = quantity;
        this.date = date;
        this.product = product;
        this.isactive = isactive;
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

    public int getSalesid() {
        return salesid;
    }

    public void setSalesid(int salesid) {
        this.salesid = salesid;
    }

    public String getIsactive() {
        return isactive;
    }

    public void setIsactive(String isactive) {
        this.isactive = isactive;
    }
}
