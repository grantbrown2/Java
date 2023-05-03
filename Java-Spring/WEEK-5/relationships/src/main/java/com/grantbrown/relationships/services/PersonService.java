package com.grantbrown.relationships.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grantbrown.relationships.models.Person;
import com.grantbrown.relationships.repositories.PersonRepository;

@Service
public class PersonService {
	@Autowired
	PersonRepository personRepository;
	
	public List<Person> allPeople() {
		return personRepository.findAll();
	}
	
	public Person findPerson(Long id) {
		Optional<Person> optionalPerson = personRepository.findById(id);
		if(optionalPerson.isPresent()) {
			return optionalPerson.get();
		} else {
			return null;
		}
	}
}
