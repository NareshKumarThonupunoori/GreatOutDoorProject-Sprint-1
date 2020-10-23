package com.test;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.go.entity.Userdata;
import com.cg.go.entity.WishlistItemEntity;
import com.cg.go.service.WishlistServiceImpl;
import com.cg.go.util.JpaUtil;


public class TestWishlistFindItem {
	EntityManager entityManager;
	WishlistServiceImpl impl=new WishlistServiceImpl();
	 @BeforeEach
	 public void setup() {
	  //   impl = new UserRepositoryImpl();

	     JpaUtil jpaUtil = JpaUtil.getInstance();
	     entityManager = jpaUtil.getEntityManager();
	 }

	 @AfterEach
	 public void clear() {
	     EntityTransaction transaction = entityManager.getTransaction();
	     transaction.begin();
	     Query query = entityManager.createQuery("delete from Address");
	     query.executeUpdate();
	     transaction.commit();
	 }
	 @Test
	 void addWishlist() {
		String Id="nihaaa";
		Long l1=(long) 222345678; 
		
        WishlistItemEntity w1= new  WishlistItemEntity();
        impl.addProductToWishlist(Id, l1);
        TypedQuery<Userdata> query = entityManager.createQuery("from Userdata", Userdata.class);
        
        List<Userdata> list = query.getResultList();
        Assertions.assertEquals(1, list.size());
	
	 }
}
