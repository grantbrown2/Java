package com.grantbrown.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grantbrown.dojosandninjas.models.Dojo;
import com.grantbrown.dojosandninjas.repositories.DojoRepository;

@Service
public class DojoService {
	@Autowired
	DojoRepository dojoRepo;
	
	public List<Dojo> allDojos() {
		return dojoRepo.findAll();
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dojoRepo.save(dojo);
	}
}
