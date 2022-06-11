package org.crazyit.cloud.dao;

import java.util.List;

import org.crazyit.cloud.entity.Person;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface PersonDao extends MongoRepository<Person, String>, PersonDaoCustom {

	public List<Person> name(String name);
	
	@Query(value = "{'name' : ?0, 'age' : ?1}", fields = "{'name' : 1}")
	public List<Person> findByNameAndAge(String name, Integer age);
}