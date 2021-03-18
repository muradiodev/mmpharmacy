package com.mmpharmacy.mmpharmacy.controller;

import com.mmpharmacy.mmpharmacy.entity.OrderDetails;
import com.mmpharmacy.mmpharmacy.repo.RepoOrderDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class ControllerMappingMain {
    @Autowired
    private RepoOrderDetails repoOrderDetails;


    @RequestMapping("/admin")
    public String openAdminPage(Model md){

        List<OrderDetails> od = repoOrderDetails.findAll();


        md.addAttribute("orders", od);

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
