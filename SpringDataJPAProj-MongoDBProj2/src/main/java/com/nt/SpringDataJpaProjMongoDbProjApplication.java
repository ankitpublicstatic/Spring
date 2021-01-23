package com.nt;

import java.util.Optional;
import java.util.Random;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dto.CustomerDTO;
import com.nt.service.ICustomerMgmt;

@SpringBootApplication
public class SpringDataJpaProjMongoDbProjApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringDataJpaProjMongoDbProjApplication.class, args);
		ICustomerMgmt service = ctx.getBean("custService",ICustomerMgmt.class);
		
	//	System.out.println(service.registerOrUpdateCustomer(new CustomerDTO(new Random().nextInt(600000),"Rajnish kumar",99000.0f,"hyd")));
	//	System.out.println(service.fetchAllCustomers());
	//	service.fetchAllCustomers().forEach(System.out::println);
	//	System.out.println("---------------save oepration-----------------");
    //    System.out.println(service.registerOrUpdateCustomer(new CustomerDTO(new Random().nextInt(60000), "ramesh",7890.0f, "hyd")));
       // System.out.println(service.registerOrUpdateCustomer(new CustomerDTO(new Random().nextInt(60000), "suresh",1890.0f, "vizag")));


        Optional<CustomerDTO> opt=service.fetchCustomerByCno(12434);
        if(opt.isPresent())
        	System.out.println(opt.get());
        else
        	System.out.println("document not found");

		((ConfigurableApplicationContext) ctx).close();
	}

}
