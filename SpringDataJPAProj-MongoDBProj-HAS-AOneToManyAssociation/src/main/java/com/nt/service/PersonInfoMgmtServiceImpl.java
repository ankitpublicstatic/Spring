package com.nt.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.doc.BankAccount;
import com.nt.doc.PersonInformation;
import com.nt.doc.VisaInfo;
import com.nt.dto.BankAccountDTO;
import com.nt.dto.PersonInfoDTO;
import com.nt.dto.VisaInfoDTO;
import com.nt.repo.IPersonInfoRepo;

@Service("personService")
public class PersonInfoMgmtServiceImpl implements IPersonInfoMgmtService {
	@Autowired
	private IPersonInfoRepo repo;
	@Override
	public String saveData(PersonInfoDTO personInfoDTO) {
		
		// Convert dto object into Doc object
		PersonInformation personInformation = new PersonInformation();
		BeanUtils.copyProperties(personInfoDTO, personInformation);
		
		//convert mapBankAccountDTO to mapBAnkAccount doc object
		Map<String, BankAccountDTO> accountDTO = personInfoDTO.getAccount();
		Map<String, BankAccount> accountDOC = new HashMap();
		
		accountDTO.forEach((key,bankdto)->{
			BankAccount acDoc = new BankAccount();
			BeanUtils.copyProperties(bankdto, acDoc);
			accountDOC.put(key, acDoc);
		});
		/*
		 * // convert SetVisaDTOs to setVisa Docs Set<VisaInfoDTO> SetvisaDTO =
		 * personInfoDTO.getVisas(); Set<VisaInfo> SetvisaDoc = new HashSet<VisaInfo>();
		 * SetvisaDTO.forEach(visaDTO-> { VisaInfo vsdoc=new VisaInfo();
		 * BeanUtils.copyProperties(visaDTO, vsdoc); });
		 */
		Set<VisaInfoDTO>  SetvisaDTO=personInfoDTO.getVisas();
		Set<VisaInfo>  SetvisaDoc=new HashSet<VisaInfo>();
		SetvisaDTO.forEach(visadto->{
			VisaInfo  vsdoc=new VisaInfo();
			BeanUtils.copyProperties(visadto, vsdoc);
			SetvisaDoc.add(vsdoc);
		});
		
		personInformation.setAccounts(accountDOC);
		personInformation.setVisa(SetvisaDoc);
		//save obj
		return "Document is saved with "+repo.save(personInformation);
	}

}
