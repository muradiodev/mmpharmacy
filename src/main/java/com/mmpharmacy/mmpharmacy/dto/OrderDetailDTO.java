package com.mmpharmacy.mmpharmacy.dto;

import com.mmpharmacy.mmpharmacy.entity.Product;
import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderDetailDTO {

    private int productid;

    private int orderid;

    private int quantity;

    private String price;

    private String total;

    private String productName;



}