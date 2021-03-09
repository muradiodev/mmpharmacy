package com.mmpharmacy.mmpharmacy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ControllerDashboard {

    @RequestMapping("/dashboard")
    public String openAdminPage(){
        return "admin/index.html";
    }

    //TODO: check later and add all sales


}
