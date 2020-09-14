package com.rhdhv.productservice.web.service;

import com.rhdhv.productservice.web.Util.CsvReaderUtil;
import com.rhdhv.productservice.web.domain.Product;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@Service
public class ProductService {

    public List<Product> getProducts () throws IOException {
        return CsvReaderUtil.readCsv();
    }
}
