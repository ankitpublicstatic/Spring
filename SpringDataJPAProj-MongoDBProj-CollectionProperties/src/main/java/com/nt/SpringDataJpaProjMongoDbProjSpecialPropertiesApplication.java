package com.nt;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.doc.Student;
import com.nt.generator.IdGenerator;
import com.nt.repo.IStudentRepo;

@SpringBootApplication
public class SpringDataJpaProjMongoDbProjSpecialPropertiesApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringDataJpaProjMongoDbProjSpecialPropertiesApplication.class, args);
		//get Repository Object
		IStudentRepo repo = ctx.getBean(IStudentRepo.class);
		//save document
		Properties batchesinfo = new Properties();
		batchesinfo.put("Cjava","11am");
		batchesinfo.put("advjava", "4pm");
		Student student = new Student(IdGenerator.genrateId(),
				new Random().nextInt(10000),
				"ankit",
				new Integer[] {98,98,89},
				List.of("C","java","spring"),
				Set.of(9999L,389383L,9833393L),
				Map.of("rajesh",98,"ramesh",39,"suresh",98),
				batchesinfo);
				
		
		repo.save(student);
		System.out.println("object is saved");
		((ConfigurableApplicationContext) ctx).close();
	}

}
