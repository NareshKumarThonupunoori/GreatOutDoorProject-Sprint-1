
package com.cg.go.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.go.entity.WishlistItemEntity;
import com.cg.go.exception.WishlistException;

public class WishlistRepositoryImpl implements IWishlistRepository {
	private EntityManager entityManager;
	public WishlistRepositoryImpl(EntityManager entityManager){
     this.entityManager=entityManager;
	}
	public List<WishlistItemEntity> findAllItems(){
		List<WishlistItemEntity> query = entityManager.createQuery("select c from WishlistItemEntity c", WishlistItemEntity.class).getResultList();
		//List<WishlistItemEntity> list=query.getResultList();
		return query;
	}
	public List<WishlistItemEntity> findWishlist(String userId){
		TypedQuery<WishlistItemEntity> query = entityManager.createQuery("from WishlistItemEntity where userId=:userId", WishlistItemEntity.class);
		query.setParameter("userId", userId);
		List<WishlistItemEntity> list=query.getResultList();
		return list;
	}

	public WishlistItemEntity findWishlistItem(String productId, String userId) {
		String ql="from WishlistItemEntity where userId=:userId and :productId in productId";
		TypedQuery<WishlistItemEntity> query = entityManager.createQuery(ql, WishlistItemEntity.class);
		query.setParameter("userId", userId);
		query.setParameter("productId", productId);
		List<WishlistItemEntity> list=query.getResultList();
		if(list.isEmpty()) {
			return null;
		}
		return list.get(0);
	
	}
	public void addProductToWishlist(String prodId,long wishlistID) {
		String ql="from WishlistItemEntity  where wishlistId =:wishId ";
		TypedQuery<WishlistItemEntity> query = entityManager.createQuery(ql , WishlistItemEntity.class);
		query.setParameter("wishId", wishlistID);
		List<WishlistItemEntity> list=query.getResultList();
		if(list.isEmpty()) {
			return;
		}
		WishlistItemEntity entity =list.get(0);
		List<String> productIds=entity.getProductId();
		if(productIds==null) {
			productIds=new ArrayList<>();
			entity.setProductId(productIds);
			
		}
		if(!productIds.contains(prodId)) {
			productIds.add(prodId);
			entityManager.merge(entity);
			
		}
		
		
	}
	public void deleteWishlistItem(String productId, String userId) throws WishlistException{
		WishlistItemEntity entity= findWishlistItem(productId, userId);
	
		List<String> productIds=entity.getProductId();
		if(productIds==null || !productIds.contains(productId)) {
			throw new WishlistException("productId not found");
		}
		productIds.remove(productId);
		entityManager.merge(entity);
	}

	public void deleteWishlist(String userId) throws WishlistException{
		WishlistItemEntity wishlistItemEntity=entityManager.find(WishlistItemEntity.class,userId);	
		if(wishlistItemEntity==null) {
			throw new WishlistException("WishlistItemEntity not found");
		}
		
				entityManager.remove(wishlistItemEntity);
			
	}

	public WishlistItemEntity addWishlistItem(WishlistItemEntity wishlistItem) throws WishlistException{
		
		
				entityManager.persist(wishlistItem);
				return wishlistItem;
			
	}

}
