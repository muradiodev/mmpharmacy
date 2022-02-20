package com.mmpharmacy.mmpharmacy.service.impl;

import com.mmpharmacy.mmpharmacy.dto.OrderDetailDTO;
import com.mmpharmacy.mmpharmacy.entity.*;
import com.mmpharmacy.mmpharmacy.repo.*;
import com.mmpharmacy.mmpharmacy.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final RepoProduct repoProduct;
    private final RepoCategory repoCategory;
    private final RepoType repoType;
    private final RepoOrders repoOrders;
    private final RepoOrderDetails repoOrderDetails;
    private final RepoOrderDetailsDTO repoOrderDetailsDTO;


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
    public void updateProductAfterBuy(List<Integer> idArray, List<String> qtyArray) {
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

    public void postSeries(List<OrderDetailDTO> list) {
        System.out.println("list   " + list);
        Orders order =  Orders.builder().total(list.get(0).getTotal()).build();
        System.out.println("orderin deyeri  = " + order);
        repoOrders.save(order);




        for (OrderDetailDTO detail : list) {
//            repoOrderDetails.save(new OrderDetails(order.getOrderid(), detail.getProductid(), detail.getQuantity(), detail.getPrice(), order.getTotal()));
            repoOrderDetails.save(OrderDetails.builder()
                    .orderid(order.getOrderid())
                    .productid(detail.getProductid())
                    .quantity(detail.getQuantity())
                    .price(detail.getPrice())
                    .build()
        );
        }
    }

    @Override
    public void getAllOrders(Model model) {
        Optional<List<OrderDetails>> orderDetails = repoOrderDetails.findAllBy();


        if (orderDetails.isPresent()) {
            List<OrderDetailDTO> orderDetailDTOS = new ArrayList<>();
            orderDetails.get().forEach(detail -> {
                orderDetailDTOS.add(OrderDetailDTO.builder()
                        .orderid(detail.getOrderid())
                        .productid(detail.getProductid())
                        .quantity(detail.getQuantity())
                        .price(detail.getPrice())
                        .productName(repoProduct.findByProductid(detail.getProductid()).getName())
                        .build());
            });
            model.addAttribute("orderDetailDTOS", orderDetailDTOS);
        } else {
            model.addAttribute("orderDetailDTOS", null);
        }
    }

    @Override
    public void getRevenue(Model model) {

    }

}
