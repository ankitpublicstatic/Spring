package com.nt;

import java.time.LocalDate;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.nt.dto.BankAccountDTO;
import com.nt.dto.PersonInfoDTO;
import com.nt.dto.VisaInfoDTO;
import com.nt.service.IPersonInfoMgmtService;

@SpringBootApplication
public class SpringDataJpaProjMongoDbProjHasAOneToManyAssociationApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(SpringDataJpaProjMongoDbProjHasAOneToManyAssociationApplication.class, args);
		//get Service class obj
		IPersonInfoMgmtService iPersonInfoMgmtService = ctx.getBean("personService",IPersonInfoMgmtService.class);
		VisaInfoDTO  visaInfoDTO4=new VisaInfoDTO(878,"BRAJIL",LocalDate.of(2030, 10, 10));
		VisaInfoDTO  visaInfoDTO5=new VisaInfoDTO(654,"JAPAN",LocalDate.of(2031, 10, 10));
		
		VisaInfoDTO visaInfoDTO= new VisaInfoDTO(879,"USA",LocalDate.of(2030, 10, 10));
		VisaInfoDTO visaInfoDTO2= new VisaInfoDTO(545,"CANADA",LocalDate.of(2045, 11, 05));
		VisaInfoDTO visaInfoDTO3= new VisaInfoDTO(655,"FRANCE",LocalDate.of(2056, 11, 15));
		
		BankAccountDTO bankAccountDTO = new BankAccountDTO(928393l,"current",98797.83f);
		BankAccountDTO bankAccountDTO2 = new BankAccountDTO(6546498l,"saving",658798.83f);
		BankAccountDTO bankAccountDTO3 = new BankAccountDTO(4654654l,"current",4545654.83f);
		BankAccountDTO bankAccountDTO4 = new BankAccountDTO(8794564l,"current",654987465.83f);
		
		PersonInfoDTO personInfoDTO = new PersonInfoDTO( new Random().nextInt(5000),"ABHISHEK","hyderbad",
				Set.of(visaInfoDTO,visaInfoDTO2,visaInfoDTO3,visaInfoDTO4,visaInfoDTO5),
				Map.of("account1",bankAccountDTO,"account2",bankAccountDTO2,"account3",bankAccountDTO3,"account4",bankAccountDTO4)
				);
		System.out.println(iPersonInfoMgmtService.saveData(personInfoDTO));
		
		System.out.println("Application Clossed");
		((ConfigurableApplicationContext) ctx).close();
	}

}
