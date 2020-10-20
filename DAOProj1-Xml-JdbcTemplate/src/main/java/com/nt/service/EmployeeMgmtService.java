package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
@Service("empService")
public class EmployeeMgmtService implements IEmployeeMgmtService {
	@Autowired
	private IEmployeeDAO dao;
	
	public EmployeeMgmtService(IEmployeeDAO dao) {
		super();
		this.dao = dao;
	}

	public int fetchEmpsCount() {
		//use dao
		return dao.getEmpsCount();
	}

	public String getEmpsName(int eno) {
		// TODO Auto-generated method stub
		return dao.getEmpsName(eno);
	}

}
