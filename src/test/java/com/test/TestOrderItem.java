package com.test;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cg.go.entity.OrderEntity;
import com.cg.go.entity.ProductEntity;
import com.cg.go.exception.OrderException;
import com.cg.go.exception.ProductException;
import com.cg.go.service.IOrderService;
import com.cg.go.service.IProductService;
import com.cg.go.service.OrderServiceImpl;
import com.cg.go.service.ProductServiceImpl;

public class TestOrderItem {

	@Test
	public void addOrderTest() throws ProductException, OrderException{
		IProductService productService=new ProductServiceImpl();
		IOrderService orderService=new OrderServiceImpl();
		LocalDate dispatchDate = LocalDate.of( 2015 , 6 , 7 );
		LocalDate localDate = LocalDate.of( 2017 , 6 , 7 );
		ProductEntity productEntity=new ProductEntity("123","Santoor",52.0,"mummy","orange","soap",2,"wipro","moisturizing soap");
		productService.addProduct(productEntity);
		List<ProductEntity> list=productService.findAllProducts();
		Map<ProductEntity,Integer> products=new HashMap<ProductEntity,Integer>();
		for(ProductEntity l:list) {
			products.put(l,l.getQuantity());
		}
		OrderEntity orderEntity=new OrderEntity("5","70",products,5,10l,localDate,dispatchDate);
		orderService.addOrder(orderEntity);
		Assertions.assertEquals("5",orderEntity.getOrderId());
		Assertions.assertEquals("70",orderEntity.getUserId());

	}
}