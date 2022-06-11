package org.crazyit.cloud.service;

import java.util.List;

import org.crazyit.cloud.dao.PersonDao;
import org.crazyit.cloud.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PersonService {
	
	@Autowired
	private PersonDao personDao;

	public List<Person> findAll() {
		return personDao.findAll();
	}
	
	public List<Person> myQuery() {
		return personDao.myQuery();
	}
	
	public List<Person> findByNameAndAge(String name, Integer age) {
		return personDao.findByNameAndAge(name, age);
	}
}
