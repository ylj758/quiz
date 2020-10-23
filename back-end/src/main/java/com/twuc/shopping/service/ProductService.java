package com.twuc.shopping.service;

import com.twuc.shopping.dto.Product;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<ProductEntity> findAll() {
        return productRepository.findAll();
    }

    public boolean findByName(String name) {
        if(productRepository.findByName(name)==0)
            return false;
        return true;
    }


    public void deleteAll() {
        productRepository.deleteAll();
    }

    public void save(ProductEntity productEntity) {
        productRepository.save(productEntity);
    }

    public void save(Product product) throws Exception {
        if(findByName(product.getName())){
            throw new Exception("商品名称已存在，请输入新的商品名称") ;
        }
        ProductEntity productEntity = ProductEntity.builder()
                .name(product.getName())
                .price(product.getPrice())
                .img(product.getImg())
                .unit(product.getUnit())
                .build();
        productRepository.save(productEntity);
    }

}
