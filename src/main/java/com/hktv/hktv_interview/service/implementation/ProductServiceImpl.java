package com.hktv.hktv_interview.service.implementation;

import com.hktv.hktv_interview.model.Product;
import com.hktv.hktv_interview.repository.ProductRepository;
import com.hktv.hktv_interview.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product addProduct(String code, String name, Integer weight, String type, String unit, Date createAt) {
        Product product = new Product();
        product.setCode(code);
        product.setName(name);
        product.setWeight(weight);
        product.setType(type);
        product.setUnit(unit);
        product.setCreateAt(createAt);
        product = productRepository.save(product);
        return product;
    }

    @Override
    public List<Product> getAllProduct() {
        List<Product> products = productRepository.findAll();
        return products.stream().collect(Collectors.toList());
    }


}
