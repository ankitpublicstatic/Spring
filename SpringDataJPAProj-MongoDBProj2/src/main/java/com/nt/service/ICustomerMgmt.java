package com.nt.service;

import java.util.List;
import java.util.Optional;

import com.nt.dto.CustomerDTO;



public interface ICustomerMgmt {
	public String registerOrUpdateCustomer(CustomerDTO dto);
	public List<CustomerDTO> fetchAllCustomers();
	public Optional<CustomerDTO> fetchCustomerByCno(int cno);
	
	
}
