package com.mmpharmacy.mmpharmacy.controller;

import com.mmpharmacy.mmpharmacy.dto.OrderDetailDTO;
import com.mmpharmacy.mmpharmacy.entity.OrderDetails;
import com.mmpharmacy.mmpharmacy.entity.Product;
import com.mmpharmacy.mmpharmacy.repo.RepoOrderDetails;
import com.mmpharmacy.mmpharmacy.repo.RepoProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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


//        System.out.println(repoOrderDetails.getAll());
//
//        List<OrderDetails> orders = repoOrderDetails.findAll();

//        md.addAttribute("orders", orders);
        return "admin/index.html";
    }



    @RequestMapping("/main")
    public String openIndex() {
        return "main/index.html";
    }
}
