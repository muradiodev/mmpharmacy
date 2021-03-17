package com.mmpharmacy.mmpharmacy.entity;

import lombok.*;
import lombok.experimental.Accessors;
import org.aspectj.weaver.ast.Or;
import org.hibernate.criterion.Order;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "orders")
@ToString
public class Orders {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private int id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderid")
    private int orderid;

    public Orders(){}

    public Orders(int orderid) {
        this.orderid = orderid;
    }

    public int getOrderid() {
        return orderid;
    }

    public void setOrderid(int orderid) {
        this.orderid = orderid;
    }
}
