package com.twuc.shopping.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twuc.shopping.dto.Product;
import com.twuc.shopping.entity.ProductEntity;
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
class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ProductService productService;

    @BeforeEach
    void setUp() {
//        productService.deleteAll();
    }

    @AfterEach
    void tearDown() {
//        productService.deleteAll();
    }

    @Test
    void should_add_product_success() throws Exception {
        Product product = Product.builder()
                .name("可乐")
                .price(3)
                .unit("元")
                .img("1.png")
                .build();
        mockMvc.perform(post("/product/add")
                .content(new ObjectMapper().writeValueAsString(product))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
        assertEquals(1, productService.findAll().size());
    }

    @Test
    void should_find_all_products_success() throws Exception {
        List<ProductEntity> productEntityList = setData();
        mockMvc.perform(get("/products"))
                .andExpect(status().isOk());
//                .andExpect(jsonPath("$", is(new ObjectMapper().writeValueAsString(productEntityList))));

    }

    private List<ProductEntity> setData() {
        ProductEntity productEntity1 = ProductEntity.builder()
                .name("可乐")
                .price(3)
                .unit("元")
                .img("1.png")
                .build();
        productService.save(productEntity1);
        ProductEntity productEntity2 = ProductEntity.builder()
                .name("雪碧")
                .price(3)
                .unit("元")
                .img("1.png")
                .build();
        productService.save(productEntity2);
        ProductEntity productEntity3 = ProductEntity.builder()
                .name("桃子")
                .price(3)
                .unit("元")
                .img("1.png")
                .build();
        productService.save(productEntity3);
        ProductEntity productEntity4 = ProductEntity.builder()
                .name("荔枝")
                .price(3)
                .unit("元")
                .img("1.png")
                .build();
        productService.save(productEntity4);
        ProductEntity productEntity5 = ProductEntity.builder()
                .name("电池")
                .price(3)
                .unit("元")
                .img("1.png")
                .build();
        productService.save(productEntity5);
        ProductEntity productEntity6 = ProductEntity.builder()
                .name("泡面")
                .price(3)
                .unit("元")
                .img("1.png")
                .build();
        productService.save(productEntity6);

        List<ProductEntity> productEntityList = new ArrayList<>();
        productEntityList.add(productEntity1);
        productEntityList.add(productEntity2);
        productEntityList.add(productEntity3);
        productEntityList.add(productEntity4);
        productEntityList.add(productEntity5);
        productEntityList.add(productEntity6);
        return productEntityList;
    }
}