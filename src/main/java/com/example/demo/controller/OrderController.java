package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;
import com.example.demo.restcontroller.OrderRestController;
import com.example.demo.service.OrderService;

@Controller
@RequestMapping
public class OrderController {

    @Autowired
    OrderService oService;

    @GetMapping(path = "/")
    public String displayLanding(Model m) {
        m.addAttribute("order", new Order());
        return "landing";
    }

    @GetMapping(path = "/order")
    public String getOrderPage(@RequestParam String id, Model m) {
        m.addAttribute("order", oService.getOrder(id));
        return "landing";
    }
}
