package com.nt.repo;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.doc.Student;

public interface IStudentRepo extends MongoRepository<Student, String> {
	
}
