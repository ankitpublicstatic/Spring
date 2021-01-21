package com.nt.service;

import com.nt.dto.CustomerDTO;

public interface ICustomerMgmt {
	public String registerCustomer(CustomerDTO dto);
	public String updateCustomer(CustomerDTO dto);
}
