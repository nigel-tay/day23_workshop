package com.example.demo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Order;

import jakarta.annotation.PostConstruct;

@Repository
public class OrderRepository {
    
    @Autowired
    JdbcTemplate jTemplate;

    private final String getOrderSummaryWithIdSQL = "SELECT * FROM order_summary WHERE id = ?;";

    @PostConstruct
    public void checkView() {
        jTemplate.execute(
            """
                CREATE OR REPLACE VIEW order_summary AS 
                SELECT o.id, o.order_date, o.customer_id, 
                SUM(od.quantity * od.unit_price * (1 - od.discount)) AS total, 
                SUM(p.standard_cost * od.quantity) AS cost_price FROM orders o
                INNER JOIN order_details od ON od.order_id = o.id
                INNER JOIN products p ON p.id = od.product_id
                GROUP BY o.id;    
            """
        );
    }

    public Order getOrderSummary(int id) {
        return jTemplate.queryForObject(
            getOrderSummaryWithIdSQL,
            BeanPropertyRowMapper.newInstance(Order.class),
            id);
    }
}
