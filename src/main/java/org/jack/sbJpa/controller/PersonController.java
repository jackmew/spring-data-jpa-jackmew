/**
 * 
 */
package org.jack.sbJpa.controller;

import java.util.Date;
import java.util.List;

import org.jack.sbJpa.exception.PersonNotFoundException;
import org.jack.sbJpa.model.Person;
import org.jack.sbJpa.service.RepositoryPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author jackho
 *
 */
@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	RepositoryPersonService rps;
	
	@RequestMapping("/")
	public void createPerson() {
		Person person = new Person();
		person.setFirstName("Ho");
		person.setLastName("Jack");
		person.setCreationTime(new Date());
		person.setModificationTime(new Date());
		rps.create(person);
		
		System.out.println("create person");
	}

	@RequestMapping("/findAllPerson")
	public void findAllPerson() {
		List<Person> persons = rps.findAll();
		
		System.out.println("find persons");
	}
	
	@RequestMapping("/findOne")
	public void findOne(@RequestParam(value="id" , required=true)Long id) {
		Person person =  rps.findById(id);
		
		System.out.println("find one person");
	}
	
	@RequestMapping("/update")
	public void update() throws PersonNotFoundException {
		Person person = new Person();
		person.setFirstName("update");
		person.setLastName("update");
		person.setId(1L);
		
		rps.update(person);
		
		
		System.out.println("update person");
	}
	
	@RequestMapping("/delete")
	public void delete(@RequestParam(value="id" , required=true)Long id) throws PersonNotFoundException {
		rps.delete(id);
	}
	/*Query Creation from Method Name*/
	@RequestMapping("/findByFirstName")
	public void findByFirstName(@RequestParam(value="firstName" , required=true)String firstName) {
		
		List<Person> persons = rps.findByFirstName(firstName);
		System.out.println("find person findByFirstName ");
	}
	
	@RequestMapping("/findByLastName")
	public void findByLastName(@RequestParam(value="lastName" , required=true)String lastName) {
		
		List<Person> persons = rps.findByLastName(lastName);
		System.out.println("find person findByLastName ");
	}
	
	@RequestMapping("/findByLastNameStartingWith")
	public void findByLastNameStartingWith(@RequestParam(value="lastName" , required=true)String lastName) {
		
		List<Person> persons = rps.findByLastNameStartingWith(lastName);
		System.out.println("find person findByLastnameLike ");
	}
	
	
	/* @Query Annotation 
	@RequestMapping("/firstName")
	public void findByFirstName(@RequestParam(value="firstName" , required=true)String firstName) {
		
		List<Person> persons = rps.findByFirstName(firstName);
		System.out.println("find person findByFirstName ");
	}
	
	@RequestMapping("/lastName")
	public void findByLastName(@RequestParam(value="lastName" , required=true)String lastName) {
		
		List<Person> persons = rps.findByLastName(lastName);
		System.out.println("find person findByLastName ");
	}
	*/
}
