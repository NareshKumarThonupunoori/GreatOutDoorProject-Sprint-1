package com.cg.go.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.go.entity.Userdata;
import com.cg.go.service.IUserService;
import com.cg.go.service.UserServiceImpl;

public class UserTest {
	public static void main(String[] args){
		IUserService userService=new UserServiceImpl();
		Userdata userdata=new Userdata("Naresh",1,"Admin","naresh@1998");
		userService.addUser(userdata);
		System.out.println("Added Sucessfully");
	}
}
