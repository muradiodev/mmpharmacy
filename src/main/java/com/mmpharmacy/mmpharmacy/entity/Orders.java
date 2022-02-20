package com.mmpharmacy.mmpharmacy.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "orders")
@ToString
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private int id;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderid")
    private int orderid;

    @Column(name = "total")
    private String total;




}
