
	package com.cg.go.service;

	import javax.persistence.EntityManager;
	import javax.persistence.EntityTransaction;

	import com.cg.go.dao.IUserRepository;
	import com.cg.go.dao.UserRepositoryImpl;
	import com.cg.go.entity.Userdata;
	import com.cg.go.util.JpaUtil;

	public class UserServiceImpl implements IUserService {
		EntityManager entityManager=JpaUtil.getEntityManager();
		IUserRepository daoUser=new UserRepositoryImpl(entityManager);

		public Userdata addUser(Userdata user) {
			
			EntityTransaction transaction = entityManager.getTransaction();
	        transaction.begin();
	         user=daoUser.addUser(user);
	        transaction.commit();
			return user;
		}

		public Userdata loginUser(Userdata user) {
			EntityTransaction transaction = entityManager.getTransaction();
	        transaction.begin();
	         user=daoUser.loginUser(user);
	        transaction.commit();
			return user;
			
		}

		public Userdata logout(Userdata user) {
					EntityTransaction transaction = entityManager.getTransaction();
			        transaction.begin();
			         user=daoUser.logout(user);
			        transaction.commit();
					return user;
		
		}

	}

		
