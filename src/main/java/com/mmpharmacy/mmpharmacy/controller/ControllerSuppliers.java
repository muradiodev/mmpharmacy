package com.mmpharmacy.mmpharmacy.controller;


import com.mmpharmacy.mmpharmacy.entity.Category;
import com.mmpharmacy.mmpharmacy.entity.Supplier;
import com.mmpharmacy.mmpharmacy.repo.RepoSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ControllerSuppliers {

    @Autowired
    private RepoSupplier repoSupplier;

    @RequestMapping("/suppliers")
    public String openAdminPage(Model md){

        List<Supplier> suppliers = repoSupplier.findAllByIsActive("1");
        for (Supplier sup: suppliers){
            md.addAttribute("supplier", suppliers);
        }
        return "admin/suppliers.html";
    }

    //todo: getAllTables, edit, delete as update

//    @RequestMapping("/suppliers")
//    public String findAllByIsActive(Model md) {
//        List<Supplier> supplier = repoSupplier.findAllByIsActive("1");
//        for (Supplier sup: supplier){
//            md.addAttribute("suppliers", supplier);
//        }
//        return "admin/suppliers.html";
//    }

//    @GetMapping("/deleteSupplier")
//    public String deleteSupplierById(@RequestParam("id") int id) {
//        Supplier supplier = repoSupplier.findSupplierBySupplier_id(id);
//        supplier.setIsActive("0");
//        repoSupplier.save(supplier);
//        return "admin/suppliers.html";
//    }
}
