package com.dotk.demo.dto;

import lombok.Data;

import java.util.Collection;

@Data
public class Customer {
    public Long id;
    public String name;
    public Collection<OrderItem> orderItems;
}
