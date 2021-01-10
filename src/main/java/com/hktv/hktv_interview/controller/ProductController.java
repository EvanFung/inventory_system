package com.hktv.hktv_interview.controller;

import com.hktv.hktv_interview.dto.ProductDto;
import com.hktv.hktv_interview.dto.StockDto;
import com.hktv.hktv_interview.model.Product;
import com.hktv.hktv_interview.model.Stock;
import com.hktv.hktv_interview.response.ResponseMessage;
import com.hktv.hktv_interview.service.ProductService;
import com.hktv.hktv_interview.utils.CSVHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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


    @PostMapping(value = "/upload")
    public ResponseEntity<ResponseMessage> uploadFile(@RequestParam MultipartFile file) {
        String message = "";
        if (CSVHelper.hasCSVFormat(file)) {
            try {
                productService.uploadProducts(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
            } catch (Exception e) {
                System.out.println(e);
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
            }
        }
        message = "Please upload a csv file";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseMessage(message));
    }

//    @GetMapping("/${productId}")
//    public @ResponseBody
//    ProductDto getProductById(@PathVariable Integer productId) {
//        Product product = productService.getProductById(productId);
//        return new ProductDto(product);
//    }

    @GetMapping(value="/{productId}")
    public @ResponseBody ProductDto getStocksByProductId(@PathVariable Integer productId) {
        Product product =  productService.getProductById(productId);
        return new ProductDto(product);
    }

}
