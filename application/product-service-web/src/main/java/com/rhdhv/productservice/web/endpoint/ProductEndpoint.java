package com.rhdhv.productservice.web.endpoint;

import com.rhdhv.productservice.web.domain.response.ErrorResponse;
import com.rhdhv.productservice.web.domain.response.ProductsResponse;
import com.rhdhv.productservice.web.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@CrossOrigin(origins ="http://localhost:3000")
@Slf4j
public class ProductEndpoint {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/products", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getProducts() {
        try {
            return new ResponseEntity<>(new ProductsResponse(productService.getProducts()), HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ErrorResponse("Not able to acquire products from service"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
