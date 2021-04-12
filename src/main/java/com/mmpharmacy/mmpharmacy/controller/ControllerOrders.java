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

    private final RepoCategory repoCategory;
    private final RepoType repoType;
    private final RepoProduct repoProduct;
    private final RepoOrders repoOrders;
    private final RepoOrderDetails repoOrderDetails;
    private final OrderServiceImpl orderService;

    @RequestMapping("/")
    public String getAllProducts(Model md) {
        orderService.getAllProducts(md);
        return "main/index.html";
    }

    @RequestMapping("/productBuyed")
    public String updateProductAfterBuy(@RequestParam(value = "idArray[]") List<Integer> idArray,
                                        @RequestParam(value = "qtyArray[]", required = false) List<String> qtyArray) {

        int diff = 0;
        int j = 0;
        for (Integer i : idArray) {
            Product product = repoProduct.getOne(i);
            diff = Integer.parseInt(product.getQtystock()) - Integer.parseInt(qtyArray.get(j));
            product.setQtystock(String.valueOf(diff));
            repoProduct.save(product);
            j++;
        }
        return "redirect:/main";
    }


    @RequestMapping("/testGet")
    public String postSeries(HttpServletRequest request, @RequestBody List<OrderDetailDTO> list) {
        Orders order = repoOrders.save(new Orders(list.get(1).getTotal()));
        for (OrderDetailDTO detail : list) {

            repoOrderDetails.save(new OrderDetails(order.getOrderid(), detail.getProductid(), detail.getQuantity(), detail.getPrice(), order.getTotal()));
        }
        return "main/asdfg.html";
    }

    @RequestMapping("/test")
    public String getAllOrders() {
        return "main/asdfg.html";
    }

}
