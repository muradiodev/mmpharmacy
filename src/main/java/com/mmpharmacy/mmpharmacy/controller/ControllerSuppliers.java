package com.mmpharmacy.mmpharmacy.controller;


import com.mmpharmacy.mmpharmacy.entity.Country;
import com.mmpharmacy.mmpharmacy.entity.Supplier;
import com.mmpharmacy.mmpharmacy.repo.RepoCountry;
import com.mmpharmacy.mmpharmacy.repo.RepoSupplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/admin")
public class ControllerSuppliers {

    @Autowired
    private RepoSupplier repoSupplier;

    @Autowired
    private RepoCountry repoCountry;

    //todo: getAllTables, edit, delete as update

    @RequestMapping("/suppliers")
    public String findAllByIsActive(Model md) {

        List<Supplier> suppliers = repoSupplier.findAllByIsactive("1");
        List<Country> countries = repoCountry.findAllByOrderByCountryid();

        md.addAttribute("supplier", suppliers);
        md.addAttribute("countriess", countries);


        return "admin/suppliers.html";
    }

    @RequestMapping("/deleteSupplier")
    @ResponseBody
    public ResponseEntity deleteSupplierById(HttpServletRequest request) {

        int id = Integer.parseInt(request.getParameter("id"));

        Supplier sup = repoSupplier.getOne(id);
        sup.setIsactive("0");
        repoSupplier.save(sup);

        return ResponseEntity.status(HttpStatus.OK).body("deleted");

    }


    @RequestMapping("/addSupplier")
    public String addSupplier(@RequestParam(value = "countryid", required = false) int countryid,
                              @RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "email", required = false) String email,
                              @RequestParam(value = "phonenumber", required = false) String phonenumber,
                              @RequestParam(value = "address", required = false) String address) {

        Country cnt = repoCountry.getOne(countryid);

        Supplier sup = new Supplier(name, address, phonenumber, email, "1");
        sup.setCountry(cnt);
        System.out.println("suppppp" + sup);

        repoSupplier.save(sup);
        return "redirect:/admin/suppliers";
    }

    @RequestMapping("/updateSupplier")
    public String updateSupplier(@RequestParam(value = "id") int id, @RequestParam(value = "countryid", required = false) int countryid, @RequestParam(value = "name", required = false) String name, @RequestParam(value = "email", required = false) String email, @RequestParam(value = "phonenumber", required = false) String phonenumber, @RequestParam(value = "address", required = false) String address) {
        Supplier sup = repoSupplier.getOne(id);
        Country cnt = repoCountry.getOne(countryid);
        sup.setEmail(email);
        sup.setAddress(address);
        sup.setName(name);
        sup.setPhonenumber(phonenumber);
        sup.setCountry(cnt);
        repoSupplier.save(sup);
        return "redirect:/admin/suppliers";
    }
}
