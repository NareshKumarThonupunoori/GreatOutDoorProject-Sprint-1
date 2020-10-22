package com.cg.go.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.go.entity.CartItemEntity;
import com.cg.go.entity.ProductEntity;
import com.cg.go.service.CartServiceImpl;
import com.cg.go.service.ICartService;

public class CartItemTest {

	public static void main(String[] args) throws Exception{
		EntityManagerFactory factory= Persistence.createEntityManagerFactory("MyPU");
		EntityManager entityManager = factory.createEntityManager();
		EntityTransaction et=entityManager.getTransaction();
		ICartService CartItemService=new CartServiceImpl();
		IProductRepository daoProduct=new ProductRepositoryImpl(entityManager);
		ProductEntity productEntity=new ProductEntity("123","Santoor",52.0,"mummy","orange","soap",2,"wipro","moisturizing soap");
		List<ProductEntity> list=new ArrayList<ProductEntity>();
		list=daoProduct.findAllProducts();
		Map<ProductEntity,Integer> products=new HashMap<ProductEntity,Integer>();
		for(ProductEntity l:list) {
			products.put(l,l.getQuantity());
		}
		CartItemEntity cartItemEntity1=new CartItemEntity(456,"70",products,507,10);
		CartItemEntity cartItemEntity2=new CartItemEntity(762,"79",products,549,7);
		et.begin();
			entityManager.persist(productEntity);
			//entityManager.persist(cartItemEntity2);
			et.commit();
			CartItemService.addCart(cartItemEntity1);
			CartItemService.addCart(cartItemEntity2);
			List<CartItemEntity> list1=new ArrayList<CartItemEntity>();
		list1=CartItemService.findCartlist("70");
		System.out.println(list1.get(0).getCartId());
		System.out.println(list1.get(0).getProducts().toString());
		System.out.println("Added Successfully");
		}
}
