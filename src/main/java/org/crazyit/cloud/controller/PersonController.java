package org.crazyit.cloud.controller;

import java.util.List;

import org.crazyit.cloud.entity.Person;
import org.crazyit.cloud.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;

	@RequestMapping(value = "/persons", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> persons() {
		return personService.findAll();
	}
	
	@RequestMapping(value = "/mq", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> mq() {
		return personService.myQuery();
	}
	
	@RequestMapping(value = "/na/{name}/{age}", method = RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> na(@PathVariable String name, @PathVariable Integer age) {
		return personService.findByNameAndAge(name, age);
	}
}
