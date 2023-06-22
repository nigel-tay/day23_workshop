package com.example.demo.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Order;
import com.example.demo.repository.OrderRepository;

@RestController
@RequestMapping("/order/total")
public class OrderRestController {

    @Autowired
    OrderRepository oRepo;
    
    @GetMapping("/{orderId}")
    public ResponseEntity<Order> retrieveOrder(@PathVariable("orderId") String id) {
        int parsedInt = Integer.parseInt(id);
        return ResponseEntity.ofNullable(oRepo.getOrderSummary(parsedInt));
    }
}
