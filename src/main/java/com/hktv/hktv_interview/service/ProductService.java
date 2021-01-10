package com.hktv.hktv_interview.service;

import com.hktv.hktv_interview.model.Product;

import java.util.Date;
import java.util.List;

public interface ProductService {
    Product addProduct(
            String code,
            String name,
            Integer weight,
            String type,
            String unit,
            Date createAt
    );
    List<Product> getAllProduct();
}
