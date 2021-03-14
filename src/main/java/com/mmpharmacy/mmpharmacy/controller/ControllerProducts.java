package com.mmpharmacy.mmpharmacy.controller;


import com.mmpharmacy.mmpharmacy.entity.*;
import com.mmpharmacy.mmpharmacy.repo.RepoCategory;
import com.mmpharmacy.mmpharmacy.repo.RepoProduct;
import com.mmpharmacy.mmpharmacy.repo.RepoType;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ControllerProducts {

    @Autowired
    private RepoCategory repoCategory;

    @Autowired
    private RepoType repoType;

    @Autowired
    private RepoProduct repoProduct;

    @RequestMapping("/products")
    public String findAllByIsActive(Model md) {

        List<Product> products = repoProduct.findAllByIsactive("1");
        List<Category> categories = repoCategory.findAll();
        List<Type> types = repoType.findAll();


        md.addAttribute("products", products);
        md.addAttribute("categories", categories);
        md.addAttribute("types", types);

        return "admin/products.html";
    }

    @RequestMapping("/deleteProduct")
    @ResponseBody
    public ResponseEntity deleteProductById(@RequestParam(value = "id") int id) {
//    public ResponseEntity deleteUserById(HttpServletRequest request) {
//
//        int id = Integer.parseInt(request.getParameter("id"));

        Product product = repoProduct.getOne(id);
        product.setIsactive("0");
        repoProduct.save(product);

        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }

    @RequestMapping("/getOneProduct")
    public ResponseEntity getOneProduct(Model md, @RequestParam(value = "id") int id) {

        Product products = repoProduct.getOne(id);


        md.addAttribute("oneproduct", products.getCategories());
//        System.out.println("asdfg + "+id);
//        System.out.println("products1 + "+);

//        return "redirect:/admin/suppliers";
        return ResponseEntity.status(HttpStatus.OK).body(md);
    }


//    @RequestMapping("/addProduct")
//    public String addSupplier(@RequestParam(value = "countryid", required = false) int countryid,
//                              @RequestParam(value = "name", required = false) String name,
//                              @RequestParam(value = "email", required = false) String email,
//                              @RequestParam(value = "phonenumber", required = false) String phonenumber,
//                              @RequestParam(value = "address", required = false) String address) {
//
//        Country cnt = repoCountry.getOne(countryid);
//
//        Supplier sup = new Supplier(name, address, phonenumber, email, "1");
//        sup.setCountry(cnt);
//        System.out.println("suppppp" + sup);
//
//        repoSupplier.save(sup);
//        return "redirect:/admin/suppliers";
//    }


}
