package com.mmpharmacy.mmpharmacy.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

@Entity
@Table(name = "order_product")
@Accessors(chain = true)
@ToString
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private int orderid;

    private int productid;

    private int quantity;

    private String price;


}
