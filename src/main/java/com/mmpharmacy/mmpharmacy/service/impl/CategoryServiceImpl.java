package com.mmpharmacy.mmpharmacy.service.impl;

import com.mmpharmacy.mmpharmacy.entity.Category;
import com.mmpharmacy.mmpharmacy.entity.Type;
import com.mmpharmacy.mmpharmacy.repo.RepoCategory;
import com.mmpharmacy.mmpharmacy.repo.RepoType;
import com.mmpharmacy.mmpharmacy.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final RepoCategory repoCategory;
    private final RepoType repoType;

    @Override
    public void openAdminPage(Model md) {
        List<Category> category = repoCategory.findAll();
        for (Category cat : category) {
            md.addAttribute("category", category);
        }
    }

    @Override
    public List<String> getCategoriesName() {
        List<Category> category = repoCategory.findAll();
        List<String> myCatArray = new ArrayList<>();
        for (int i = 0; i < category.size(); i++) {
            Category cat = category.get(i);
            myCatArray.add(cat.getName());
        }
        return myCatArray;
    }

    @Override
    public List<String> getTypesName() {
        List<Type> types = repoType.findAll();
        List<String> myTypeArray = new ArrayList<>();
        for (int i = 0; i < types.size(); i++) {
            Type type = types.get(i);
            myTypeArray.add(type.getName());
        }
        return myTypeArray;
    }
}