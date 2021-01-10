package com.hktv.hktv_interview.controller;

import com.hktv.hktv_interview.dto.ProductDto;
import com.hktv.hktv_interview.model.Product;
import com.hktv.hktv_interview.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/all")
    public @ResponseBody
    List<ProductDto> getAllProducts() {
        List<Product> products = productService.getAllProduct();
        return products.stream().map(ProductDto::new).collect(Collectors.toList());
    }

    @PostMapping(value = "/add")
    public @ResponseBody
    ProductDto addProduct(
            @RequestParam String code,
            @RequestParam String name,
            @RequestParam Integer weight,
            @RequestParam String type,
            @RequestParam String unit
    ) {
        Product product = productService.addProduct(code, name, weight, type, unit, new Date());
        return new ProductDto(product);
    }


}
