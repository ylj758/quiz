package com.twuc.shopping.service;

import com.twuc.shopping.dto.Product;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    public void deleteAll() {
        productRepository.deleteAll();
    }

    public void save(ProductEntity productEntity) {
        productRepository.save(productEntity);
    }

    public void save(Product product) {
        ProductEntity productEntity = ProductEntity.builder()
                .name(product.getName())
                .price(product.getPrice())
                .img(product.getImg())
                .unit(product.getUnit())
                .build();
        productRepository.save(productEntity);
    }
}
