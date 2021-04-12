package com.mmpharmacy.mmpharmacy.service;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface ProductService {

    void findAllByIsActive(Model md);

    void deleteProductById(int id);

    void getOneProduct(Model md, int id);

    void updateProduct(int id,
                       List<Integer> myArray,
                       List<Integer> tArray,
                       String name,
                       String description,
                       String qtystock,
                       String price);

    void addSupplier(List<Integer> myArray,
                     List<Integer> tArray,
                     String name,
                     String description,
                     String qtystock,
                     String price);
}
