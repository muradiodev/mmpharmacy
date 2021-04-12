package com.mmpharmacy.mmpharmacy.controller;


import com.mmpharmacy.mmpharmacy.repo.RepoCategory;
import com.mmpharmacy.mmpharmacy.repo.RepoType;
import com.mmpharmacy.mmpharmacy.service.impl.CategoryServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin")
public class ControllerCategories {

    private final CategoryServiceImpl categoryService;


    @RequestMapping("/categories")
    public String openAdminPage(Model md) {
        categoryService.openAdminPage(md);
        return "admin/categories.html";
    }

    @RequestMapping("/getCategoriesName")
    @ResponseBody
    public ResponseEntity<List<String>> getCategoriesName() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getCategoriesName());
    }

    @RequestMapping("/getTypesName")
    @ResponseBody
    public ResponseEntity<List<String>> getTypesName() {
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getTypesName());
    }

}
