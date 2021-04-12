package com.mmpharmacy.mmpharmacy.service.impl;

import com.mmpharmacy.mmpharmacy.entity.Category;
import com.mmpharmacy.mmpharmacy.entity.Product;
import com.mmpharmacy.mmpharmacy.entity.Type;
import com.mmpharmacy.mmpharmacy.repo.RepoCategory;
import com.mmpharmacy.mmpharmacy.repo.RepoProduct;
import com.mmpharmacy.mmpharmacy.repo.RepoType;
import com.mmpharmacy.mmpharmacy.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final RepoCategory repoCategory;
    private final RepoType repoType;
    private final RepoProduct repoProduct;

    @Override
    public void findAllByIsActive(Model md) {

        List<Product> products = repoProduct.findAllByIsactive("1");
        List<Category> categories = repoCategory.findAll();
        List<Type> types = repoType.findAll();


        md.addAttribute("products", products);
        md.addAttribute("categories", categories);
        md.addAttribute("types", types);
    }

    @Override
    public void deleteProductById(int id) {
        Product product = repoProduct.getOne(id);
        product.setIsactive("0");
        repoProduct.save(product);
    }

    @Override
    public void getOneProduct(Model md, int id){
        Product products = repoProduct.getOne(id);
        md.addAttribute("oneproduct", products.getCategories());
        md.addAttribute("typeproduct", products.getTypes());
    }

    @Override
    public void updateProduct(int id,
                              List<Integer> myArray,
                              List<Integer> tArray,
                              String name,
                              String description,
                              String qtystock,
                              String price) {
        Product product = repoProduct.getOne(id);
        Set<Category> categories = new HashSet<>();
        Set<Type> types = new HashSet<>();

        for (Integer integer : myArray) {
            Category cat = repoCategory.getOne(integer);
            categories.add(cat);
        }

        for (Integer integert : tArray) {
            Type type = repoType.getOne(integert);
            types.add(type);
        }

        product.setCategories(categories);
        product.setTypes(types);
        product.setName(name);
        product.setDescription(description);
        product.setQtystock(qtystock);
        product.setPrice(price);
        repoProduct.save(product);
    }

    @Override
    public void addSupplier(List<Integer> myArray,
                     List<Integer> tArray,
                     String name,
                     String description,
                     String qtystock,
                     String price) {
        Set<Category> categories = new HashSet<>();
        Set<Type> types = new HashSet<>();

        for (Integer integer : myArray) {
            Category cat = repoCategory.getOne(integer);
            categories.add(cat);
        }

        for (Integer integert : tArray) {
            Type type = repoType.getOne(integert);
            types.add(type);
        }

        Product product = new Product(name, description, qtystock, price, "1");
        product.setCategories(categories);
        product.setTypes(types);
        System.out.println("product" + product);

        repoProduct.save(product);
    }
}
