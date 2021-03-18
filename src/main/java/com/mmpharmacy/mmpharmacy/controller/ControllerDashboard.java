//package com.mmpharmacy.mmpharmacy.controller;
//
//
//import com.mmpharmacy.mmpharmacy.entity.Category;
//import com.mmpharmacy.mmpharmacy.entity.OrderDetails;
//import com.mmpharmacy.mmpharmacy.entity.Type;
//import com.mmpharmacy.mmpharmacy.repo.RepoOrderDetails;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/admin")
//public class ControllerDashboard {
//    @Autowired
//    private RepoOrderDetails repoOrderDetails;
//
//    @RequestMapping("/dashboard")
//    public String getAllOrders(Model md){
//        List<OrderDetails> od = repoOrderDetails.findAll();
//
//
//        md.addAttribute("orders", od);
//
//        return "admin/index.html";
//    }
//
//    //TODO: check later and add all sales
//
//
//}
