package com.twuc.shopping.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.dto.Product;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<String> getProducts() throws JsonProcessingException {
        List<ProductEntity> productEntityList = productService.findAll();
        String json = new ObjectMapper().writeValueAsString(productEntityList);
        return ResponseEntity.ok(json);
    }

    @PostMapping("/product/add")
    public ResponseEntity<Object> addProduct(@Valid @RequestBody Product product ){
        productService.save(product);
        return ResponseEntity.created(null).build();
    }

}
