package com.mmpharmacy.mmpharmacy.controller;

import com.mmpharmacy.mmpharmacy.dto.OrderDetailDTO;
import com.mmpharmacy.mmpharmacy.entity.OrderDetails;
import com.mmpharmacy.mmpharmacy.entity.Orders;
import com.mmpharmacy.mmpharmacy.entity.Product;
import com.mmpharmacy.mmpharmacy.repo.*;
import com.mmpharmacy.mmpharmacy.service.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/main")
public class ControllerOrders {

    private final OrderServiceImpl orderService;

    @RequestMapping("/")
    public String getAllProducts(Model md) {
        orderService.getAllProducts(md);
        return "main/index.html";
    }

    @RequestMapping("/productBuyed")
    public String updateProductAfterBuy(@RequestParam(value = "idArray[]") List<Integer> idArray,
                                        @RequestParam(value = "qtyArray[]", required = false) List<String> qtyArray) {

        orderService.updateProductAfterBuy(idArray, qtyArray);
        return "redirect:/main";
    }

    @RequestMapping("/testGet")
    public String postSeries(@RequestBody List<OrderDetailDTO> list) {
        System.out.println("testsssss");
        orderService.postSeries(list);
        return "main/index.html";
    }



}
