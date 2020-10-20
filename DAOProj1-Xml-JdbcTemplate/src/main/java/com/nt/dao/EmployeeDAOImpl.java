package com.nt.dao;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class EmployeeDAOImpl implements IEmployeeDAO {
	private static final String GET_EMPS_COUNT="SELECT COUNT(*) FROM EMP";
	private static final String GET_EMPSNAME_BY_EMPNO="SELECT EANME FROM EMP WHERE EMPNO=?";
	private static final String GET_EMPDETAILS_BY_NO="SELECT EMPNO,ENAME, SAL,JOB,DEPTNO FROM EMP WHERE EMPNO=?";
	@Autowired
	private JdbcTemplate jt;
	
	
public EmployeeDAOImpl(JdbcTemplate jt) {
		super();
		this.jt = jt;
	}


public int getEmpsCount() {
		int count=0;
		count=jt.queryForObject(GET_EMPS_COUNT, Integer.class);
		return count;
	}


public String getEmpsName(int eno) {
	String name=null;
	name=jt.queryForObject(GET_EMPSNAME_BY_EMPNO, String.class,eno);
	return name;
}


public Map<String, Object> getEmpDetailsByNo(int no) {
	Map<String,Object> map=null;
	map=jt.queryForMap(GET_EMPDETAILS_BY_NO,no);
	return map;
}

}
