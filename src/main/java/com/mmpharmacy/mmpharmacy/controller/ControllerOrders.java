package com.mmpharmacy.mmpharmacy.controller;

import com.mmpharmacy.mmpharmacy.entity.Category;
import com.mmpharmacy.mmpharmacy.entity.Product;
import com.mmpharmacy.mmpharmacy.entity.Type;
import com.mmpharmacy.mmpharmacy.repo.RepoCategory;
import com.mmpharmacy.mmpharmacy.repo.RepoProduct;
import com.mmpharmacy.mmpharmacy.repo.RepoType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/main")
public class ControllerOrders {

    @Autowired
    private RepoCategory repoCategory;

    @Autowired
    private RepoType repoType;

    @Autowired
    private RepoProduct repoProduct;

    @RequestMapping("/")
    public String getAllOrders(Model md) {
        List<Product> products = repoProduct.findAllByIsactive("1");
        List<Category> categories = repoCategory.findAll();
        List<Type> types = repoType.findAll();

        md.addAttribute("products", products);
        md.addAttribute("categories", categories);
        md.addAttribute("types", types);

        return "main/index.html";
    }

}
