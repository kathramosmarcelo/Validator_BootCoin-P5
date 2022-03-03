package com.kramomar.validator.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidatorEntity {
    private String id;

    private String status;
    private double amount;
    private String paymode;
    private String numberPhone; 
}
