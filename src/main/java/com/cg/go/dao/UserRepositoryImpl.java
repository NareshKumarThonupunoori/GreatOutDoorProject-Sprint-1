
package com.cg.go.dao;

import javax.persistence.EntityManager;

import com.cg.go.entity.Userdata;

public class UserRepositoryImpl implements IUserRepository {
	private EntityManager entityManager;

	public UserRepositoryImpl(EntityManager entityManager){
     this.entityManager=entityManager;
	}
	public Userdata addUser(Userdata user) {
		entityManager.persist(user);
		return user;
	}
	public Userdata loginUser(Userdata u) {
//		Userdata userdata = (Userdata) entityManager.createNamedQuery("Loggin in").setParameter("username", u.getUserName()).setParameter("password", u.getUserPassword()).getSingleResult();
		Userdata userdata = entityManager.find(Userdata.class, u.getUserName());
		if(userdata == null) {
			return null;
		}
		else {
			
			if(userdata.getUserPassword() ==u.getUserPassword()) {
				return userdata;
			}
		}
		return u;
	}
	public Userdata logout(Userdata user) {
		//ToDo
		return null;
	}

}
