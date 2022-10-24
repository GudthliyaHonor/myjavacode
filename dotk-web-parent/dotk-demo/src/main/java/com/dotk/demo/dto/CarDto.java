package com.dotk.demo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    private String make;

    private String specialization;

    private int seatCount;
    private String name;
    private String description;
}
