package com.twuc.shopping.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.dto.Order;
import com.twuc.shopping.dto.Product;
import com.twuc.shopping.entity.OrderEntity;
import com.twuc.shopping.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderService orderService;

//    public OrderController(OrderService orderService) {
//        this.orderService = orderService;
//    }

    @GetMapping("/orders")
    public ResponseEntity<String> getOrders() throws JsonProcessingException {
        List<OrderEntity> productEntityList = orderService.findAll();
        String json = new ObjectMapper().writeValueAsString(productEntityList);
        return ResponseEntity.ok(json);
    }

    @DeleteMapping("/order/delete/{id}")
    public ResponseEntity<Object> deleteOrder(@PathVariable  int id ){
        orderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/order/add")
    public ResponseEntity<Object> deleteOrder(@RequestBody Order order ){
        orderService.save(order);
        return ResponseEntity.noContent().build();
    }
}
