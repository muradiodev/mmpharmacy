package com.mmpharmacy.mmpharmacy.dto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
@RequiredArgsConstructor
public class OrderDetailDTO {

    private int productid;

    private int quantity;

    private BigDecimal price;

}