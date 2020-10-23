package com.twuc.shopping.service;

import com.twuc.shopping.dto.Order;
import com.twuc.shopping.dto.Product;
import com.twuc.shopping.entity.OrderEntity;
import com.twuc.shopping.entity.ProductOrderContactEntity;
import com.twuc.shopping.repository.OrderRepository;
import com.twuc.shopping.repository.ProductOrderContactRepository;
import com.twuc.shopping.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ProductOrderContactRepository productOrderContactRepository;

    public List<OrderEntity> findAll() {
        return orderRepository.findAll();
    }

    public void deleteById(int id) {
        orderRepository.deleteById(id);
    }

    public void save(OrderEntity orderEntity) {
        orderRepository.save(orderEntity);
    }

    public void save(Order order) {
        OrderEntity orderEntity = OrderEntity.builder()
                .name(order.getName())
                .count(order.getCount())
                .price(order.getPrice())
                .unit(order.getUnit())
                .build();
        orderRepository.save(orderEntity);
    }

    public void deleteAll() {
       orderRepository.deleteAll();
    }

    @Transactional
    public void save(List<Product> products) {

        for(Product product: products){
            List<String> ids = productRepository.getProductId(product.getName());
            String productId = ids.get(0);
            OrderEntity orderEntity = OrderEntity.builder()
                    .name(product.getName())
                    .count(1)
                    .price(product.getPrice())
                    .unit(product.getUnit())
                    .build();
            save(orderEntity);
//            ProductOrderContactEntity productOrderContactEntity = ProductOrderContactEntity.builder()
//                    .productId(String.valueOf(productId))
//                    .OrderId(orderEntity.getId())
//
//            .build();

//            productOrderContactRepository.save();
        }


    }


}
