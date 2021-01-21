package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dto.CustomerDTO;
import com.nt.generator.IDGenerator;
import com.nt.service.ICustomerMgmt;

@SpringBootApplication
public class SpringDataJpaProjMongoDbProjApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringDataJpaProjMongoDbProjApplication.class, args);
		ICustomerMgmt service = ctx.getBean("custService",ICustomerMgmt.class);
		
		//=============== Insert Data in MongoDB ==================
		//System.out.println(service.registerCustomer(new CustomerDTO(1111,"AnkitSonam",6789.77f)));
		/*
		 * CustomerDTO dto1 = new CustomerDTO();
		 * dto1.setCno(789);dto1.setCname("mahesh");dto1.setBillAmt(9900.0f);
		 * System.out.println(service.registerCustomer(dto1));
		 */
	//	System.out.println(service.registerCustomer(new CustomerDTO(556,"AnkitSonam",6789.77f,"hyd")));
		
		
		System.out.println(service.registerCustomer(new CustomerDTO("ABC123",9009,"Rajnish kumar",99000.0f,"hyd")));
		System.out.println(service.registerCustomer(new CustomerDTO("ABC124",9000,"Rajnish kumar",99000.0f,"hyd")));
		System.out.println(service.registerCustomer(new CustomerDTO(IDGenerator.genrateId(),9009,"Rajnish kumar",99000.0f,"hyd")));
		
		System.out.println("==================================");
		
		//=============== Update Data in MongoDB ==================
		/*
		 * CustomerDTO dto2 =new CustomerDTO(); dto2.setId("6008ddaa0e5419557116789f");
		 * dto2.setCno(556); dto2.setCname("raja"); dto2.setBillAmt(899999.0f);
		 * dto2.setCadd("delhi"); System.out.println(service.updateCustomer(dto2));
		 */
		
		
		
		((ConfigurableApplicationContext) ctx).close();
	}

}
