package com.nt.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;

import com.nt.service.EmployeeMgmtService;

public class JdbcTemplateDirectMethodsTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx=null;
		EmployeeMgmtService service=null;
		//create IOC Container
		ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//get Service class object
		service=ctx.getBean("empService",EmployeeMgmtService.class);
		//invoke the b.method
		try {
			System.out.println("emps count :: "+service.fetchEmpsCount());
		}catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		System.out.println("---------------------------");
		try {
			System.out.println("emps name"+service.getEmpsName(7934));
		}catch(DataAccessException dae) {
			dae.printStackTrace();
		}
		
		//close container
		((AbstractApplicationContext) ctx).close();
	}
}
