package com.twuc.shopping;

import com.twuc.shopping.entity.OrderEntity;
import com.twuc.shopping.entity.ProductEntity;
import com.twuc.shopping.service.OrderService;
import com.twuc.shopping.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ShoppingApplication {
	@Autowired
	ProductService productService;
	@Autowired
	OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(ShoppingApplication.class, args);
		new ShoppingApplication().initData();
	}


	private void initData() {
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

		ProductEntity productEntity1 = ProductEntity.builder()
				.name("可乐")
				.price(3)
				.unit("元/瓶")
				.img("1.png")
				.build();
		productService.save(productEntity1);
		ProductEntity productEntity2 = ProductEntity.builder()
				.name("雪碧")
				.price(3)
				.unit("元/瓶")
				.img("1.png")
				.build();
		productService.save(productEntity2);
		ProductEntity productEntity3 = ProductEntity.builder()
				.name("桃子")
				.price(3)
				.unit("元/瓶")
				.img("1.png")
				.build();
		productService.save(productEntity3);
		ProductEntity productEntity4 = ProductEntity.builder()
				.name("荔枝")
				.price(3)
				.unit("元/瓶")
				.img("1.png")
				.build();
		productService.save(productEntity4);
		ProductEntity productEntity5 = ProductEntity.builder()
				.name("电池")
				.price(3)
				.unit("元/瓶")
				.img("1.png")
				.build();
		productService.save(productEntity5);
		ProductEntity productEntity6 = ProductEntity.builder()
				.name("泡面")
				.price(3)
				.unit("元/瓶")
				.img("1.png")
				.build();
		productService.save(productEntity6);



	}
}
