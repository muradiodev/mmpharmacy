package com.mmpharmacy.mmpharmacy.dto;

import com.mmpharmacy.mmpharmacy.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class OrderDetailDTO {

    private int productid;

    private int orderid;

    private int quantity;

    private String price;

    private String total;

    private String productName;



}