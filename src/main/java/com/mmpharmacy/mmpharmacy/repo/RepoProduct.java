package com.mmpharmacy.mmpharmacy.repo;

import com.mmpharmacy.mmpharmacy.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RepoProduct extends JpaRepository<Product,Integer> {

//    List<Product> findAllByIsActiveOrderById(int isActive);
}
