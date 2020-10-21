package com.cg.go.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import com.cg.go.dao.*;
import com.cg.go.dao.CustomerRepositoryImpl;
import com.cg.go.dao.ICustomerRepository;
import com.cg.go.entity.CartItemEntity;
import com.cg.go.entity.Customer;
import com.cg.go.exception.CartException;
import com.cg.go.util.JpaUtil;

public class CartServiceImpl implements ICartService{
	EntityManager entityManager=JpaUtil.getEntityManager();
	ICartRepository daoCart=new CartRepositoryImpl(entityManager);
	public List<CartItemEntity> findCartlist(String userId){
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<CartItemEntity> list=daoCart.findCartlist(userId);
        transaction.commit();
		return list;
	}
	public CartItemEntity findCartItem(String productId, String userId) {
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        CartItemEntity cartObject=daoCart.findCartItem(productId,userId);
        transaction.commit();
		return cartObject;
	}
	public CartItemEntity addCart(CartItemEntity cartItemEntity) throws CartException{
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        CartItemEntity cartObject=daoCart.addCart(cartItemEntity);
        transaction.commit();
		return cartObject;
	}

	public CartItemEntity updateCart(CartItemEntity cartItemEntity) throws CartException{
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        CartItemEntity cartObject=daoCart.updateCart(cartItemEntity);
        transaction.commit();
		return cartObject;
	}

	public void deleteCartItem(Long cartId,String productId) throws CartException{
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        daoCart.deleteCartItem(cartId,productId);
        transaction.commit();
	}

	public void deleteCartlist(String userId) throws CartException{
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        daoCart.deleteCartlist(userId);
        transaction.commit();
	}
}
