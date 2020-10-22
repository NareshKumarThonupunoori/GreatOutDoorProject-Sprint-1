package com.cg.go.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.*;

public class JpaUtil {

	EntityManagerFactory factory = Persistence.createEntityManagerFactory("MyPU");
	EntityManager entityManager = factory.createEntityManager();
	private Set<EntityManager> entityManagers = new HashSet<>();
	EntityTransaction entityTransaction = entityManager.getTransaction();
	private JpaUtil() {

	}
	private static JpaUtil instance = new JpaUtil();
	public static JpaUtil getInstance() {
		return instance;
	}
	public static EntityManager getEntityManager() {
		return new JpaUtil().entityManager;
	}

	public static EntityTransaction getTransaction() {
		return new JpaUtil().entityTransaction;
	}
	
	public void close() {
		for (EntityManager manager : entityManagers) {
			manager.close();
		}
		factory.close();
	}
}


