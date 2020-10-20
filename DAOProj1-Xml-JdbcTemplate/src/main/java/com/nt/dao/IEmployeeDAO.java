package com.nt.dao;

import java.util.Map;

public interface IEmployeeDAO {
	public int getEmpsCount();
	public String getEmpsName(int eno);
	public Map<String,Object> getEmpDetailsByNo(int no);
}
