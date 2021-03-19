package com.mmpharmacy.mmpharmacy.controller;

import com.mmpharmacy.mmpharmacy.dto.OrderDetailDTO;
import com.mmpharmacy.mmpharmacy.entity.OrderDetails;
import com.mmpharmacy.mmpharmacy.entity.Product;
import com.mmpharmacy.mmpharmacy.repo.RepoOrderDetails;
import com.mmpharmacy.mmpharmacy.repo.RepoProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ControllerMappingMain {
    @Autowired
    private RepoOrderDetails repoOrderDetails;

    @Autowired
    private RepoProduct repoProduct;

    @RequestMapping("/admin")
    public String openAdminPage(Model md){

        List<OrderDetails> orders = repoOrderDetails.findAll();

        List<Product> products = repoProduct.findAll();


//        for (int i=0;i<=orders.size();i++){
//            products = new Product();
//            System.out.println(products.getName());
//        }
//        for (OrderDetails order : orders) {
//             products = repoProduct.getOne(order.getProductid());
//
//
//            System.out.println("products: " + products);
//        }
//        System.out.println("orders     "+orders.get(1));
//        for (Product product : products) {
//
//
//        }
//      products = orders.get(1).getProductid();
        md.addAttribute("orders", orders);
        md.addAttribute("productname",products);

        return "admin/index.html";
//        return "admin/dashboard";
    }

//    @RequestMapping("/")
//    public String openMainPage() {
//        return "admin/index.html";
//    }


    @RequestMapping("/main")
    public String openIndex() {
        return "main/index.html";
    }
}
