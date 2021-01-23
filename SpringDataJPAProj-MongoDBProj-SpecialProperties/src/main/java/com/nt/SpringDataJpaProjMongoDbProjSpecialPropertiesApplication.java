package com.nt;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.doc.DrivingLicense;
import com.nt.doc.Person;
import com.nt.repo.IPersonRepo;

@SpringBootApplication
public class SpringDataJpaProjMongoDbProjSpecialPropertiesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringDataJpaProjMongoDbProjSpecialPropertiesApplication.class, args);
		//get Reposi
		IPersonRepo repo = ctx.getBean(IPersonRepo.class);
		DrivingLicense license = new DrivingLicense(900001,"4-wheeler",LocalDate.of(2040, 10, 12));
		Person per = new Person(102,"ankit","hyd",license);
		per.setLicense(license);
		repo.save(per);
		System.out.println("object is saved");
		((ConfigurableApplicationContext) ctx).close();
	}

}
