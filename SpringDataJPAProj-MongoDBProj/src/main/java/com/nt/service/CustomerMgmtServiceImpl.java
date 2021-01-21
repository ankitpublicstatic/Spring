package com.nt.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.Customer;
import com.nt.dto.CustomerDTO;
import com.nt.repository.CustomerRepo;

@Service("custService")
public class CustomerMgmtServiceImpl implements ICustomerMgmt {
	@Autowired
	private CustomerRepo custRepo;
	
	@Override
	public String registerCustomer(CustomerDTO dto) {
		Customer doc = new Customer();
		BeanUtils.copyProperties(dto, doc);
		//save documetn
		//doc=custRepo.insert(doc);
		
		doc=custRepo.save(doc);
		System.out.println(doc);
		return "Document is saved having cno :"+doc.getCno()+"  Name :"+doc.getCname();
	}

	@Override
	public String updateCustomer(CustomerDTO dto) {
		// TODO Auto-generated method stub
		
		Customer doc = new Customer();
		BeanUtils.copyProperties(dto, doc);
		//save documetn
		//doc=custRepo.insert(doc);
		
		doc=custRepo.save(doc);
		System.out.println(doc);
		return "Documents updated having cno :"+doc.getCno()+"  Name :"+doc.getCname();
	
	}

}
