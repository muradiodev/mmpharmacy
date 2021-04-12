package com.mmpharmacy.mmpharmacy.controller;


import com.mmpharmacy.mmpharmacy.entity.*;
import com.mmpharmacy.mmpharmacy.repo.RepoCategory;
import com.mmpharmacy.mmpharmacy.repo.RepoProduct;
import com.mmpharmacy.mmpharmacy.repo.RepoType;
import com.mmpharmacy.mmpharmacy.service.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@RequestMapping("/admin")
public class ControllerProducts {

    private final ProductServiceImpl productService;

    @RequestMapping("/products")
    public String findAllByIsActive(Model md) {
        productService.findAllByIsActive(md);
        return "admin/products.html";
    }

    @RequestMapping("/deleteProduct")
    @ResponseBody
    public ResponseEntity deleteProductById(@RequestParam(value = "id") int id) {
//    public ResponseEntity deleteProductById(HttpServletRequest request) {
//        int id = Integer.parseInt(request.getParameter("id"));
        productService.deleteProductById(id);
        return ResponseEntity.status(HttpStatus.OK).body("deleted");
    }

    @RequestMapping("/getOneProduct")
    public ResponseEntity getOneProduct(Model md, @RequestParam(value = "id") int id) {
        productService.getOneProduct(md, id);
        return ResponseEntity.status(HttpStatus.OK).body(md);
    }

    @RequestMapping("/updateProduct")
    public String updateProduct(@RequestParam(value = "id") int id,
                                @RequestParam(value = "myArray[]", required = false) List<Integer> myArray,
                                @RequestParam(value = "tArray[]", required = false) List<Integer> tArray,
                                @RequestParam(value = "name", required = false) String name,
                                @RequestParam(value = "description", required = false) String description,
                                @RequestParam(value = "qtystock", required = false) String qtystock,
                                @RequestParam(value = "price", required = false) String price) {

        productService.updateProduct(id, myArray, tArray, name, description, qtystock, price);
        return "redirect:/admin/products";
    }

    @RequestMapping("/addProduct")
    public String addSupplier(@RequestParam(value = "myArray[]", required = false) List<Integer> myArray,
                              @RequestParam(value = "tArray[]", required = false) List<Integer> tArray,
                              @RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "description", required = false) String description,
                              @RequestParam(value = "qtystock", required = false) String qtystock,
                              @RequestParam(value = "price", required = false) String price) {

        productService.addSupplier(myArray, tArray, name, description, qtystock, price);
        return "redirect:/admin/products";
    }

}
