package com.project.ContactmanagementSystem.Controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.project.ContactmanagementSystem.Exception.UserNotFoundError;
import com.project.ContactmanagementSystem.Service.ContactService;

import com.project.ContactmanagementSystem.bean.Person;

@RestController
@RequestMapping("/contact")
public class ContactController {
	@Autowired
	private ContactService contactservice;
@PostMapping("/save")
public ResponseEntity<Person> save(@RequestBody Person person){
	Person save = contactservice.save(person);
return new ResponseEntity<Person>(save, HttpStatus.CREATED);
}
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class IdNotFound extends RuntimeException{
	public IdNotFound(String message) {
		super(message);
	}
}
@ResponseStatus(value = HttpStatus.OK)
@GetMapping("/retrieve/{id}")
public Optional<Person> retrieve(@PathVariable Integer id){
	Optional<Person> retrieve = Optional.of(contactservice.retrieve(id)
			.orElseThrow(() -> new IdNotFound("Contact with id " + id + " not found.")));
	return retrieve;
}
@GetMapping("/show")
public List<Person> getAll(){
	return contactservice.getAll();
}

}
