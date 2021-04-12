package com.mmpharmacy.mmpharmacy.service;

import com.mmpharmacy.mmpharmacy.dto.OrderDetailDTO;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface OrderService {

    void getAllProducts(Model model);

    void updateProductAfterBuy(List<Integer> idArray, List<String> qtyArray);

    void postSeries(HttpServletRequest request, List<OrderDetailDTO> list);
}
