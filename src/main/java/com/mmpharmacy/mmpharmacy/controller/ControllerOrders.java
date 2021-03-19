package com.mmpharmacy.mmpharmacy.controller;

import com.mmpharmacy.mmpharmacy.dto.OrderDetailDTO;
import com.mmpharmacy.mmpharmacy.entity.*;
import com.mmpharmacy.mmpharmacy.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
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

    @Autowired
    private RepoOrders repoOrders;

    @Autowired
    private RepoOrderDetails repoOrderDetails;

    @RequestMapping("/")
    public String getAllProducts(Model md) {
        List<Product> products = repoProduct.findAllByIsactive("1");
        List<Category> categories = repoCategory.findAll();
        List<Type> types = repoType.findAll();

        md.addAttribute("products", products);
        md.addAttribute("categories", categories);
        md.addAttribute("types", types);

        return "main/index.html";
    }

    @RequestMapping("/testGet")
    public String postSeries(HttpServletRequest request, @RequestBody List<OrderDetailDTO> list) {


        Orders order = repoOrders.save(new Orders(list.get(1).getTotal()));

        for (OrderDetailDTO detail : list) {

            repoOrderDetails.save(new OrderDetails(order.getOrderid(), detail.getProductid(), detail.getQuantity(), detail.getPrice(),order.getTotal()));
        }


//        int productid = Integer.parseInt(request.getParameter("productid"));
//        String quantity = request.getParameter("quantity");
//        String quantity = orders.get(1);
//        String price = request.getParameter("price");
//        System.out.println("productid = " + productid);
//        System.out.println("quantity = " + quantity);
//        System.out.println("price = " + price);
//    public ResponseEntity deleteUserById(HttpServletRequest request) {
//
//        int id = Integer.parseInt(request.getParameter("id"));
//        Product products = repoProduct.getOne(orders.get(1).ge);
//
//        orders.forEach(System.out::println);
//            Product prd = orders.get(1);

//        for (int i = 0; i < orders.size(); i++) {
//            System.out.println(orders.get(0));
//            for (Product product :orders.get(i).getProducts()) {
//                System.out.println(product.getProductid());
//            }
//
//
//            System.out.println("2- quantity - "+orders.get(i).getQuantity());
//            System.out.println("3-price - "+orders.get(i).getPrice());
//            System.out.println(" --- ");
//
//
//
//        }
        // Handle myObjects
        return "main/asdfg.html";
    }

    @RequestMapping("/test")
    public String getAllOrders() {
        return "main/asdfg.html";
    }

}
