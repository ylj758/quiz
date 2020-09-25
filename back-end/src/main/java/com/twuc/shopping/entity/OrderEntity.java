package com.twuc.shopping.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class OrderEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer price;
    private Integer count;
    private String unit;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productEntity;
}
