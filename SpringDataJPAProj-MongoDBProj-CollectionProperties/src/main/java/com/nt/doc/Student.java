package com.nt.doc;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document
@Data
@AllArgsConstructor

public class Student {
	
	@Id
	private String pid;
	private int sno;
	private String sname;
	private Integer marks[];
	private List<String> subjects;
	private Set<Long> phoneNumbers;
	private Map<String,Integer> ageDetails;
	private Properties bachesInfo;
}
