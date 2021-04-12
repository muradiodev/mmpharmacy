package com.mmpharmacy.mmpharmacy.service;

import org.springframework.ui.Model;

import java.util.List;

public interface CategoryService {


    void openAdminPage(Model md);

    List<String> getCategoriesName();

    List<String> getTypesName();
}
