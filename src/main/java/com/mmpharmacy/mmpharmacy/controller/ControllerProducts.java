package com.mmpharmacy.mmpharmacy.controller;


import com.mmpharmacy.mmpharmacy.entity.Product;
import com.mmpharmacy.mmpharmacy.entity.Supplier;
import com.mmpharmacy.mmpharmacy.entity.User;
import com.mmpharmacy.mmpharmacy.repo.RepoProduct;
import com.mmpharmacy.mmpharmacy.repo.RepoUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class ControllerProducts {

    @Autowired
    private RepoProduct repoProduct;

    @RequestMapping("/medicines")
    public String getAllProducts(Model md) {
        List<Product> products = repoProduct.findAll();
        for (Product product : products) {
            md.addAttribute("product", products);
        }
        return "admin/medicines.html";
    }

//    @RequestMapping("/deleteUser")
//    public String deleteUserById(@RequestParam("user_id") int user_id) {
//        User user = repoUser.getOne(user_id);
//        user.setIsActive("0");
//        repoUser.save(user);
//        return "redirect:/admin/users";
//    }
//
//    @RequestMapping("/addUser")
//    public String addUser(@RequestParam(value = "country", required = false) String country) {
//        User user = new User();
//
//        repoUser.save(user);
//        return "redirect:/admin/users";
//    }
//
//    @RequestMapping("/editUser")
//    public String editUser(@RequestParam(value = "user_id") int user_id) {
//        User user = repoUser.getOne(user_id);
////        user.setName(name);
////        user.setSurname(surname);
////        user.setEmail(email);
////        user.setPhone_number(phoneNumber);
//        repoUser.save(user);
//        return "redirect:/admin/users";
//    }
}
