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
        orderService.deleteAll();
    }

    @Test
    void should_add_order_success() throws Exception {
        Order order = Order.builder()
                .name("可乐")
                .price(3)
                .unit("元/瓶")
                .count(1)
                .build();
        mockMvc.perform(post("/order/add")
                .content(new ObjectMapper().writeValueAsString(order))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        assertEquals(1, orderService.findAll().size());
    }

    @Test
    void should_add_order_unsuccess_when_name_is_null() throws Exception {
        Order order = Order.builder()
                .name("")
                .price(3)
                .unit("元/瓶")
                .count(1)
                .build();
        mockMvc.perform(post("/order/add")
                .content(new ObjectMapper().writeValueAsString(order))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_add_order_unsuccess_when_price_is_null() throws Exception {
        Order order = Order.builder()
                .name("noodles")
                .price(null)
                .unit("元/瓶")
                .count(1)
                .build();
        mockMvc.perform(post("/order/add")
                .content(new ObjectMapper().writeValueAsString(order))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_add_order_unsuccess_when_unit_is_null() throws Exception {
        Order order = Order.builder()
                .name("noodles")
                .price(2)
                .unit("")
                .count(1)
                .build();
        mockMvc.perform(post("/order/add")
                .content(new ObjectMapper().writeValueAsString(order))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_add_order_unsuccess_when_count_is_null() throws Exception {
        Order order = Order.builder()
                .name("noodles")
                .price(2)
                .unit("元/瓶")
                .count(null)
                .build();
        mockMvc.perform(post("/order/add")
                .content(new ObjectMapper().writeValueAsString(order))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    void should_find_all_orders_success() throws Exception {
        OrderEntity orderEntity1 = OrderEntity.builder()
                .name("可乐")
                .price(3)
                .unit("元/瓶")
                .count(3)
                .build();
        orderService.save(orderEntity1);
        OrderEntity orderEntity2 = OrderEntity.builder()
                .name("雪碧")
                .price(3)
                .unit("元/瓶")
                .count(4)
                .build();
        orderService.save(orderEntity2);
        mockMvc.perform(get("/orders"))
                .andExpect(status().isOk());
    }

    @Test
    void should_delete_order_by_id() throws Exception {
        OrderEntity orderEntity1 = OrderEntity.builder()
                .name("可乐")
                .price(3)
                .unit("元/瓶")
                .count(3)
                .build();
        orderService.save(orderEntity1);
        mockMvc.perform(delete("/order/delete/1"))
                .andExpect(status().isNoContent());
    }

}