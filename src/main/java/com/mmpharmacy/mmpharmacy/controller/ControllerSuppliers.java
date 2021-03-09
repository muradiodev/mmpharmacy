package com.mmpharmacy.mmpharmacy.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ControllerSuppliers {

    @RequestMapping("/suppliers")
    public String openAdminPage(){
        return "admin/suppliers.html";
    }

    //todo: getAllTables, edit, delete as update


}
