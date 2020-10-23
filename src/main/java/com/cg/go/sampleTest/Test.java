package com.cg.go.sampleTest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.cg.go.entity.*;
import com.cg.go.service.*;
import com.cg.go.service.ICustomerService;
import com.cg.go.service.OrderServiceImpl;
public class Test {

	public static void main(String[] args) throws Exception{
			EntityManagerFactory factory= Persistence.createEntityManagerFactory("MyPU");
			EntityManager entityManager = factory.createEntityManager();
			EntityTransaction et=entityManager.getTransaction();
			//IOrderService orderService=new OrderServiceImpl();
			//IProductRepository daoProduct=new ProductRepositoryImpl(entityManager);
			/*Address address=new Address(11,5,"bankcolony", "wgl", "wgl","telangana",506002);
			LocalDate localDate = LocalDate.of( 2015 , 6 , 7 );
			Customer customer1=new Customer(10,"naresh","8179563708","thon@gmail.com",address,"retailer");
			
			Customer customer2=new Customer(11,"arvind","xxxxxxxxxx","arvi@gmail.com",address,"sales");
			ICustomerService customerService=new CustomerServiceImpl();
			customerService.addCustomer(customer1);
			customerService.updateCustomer(customer2);
			List<Customer> list=new ArrayList<Customer>();
			//customerService.removeCustomer(customer1);
			list=customerService.getAllCustomers();
			Customer c1=list.get(0);
			Customer c2=list.get(1);
			//Customer c2=customerService.viewCustomer(customer2);
			System.out.println(list);
	
			*/
			
			/*LocalDate dispatchDate = LocalDate.of( 2015 , 6 , 7 );
			LocalDate localDate = LocalDate.of( 2017 , 6 , 7 );
			ProductEntity productEntity=new ProductEntity("123","Santoor",52.0,"mummy","orange","soap",2,"wipro","moisturizing soap");
			List<ProductEntity> list=new ArrayList<ProductEntity>();
			list=daoProduct.findAllProducts();
			Map<ProductEntity,Integer> products=new HashMap<ProductEntity,Integer>();
			for(ProductEntity l:list) {
				products.put(l,l.getQuantity());
			}
			OrderEntity orderEntity1=new OrderEntity("5","70",products,5,10l,localDate,dispatchDate);
			OrderEntity orderEntity2=new OrderEntity("12","70",products,5,10l,localDate,dispatchDate);
			et.begin();
 			entityManager.persist(productEntity);
 			//entityManager.persist(orderEntity);
 			et.commit();
			orderService.addOrder(orderEntity1);
			//orderService.deleteAllOrders();
			orderService.addOrder(orderEntity2);
			orderService.deleteOrderById("12");
			//orderService.updateDate("5",dispatchDate,localDate);*/
			/*ICartService CartItemService=new CartServiceImpl();
			IProductRepository daoProduct=new ProductRepositoryImpl(entityManager);
			ProductEntity productEntity=new ProductEntity("123","Santoor",52.0,"mummy","orange","soap",2,"wipro","moisturizing soap");
			List<ProductEntity> list=new ArrayList<ProductEntity>();
			list=daoProduct.findAllProducts();
			Map<ProductEntity,Integer> products=new HashMap<ProductEntity,Integer>();
			for(ProductEntity l:list) {
				products.put(l,l.getQuantity());
			}
			CartItemEntity cartItemEntity1=new CartItemEntity(456,"70",products,507,10);
			CartItemEntity cartItemEntity2=new CartItemEntity(762,"79",products,549,7);
			et.begin();
 			entityManager.persist(productEntity);
 			//entityManager.persist(cartItemEntity2);
 			et.commit();
 			CartItemService.addCart(cartItemEntity1);
 			CartItemService.addCart(cartItemEntity2);
 			List<CartItemEntity> list1=new ArrayList<CartItemEntity>();
			list1=CartItemService.findCartlist("70");
			System.out.println(list1.get(0).getCartId());*/
			IUserService userService=new UserServiceImpl();
			Userdata userdata=new Userdata("Naresh",1,"Admin","naresh@1998");
			userService.addUser(userdata);
			System.out.println("Added Sucessfully");
	}
		 
}