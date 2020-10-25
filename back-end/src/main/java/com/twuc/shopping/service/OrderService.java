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
import java.util.stream.Collectors;

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

    public void deleteAll() {
        orderRepository.deleteAll();
    }

    @Transactional
    public void save(List<Product> products) {
        double price = products.stream().collect(Collectors.summingDouble(Product::getPrice));
        OrderEntity orderEntity = OrderEntity.builder()
                .price(price)
                .build();
        save(orderEntity);

        for (Product product : products) {
            List<Integer> ids = productRepository.getProductId(product.getName());
            Integer productId = ids.get(0);
            ProductOrderContactEntity productOrderContactEntity = ProductOrderContactEntity.builder()
                    .productId(productId)
                    .orderId(orderEntity.getId())
                    .build();
            productOrderContactRepository.save(productOrderContactEntity);
        }


    }


}
