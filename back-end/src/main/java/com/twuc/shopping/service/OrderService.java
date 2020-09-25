package com.twuc.shopping.service;

import com.twuc.shopping.dto.Order;
import com.twuc.shopping.entity.OrderEntity;
import com.twuc.shopping.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    OrderRepository orderRepository;

//    @Autowired
//    public OrderService(OrderRepository orderRepository) {
//        this.orderRepository = orderRepository;
//    }

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
}
