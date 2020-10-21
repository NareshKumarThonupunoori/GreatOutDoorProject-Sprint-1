package com.cg.go.dao;

import java.util.*;

import javax.persistence.EntityManager;

import com.cg.go.entity.CartItemEntity;
import com.cg.go.entity.Customer;
import com.cg.go.exception.CartException;

public class CartRepositoryImpl implements ICartRepository{
	private EntityManager entityManager;

	public CartRepositoryImpl(EntityManager entityManager){
     this.entityManager=entityManager;
	}
	public List<CartItemEntity> findCartlist(String userId){
		List<CartItemEntity> list=new ArrayList<CartItemEntity>();
		list=entityManager.createQuery("select * from cartitementity").getResultList();
		return list;
	}
	public CartItemEntity findCartItem(String productId, String userId) {
	//ToDo	
		return null;
	}
	public CartItemEntity addCart(CartItemEntity cartItemEntity) throws CartException{
		CartItemEntity cartItem=entityManager.find(CartItemEntity.class,cartItemEntity.getCartId());
		if(cartItem.equals(cartItemEntity)) {
			throw new CartException("Already added into the cart");
		}
		else {
			entityManager.persist(cartItemEntity);
			return cartItemEntity;
		}
	}
	public CartItemEntity updateCart(CartItemEntity cartItemEntity) throws CartException{
		if(cartItemEntity==null) {
			throw new CartException("Not found in the cart");
		}
		else {
			entityManager.merge(cartItemEntity);
			return cartItemEntity;
		}
	}
	public void deleteCartItem(Long cartId,String productId) throws CartException{
		/*CartItemEntity cartItem=entityManager.find(CartItemEntity.class,cartId,productId);
		if(cartItem==null) {
			throw new CartException("Not found in the cart");
		}
		else {
			entityManager.remove(cartItemEntity);
			
		}*/
	}

	public void deleteCartlist(String userId) throws CartException{
		//ToDo
	}
}
