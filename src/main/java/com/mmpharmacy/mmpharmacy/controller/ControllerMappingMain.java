package com.mmpharmacy.mmpharmacy.controller;

import com.mmpharmacy.mmpharmacy.repo.RepoOrderDetails;
import com.mmpharmacy.mmpharmacy.service.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class ControllerMappingMain {

    private final OrderServiceImpl orderService;

    @RequestMapping("/admin")
    public String openAdminPage(Model md) {
        orderService.getAllOrders(md);
        return "admin/index.html";
    }


    @RequestMapping("/main")
    public String openIndex() {
        return "main/index.html";
    }
}
