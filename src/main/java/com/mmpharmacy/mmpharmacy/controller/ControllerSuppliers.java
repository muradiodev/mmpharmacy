package com.mmpharmacy.mmpharmacy.controller;


import com.mmpharmacy.mmpharmacy.service.impl.SupplierServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class ControllerSuppliers {

    private final SupplierServiceImpl supplierService;

    @RequestMapping("/suppliers")
    public String findAllByIsActive(Model md) {
        supplierService.findAllByIsActive(md);
        return "admin/suppliers.html";
    }

    @RequestMapping("/deleteSupplier")
    @ResponseBody
    public ResponseEntity deleteSupplierById(HttpServletRequest request) {
        supplierService.deleteSupplierById(request);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }


    @RequestMapping("/addSupplier")
    public String addSupplier(@RequestParam(value = "countryid", required = false) int countryid,
                              @RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "email", required = false) String email,
                              @RequestParam(value = "phonenumber", required = false) String phonenumber,
                              @RequestParam(value = "address", required = false) String address) {
        supplierService.addSupplier(countryid, name, email, phonenumber, address);
        return "redirect:/admin/suppliers";
    }

    @RequestMapping("/updateSupplier")
    public String updateSupplier(@RequestParam(value = "id") int id, @RequestParam(value = "countryid", required = false) int countryid, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "email", required = false) String email, @RequestParam(value = "phonenumber", required = false) String phonenumber, @RequestParam(value = "address", required = false) String address) {
        supplierService.updateSupplier(id, countryid, name, email, phonenumber, address);
        return "redirect:/admin/suppliers";
    }
}
