package com.mmpharmacy.mmpharmacy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerMappingMain {

    @RequestMapping("/admin")
    public String openAdminPage(){
        return "admin/index.html";
    }

    @RequestMapping("/")
    public String openMainPage() {
        return "admin/index.html";
    }
    @RequestMapping("/main")
    public String openIndex() {
        return "main/indexşhtml";
    }
}
