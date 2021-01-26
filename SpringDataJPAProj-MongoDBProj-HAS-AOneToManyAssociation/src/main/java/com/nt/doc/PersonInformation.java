package com.nt.doc;

import java.util.Map;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonInformation {
	@Id
	private Integer pid;
	private String pname;
	private String paddrs;
	private Set<VisaInfo> visa;
	private Map<String,BankAccount> accounts;
}
