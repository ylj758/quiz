package com.twuc.shopping.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "order")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderEntity {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private Integer price;
    private Integer count;
    private String unit;
//    @ManyToOne
//    @JoinColumn(name = "product_id")
//    private ProductEntity productEntity;
}
