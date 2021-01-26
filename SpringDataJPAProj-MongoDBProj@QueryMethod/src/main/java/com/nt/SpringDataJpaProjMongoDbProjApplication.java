package com.nt;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.document.Customer;
import com.nt.repository.CustomerRepo;

@SpringBootApplication
public class SpringDataJpaProjMongoDbProjApplication {

	public static void main(String[] args) {
		// get IOC container
		ApplicationContext ctx = SpringApplication.run(SpringDataJpaProjMongoDbProjApplication.class, args);
		// get Bean objectc
		CustomerRepo repo = ctx.getBean(CustomerRepo.class);
		/*
		 * //invode object List<Object[]> list=repo.getData("hyd"); list.forEach(row->{
		 * for(Object val:row) { System.out.println(val+" "); } });
		 * 
		 * 
		 * 
		 * 
		 * List<Customer> list1=repo.getAllData("hyd","ramesh"); list1.forEach(cust->
		 * System.out.println(cust) );
		 * 
		 * 
		 * List<Customer> list1=repo.getAllData1("hyd","ramesh"); list1.forEach(cust->
		 * System.out.println(cust) );
		 * 
		 * 
		 * 
		 * List<Customer> list1=repo.getAllData1("^h"); //cadd starting with h
		 * //List<Customer> list1=repo.getAllData1("g$"); //cadd ending with g
		 * list1.forEach(cust->{ System.out.println(cust); });
		 * 
		 * 
		 * List<Customer> list1=repo.getDataByCnoRange(50010,900000);
		 * list1.forEach(cust-> System.out.println(cust) );
		 */
		List<Customer> coustomerList = repo.getDataByOrCondition("^s", "hyd");
		coustomerList.forEach(customer -> {
			System.out.println(customer);
		});
		((ConfigurableApplicationContext) ctx).close();
	}

}
