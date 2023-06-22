package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.example.demo.model.Order;

@Service
public class OrderService {
    
    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:4000/order/total/";

    public Order getOrder(String id) {
        ResponseEntity<Order> response = restTemplate.getForEntity(url + id, Order.class);
        return response.getBody();
    }
}
