package com.example.demo.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Integer id;
    private Date orderDate;
    private Integer customerId;
    private Double total;
    private Double costPrice;
}
