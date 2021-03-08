package com.mmpharmacy.mmpharmacy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ControllerCategories {

    @RequestMapping("/categories")
    public String openAdminPage() {
//        private String value = "0";
//        value.toString().addAttribute("ticket", "123");

        return "admin/categories.html";
    }
}
