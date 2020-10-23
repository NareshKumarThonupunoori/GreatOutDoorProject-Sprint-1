package com.cg.go.ui;
import com.cg.go.entity.Userdata;
import com.cg.go.service.IUserService;
import com.cg.go.service.UserServiceImpl;

public class UserTest {
	public static void main(String[] args){
		IUserService userService=new UserServiceImpl();
		Userdata userdata=new Userdata("Naresh","Admin","naresh@1998");
		userService.addUser(userdata);
		System.out.println("Added Sucessfully");
	}
}
