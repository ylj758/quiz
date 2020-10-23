package com.twuc.shopping.repository;

import com.twuc.shopping.entity.ProductEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProductRepository extends CrudRepository<ProductEntity, Integer> {
    List<ProductEntity> findAll();
    @Query(nativeQuery = true, value = "select count(1) from product where name =?1")
    int findByName(String name);
}
