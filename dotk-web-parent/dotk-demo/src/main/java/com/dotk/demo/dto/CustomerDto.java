package com.dotk.demo.dto;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class CustomerDto {
    public Long id;
    public String customerName;
    public List<OrderItemDto> orders;
}
