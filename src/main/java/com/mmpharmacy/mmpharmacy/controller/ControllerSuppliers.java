package com.mmpharmacy.mmpharmacy.controller;


import com.mmpharmacy.mmpharmacy.entity.Supplier;
import com.mmpharmacy.mmpharmacy.repo.RepoSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ControllerSuppliers {

    @Autowired
    private RepoSupplier repoSupplier;

    //todo: getAllTables, edit, delete as update

    @RequestMapping("/suppliers")
    public String findAllByIsActive(Model md) {
        List<Supplier> suppliers = repoSupplier.findAllByIsActive("1");
        System.out.println("aaaaaaaaaa " + suppliers);
        for (Supplier sup : suppliers) {
            md.addAttribute("supplier", suppliers);
        }
        return "admin/suppliers.html";
    }

    @RequestMapping("/deleteSupplier")
    public String deleteSupplierById(@RequestParam("supplier_id") int supplier_id) {
        Supplier sup = repoSupplier.getOne(supplier_id);
        sup.setIsActive("0");
        repoSupplier.save(sup);
        return "redirect:/admin/suppliers";

    }


    @RequestMapping("/addSupplier")
    public String addSupplier(@RequestParam(value = "country", required = false) String country) {
        Supplier sup = new Supplier();
        repoSupplier.save(sup);
        return "redirect:/admin/suppliers";
    }

    @RequestMapping("/editSupplier")
    public String editSupplier(@RequestParam(value = "id") int id) {
        Supplier sup = repoSupplier.getOne(id);
        repoSupplier.save(sup);
        return "redirect:/admin/suppliers";
    }
}
