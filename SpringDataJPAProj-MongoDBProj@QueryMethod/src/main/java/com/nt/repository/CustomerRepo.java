package com.nt.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nt.document.Customer;

public interface CustomerRepo extends MongoRepository<Customer, Integer> {
	
	//@Query(fields= "{cname:1,billAmt:1}",value="{cadd:?0}")
	@Query(fields="{cno:0,cname:1,billAmt:1}",value="{cadd:?0})")
	public List<Object[]> getData(String cadd);
	
	//@Query(fields="{}",value="{cadd:?0}")
	@Query(value="{cadd:?0}")
	public List<Object[]> getData2(String cadd);
	
	@Query(value="{cadd:?0,cname:?1}")
	public List<Customer> getAllData(String addrs,String cname);
	
	@Query(value="{cadd:{$regex:?0}}")
	public List<Customer> getAllData1(String addrs);
	
	
	@Query(value="{cadd:{$regex:?0}}")
	public List<Customer> getAllData2(int startValue, int endValue);
	
	
	@Query(value="{cno:{$gt:?0},cno:{$lt:?1}}")
	public List<Customer> getDataByCnoRange(int startValue, int endValue);
	
	@Query(value="{ $or: [{cname:{$regex:?0},{cadd:?1}]}")
	public List<Customer> getDataByOrCondition(String cnameintChars,String cadd);
}
