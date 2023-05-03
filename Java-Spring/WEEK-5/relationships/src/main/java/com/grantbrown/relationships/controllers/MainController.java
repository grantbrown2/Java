package com.grantbrown.relationships.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.grantbrown.relationships.models.Person;
import com.grantbrown.relationships.services.PersonService;

public class MainController {
	private final PersonService personService;
	public MainController(PersonService personService) {
		this.personService = personService;
	}
	
	
	@GetMapping("/persons/{person_id}")
	public String showPerson(@PathVariable Long person_id, Model model) {
	    
	    Person someAwesomePerson = personService.findPerson(person_id);
	    model.addAttribute("person", someAwesomePerson);
	    
	    return "showPerson.jsp";
	}


}
