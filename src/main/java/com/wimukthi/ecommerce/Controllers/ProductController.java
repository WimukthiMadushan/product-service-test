package com.wimukthi.ecommerce.Controllers;


import com.wimukthi.ecommerce.Entity.Product;
import com.wimukthi.ecommerce.Services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @GetMapping
    public List<Product> getAllProducts(){
        return service.getAllProducts();
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product){
        return service.createProduct(product);
    }


}
