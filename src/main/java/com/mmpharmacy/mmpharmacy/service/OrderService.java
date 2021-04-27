package com.mmpharmacy.mmpharmacy.service;

import com.mmpharmacy.mmpharmacy.dto.OrderDetailDTO;
import org.springframework.ui.Model;

import java.util.List;

public interface OrderService {

    void getAllProducts(Model model);

    void updateProductAfterBuy(List<Integer> idArray, List<String> qtyArray);

    void postSeries(List<OrderDetailDTO> list);

    void getAllOrders(Model model);

    void getRevenue(Model model);
}
