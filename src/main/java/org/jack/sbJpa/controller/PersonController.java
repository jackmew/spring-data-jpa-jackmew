/**
 * 
 */
package org.jack.sbJpa.controller;

import java.util.Date;
import java.util.List;

import org.jack.sbJpa.exception.PersonNotFoundException;
import org.jack.sbJpa.model.Image;
import org.jack.sbJpa.model.Person;
import org.jack.sbJpa.repository.ImageRepository;
import org.jack.sbJpa.service.RepositoryPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

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
		
		Person person1 = new Person();
		person1.setFirstName("Meow");
		person1.setLastName("Mew");
		person1.setCreationTime(new Date());
		person1.setModificationTime(new Date());
		rps.create(person1);
		
		Person person2 = new Person();
		person2.setFirstName("c");
		person2.setLastName("Chloe");
		person2.setCreationTime(new Date());
		person2.setModificationTime(new Date());
		rps.create(person2);
		
		Person person3 = new Person();
		person3.setFirstName("Ha");
		person3.setLastName("Cartoon");
		person3.setCreationTime(new Date());
		person3.setModificationTime(new Date());
		rps.create(person3);
		
		Person person4 = new Person();
		person4.setFirstName("Nice");
		person4.setLastName("Mac");
		person4.setCreationTime(new Date());
		person4.setModificationTime(new Date());
		rps.create(person4);
		
		System.out.println("create persons");
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
	
	@RequestMapping("/findByCreationTimeBefore")
	public void findByCreationTimeBefore(){
		List<Person> persons = rps.findByCreationTimeBefore(new Date());
		System.out.println("findByCreationTimeBefore");
	}
	
	@RequestMapping(value="/personImage", method=RequestMethod.POST)
    public @ResponseBody String handleFileUpload(@RequestParam("firstName") String firstName, 
    		@RequestParam("lastName") String lastName, 
    		@RequestParam("contentType") String contentType , 
            @RequestParam("file") MultipartFile file){
        if (!file.isEmpty()) {
            try {
//                byte[] bytes = file.getBytes();
//                BufferedOutputStream stream = 
//                        new BufferedOutputStream(new FileOutputStream(new File("src/main/img/"+ name + "-uploaded")));
//                stream.write(bytes);
//                stream.close();
            	byte[] bytes = file.getBytes();
            	String fileName = firstName+"-pic";
            	
            	Image image = new Image();
            	image.setBytes(bytes);
            	image.setContentType(contentType);
            	image.setFileName(fileName);
            	
            	Person person = new Person();
            	
            	person.setCreationTime(new Date());
            	person.setModificationTime(new Date());
            	person.setFirstName(firstName);
            	person.setLastName(lastName);
            	person.setImage(image);
            	
            	rps.create(person);
            	
            	//ir.save(image);
            	
            	
                return "You successfully save " + fileName + " into H2 !";
            } catch (Exception e) {
                return "You failed to save " + firstName + " => " + e.getMessage();
            }
        } else {
            return "You failed to save " + firstName + " because the file was empty.";
        }
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
