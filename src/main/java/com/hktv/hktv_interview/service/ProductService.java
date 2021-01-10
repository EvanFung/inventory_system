package com.hktv.hktv_interview.service;

import com.hktv.hktv_interview.model.Product;
import org.springframework.web.multipart.MultipartFile;

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

    void uploadProducts(MultipartFile file);

    Product getProductById(Integer productId);
}
