package com.mmpharmacy.mmpharmacy.repo;

import com.mmpharmacy.mmpharmacy.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepoCategory extends JpaRepository<Category, Integer> {

    List<Category> findAll();
}
