package com.example.springbk1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbk1.entity.Product;
import com.example.springbk1.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return productService.createProduct(product);
    }

}

//sample json
// {
//     "name": "Product 2",
//     "description":"Thisis the description of product 2",
//     "price":5000,
//     "imageUrl":"car2.jpg"
// }
