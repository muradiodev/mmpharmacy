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
import java.util.*;

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
        md.addAttribute("typeproduct", products.getTypes());
//        System.out.println("asdfg + "+id);
//        System.out.println("products1 + "+);

//        return "redirect:/admin/suppliers";
        return ResponseEntity.status(HttpStatus.OK).body(md);
    }

    @RequestMapping("/updateProduct")
    public String updateProduct(@RequestParam(value = "id") int id,
                                @RequestParam(value = "myArray[]", required = false) List<Integer> myArray,
                                @RequestParam(value = "name", required = false) String name,
                                @RequestParam(value = "description", required = false) String description,
                                @RequestParam(value = "qtystock", required = false) String qtystock,
                                @RequestParam(value = "price", required = false) String price) {


        Product product = repoProduct.getOne(id);
        Set<Category> categories = new HashSet<>();

        for (Integer integer : myArray) {
            Category cat = repoCategory.getOne(integer);
            categories.add(cat);
        }

        product.setCategories(categories);
        product.setName(name);
        product.setDescription(description);
        product.setQtystock(qtystock);
        product.setPrice(price);
        repoProduct.save(product);
        return "redirect:/admin/products";
    }

//    @RequestMapping("/addProduct")
//    public String addSupplier(@RequestParam(value = "id") int id,
//                              @RequestParam(value = "myArray[]", required = false) List<Integer> myArray,
//                              @RequestParam(value = "name", required = false) String name,
//                              @RequestParam(value = "description", required = false) String description,
//                              @RequestParam(value = "qtystock", required = false) String qtystock,
//                              @RequestParam(value = "price", required = false) String price) {
//
//        Set<Category> categories = new HashSet<>();
//
//        for (Integer integer : myArray) {
//            Category cat = repoCategory.getOne(integer);
//            categories.add(cat);
//        }
//
//        Product product = new Product(name, description, qtystock, price, "1");
//        product.setCategories(categories);
//        System.out.println("product" + product);
//
//        repoProduct.save(product);
//        return "redirect:/admin/products";
//    }

}
