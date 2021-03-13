package com.mmpharmacy.mmpharmacy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class ControllerTest {

    @RequestMapping("/test")
    public String findAllByIsActive() {
        return "admin/test.html";
    }
}
