package com.mmpharmacy.mmpharmacy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerMain {

    // thymeleaf
    @RequestMapping("/home")
    public String open() {

        return "admin/suppliers.html";
    }

}
