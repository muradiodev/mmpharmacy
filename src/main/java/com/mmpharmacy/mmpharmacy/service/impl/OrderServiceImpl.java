package com.mmpharmacy.mmpharmacy.service.impl;

import com.mmpharmacy.mmpharmacy.dto.OrderDetailDTO;
import com.mmpharmacy.mmpharmacy.entity.*;
import com.mmpharmacy.mmpharmacy.repo.*;
import com.mmpharmacy.mmpharmacy.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final RepoProduct repoProduct;
    private final RepoCategory repoCategory;
    private final RepoType repoType;
    private final RepoOrders repoOrders;
    private final RepoOrderDetails repoOrderDetails;


    @Override
    public void getAllProducts(Model model) {
        List<Product> products = repoProduct.findAllByIsactive("1");
        List<Category> categories = repoCategory.findAll();
        List<Type> types = repoType.findAll();

        model.addAttribute("products", products);
        model.addAttribute("categories", categories);
        model.addAttribute("types", types);
    }

    @Override
    public void updateProductAfterBuy(List<Integer> idArray, List<String> qtyArray){
        int diff = 0;
        int j = 0;
        for (Integer i : idArray) {
            Product product = repoProduct.getOne(i);
            diff = Integer.parseInt(product.getQtystock()) - Integer.parseInt(qtyArray.get(j));
            product.setQtystock(String.valueOf(diff));
            repoProduct.save(product);
            j++;
        }
    }

    public void postSeries(HttpServletRequest request, List<OrderDetailDTO> list){
        Orders order = repoOrders.save(new Orders(list.get(1).getTotal()));
        for (OrderDetailDTO detail : list) {
            repoOrderDetails.save(new OrderDetails(order.getOrderid(), detail.getProductid(), detail.getQuantity(), detail.getPrice(), order.getTotal()));
        }
    }
}
