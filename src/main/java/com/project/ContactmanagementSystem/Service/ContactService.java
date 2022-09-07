package com.project.ContactmanagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.project.ContactmanagementSystem.Repository.ContactRepository;
import com.project.ContactmanagementSystem.bean.Person;
@Service
public class ContactService {
	@Autowired
private ContactRepository contactrepository;

public Optional<Person> retrieve(Integer id){
    return contactrepository.findById(id);
}

public Person save(Person person){
    return contactrepository.save(person);
}
public List<Person> getAll(){
	return contactrepository.findAll();
}
}
