package com.cg.go.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.cg.go.entity.Customer;
import com.cg.go.entity.OrderEntity;
import com.cg.go.entity.Userdata;
import com.cg.go.entity.WishlistItemEntity;
import com.cg.go.exception.OrderException;
import com.cg.go.exception.WishlistException;

public class WishlistRepositoryImpl {
	private EntityManager entityManager;
	public WishlistRepositoryImpl(EntityManager entityManager){
     this.entityManager=entityManager;
	}
	public List<WishlistItemEntity> findAllItems(){
		List<WishlistItemEntity> list=new ArrayList<WishlistItemEntity>();
		list=entityManager.createQuery("select * from WishlistItemEntity").getResultList();
		return list;
	}
	public List<WishlistItemEntity> findWishlist(String userId){
		List<WishlistItemEntity> list=new ArrayList<WishlistItemEntity>();
		list=entityManager.createQuery("select * from WishlistItemEntity where userId='userId'").setParameter("userId", userId).getResultList();
		return list;
	}

	public WishlistItemEntity findWishlistItem(String productId, String userId) {
		//ToDo
		return null;
	}
	public void addProductToWishlist(String prodId,long wishlistID) {
		//ToDo
	}
	public void deleteWishlistItem(String productId, String userId) throws WishlistException{
		/*try{
			WishlistItemEntity wishlistItemEntity1 = entityManager.find(WishlistItemEntity.class,);
			if() {
				entityManager.persist(wishlistItem);
				return wishlistItem;
			}
	}*/
	}

	public void deleteWishlist(String userId) throws WishlistException{
		WishlistItemEntity wishlistItemEntity=entityManager.find(WishlistItemEntity.class,userId);	
		if(wishlistItemEntity==null) {
			throw new WishlistException("WishlistItemEntity not found");
		}
		else {
				entityManager.remove(wishlistItemEntity);
			}
	}

	public WishlistItemEntity addWishlistItem(WishlistItemEntity wishlistItem) throws WishlistException{
		if(wishlistItem==null) {
			throw new WishlistException("WishlistItemEntity not found");
		}
		else {
				entityManager.persist(wishlistItem);
				return wishlistItem;
			}
	}

}
