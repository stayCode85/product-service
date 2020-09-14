package com.rhdhv.productservice.web.Util;

import com.rhdhv.productservice.web.domain.Product;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.ResourceUtils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Double.parseDouble;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CsvReaderUtil {

    private static final String COMMA_DELIMITER = ",";
    private static final String CLASSPATH_PRODUCTS_CSV = "classpath:products.csv";

    public static List<Product> readCsv() throws IOException {
        List<Product> products = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ResourceUtils.getFile(CLASSPATH_PRODUCTS_CSV)))) {
            String line;
            boolean firstLine = true;
            while ((line = br.readLine()) != null) {
                if (!firstLine) {
                    String[] values = line.split(COMMA_DELIMITER);
                    products.add(new Product(values[0], parseDouble(values[1]), parseDouble(values[2])));
                } else {
                    firstLine = false;
                }
            }
        }
        return products;
    }
}
