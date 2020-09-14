package com.rhdhv.productservice.web.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private String name;

    private double weight;

    private double price;
}
