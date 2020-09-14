package com.rhdhv.productservice.web.domain.response;

import com.rhdhv.productservice.web.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ProductsResponse {

    List<Product> products;
}
