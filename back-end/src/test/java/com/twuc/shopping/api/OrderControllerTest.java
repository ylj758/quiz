package com.twuc.shopping.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.dto.Order;
import com.twuc.shopping.dto.Product;
import com.twuc.shopping.entity.OrderEntity;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.service.OrderService;
import com.twuc.shopping.service.ProductService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@AutoConfigureMockMvc
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
class OrderControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private OrderService orderService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void should_add_order_success() throws Exception {
        Order order = Order.builder()
                .name("可乐")
                .price(3)
                .unit("元/瓶")
                .build();
        mockMvc.perform(post("/order/add")
                .content(new ObjectMapper().writeValueAsString(order))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        assertEquals(1, orderService.findAll().size());
    }

    @Test
    void should_find_all_orders_success() throws Exception {
        OrderEntity orderEntity1 = OrderEntity.builder()
                .name("可乐")
                .price(3)
                .unit("元")
                .count(3)
                .build();
        orderService.save(orderEntity1);
        OrderEntity orderEntity2 = OrderEntity.builder()
                .name("雪碧")
                .price(3)
                .unit("元")
                .count(4)
                .build();
        orderService.save(orderEntity2);
        mockMvc.perform(get("/orders"))
                .andExpect(status().isOk());
    }

}