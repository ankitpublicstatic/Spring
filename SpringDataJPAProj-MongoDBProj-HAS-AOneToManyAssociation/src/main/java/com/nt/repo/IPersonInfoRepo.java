package com.nt.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.doc.PersonInformation;

public interface IPersonInfoRepo extends MongoRepository<PersonInformation, Integer> {

}
