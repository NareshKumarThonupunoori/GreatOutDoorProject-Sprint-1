package com.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.cg.go.entity.CartItemEntity;
import com.cg.go.entity.ProductEntity;
import com.cg.go.exception.CartException;
import com.cg.go.exception.ProductException;
import com.cg.go.service.CartServiceImpl;
import com.cg.go.service.ICartService;
import com.cg.go.service.IProductService;
import com.cg.go.service.ProductServiceImpl;

public class TestCartItem {
	
	@Test
	public void testAddCart() throws ProductException, CartException {
		ICartService cartItemService=new CartServiceImpl();
		IProductService productService=new ProductServiceImpl();
		ProductEntity productEntity=new ProductEntity("123","Santoor",52.0,"mummy","orange","soap",2,"wipro","moisturizing soap");
		productService.addProduct(productEntity);
		List<ProductEntity> list=productService.findAllProducts();
		Map<ProductEntity,Integer> products=new HashMap<ProductEntity,Integer>();
		for(ProductEntity l:list) {
			products.put(l,l.getQuantity());
		}
		CartItemEntity cartItemEntity=new CartItemEntity(456,"70",products,507,10);
		CartItemEntity cartItem=cartItemService.addCart(cartItemEntity);
		Assertions.assertEquals(456,cartItem.getCartId());
		
	}
}
