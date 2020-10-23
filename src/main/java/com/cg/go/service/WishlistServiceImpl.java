package com.cg.go.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.go.dao.IWishlistRepository;
import com.cg.go.dao.WishlistRepositoryImpl;
import com.cg.go.entity.WishlistItemEntity;
import com.cg.go.exception.WishlistException;
import com.cg.go.util.JpaUtil;


public class WishlistServiceImpl  implements IWishlistService{
	EntityManager entityManager=JpaUtil.getEntityManager();
	IWishlistRepository daoWishlist=new WishlistRepositoryImpl(entityManager);
	
	
	public List<WishlistItemEntity> findAllItems() {

		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<WishlistItemEntity> list=new ArrayList<WishlistItemEntity>();
        list=daoWishlist.findAllItems();
        transaction.commit();
		return list;
	}
	
	public List<WishlistItemEntity> findWishlist(String userId) {
	
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        List<WishlistItemEntity> list=new ArrayList<WishlistItemEntity>();
        list=daoWishlist.findWishlist(userId);
        transaction.commit();
		return list;
	}

	public WishlistItemEntity findWishlistItem(String productId, String userId) {
		
		EntityTransaction transaction = entityManager.getTransaction();
	    transaction.begin();
	    WishlistItemEntity wishlistObject =daoWishlist.findWishlistItem(productId,userId);
	    transaction.commit();
		return wishlistObject;
	}

	public void addProductToWishlist(String prodId, long wishlistID) {
		// TODO Auto-generated method stub
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        daoWishlist.addProductToWishlist(prodId, wishlistID );
        transaction.commit();
      
		
	}

	public void deleteWishlistItem(String productId, String userId) throws WishlistException {
		// TODO Auto-generated method stub
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        daoWishlist.deleteWishlistItem(productId, userId);
        transaction.commit();
		
	}

	public void deleteWishlist(String userId) throws WishlistException {
		
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        daoWishlist.deleteWishlist(userId);
        transaction.commit();
		
	}

	public WishlistItemEntity addWishlistItem(WishlistItemEntity wishlistItem) throws WishlistException {
		
		EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        WishlistItemEntity wishlistObject=daoWishlist.addWishlistItem(wishlistItem);
        transaction.commit();
		return wishlistObject;
	}

}
