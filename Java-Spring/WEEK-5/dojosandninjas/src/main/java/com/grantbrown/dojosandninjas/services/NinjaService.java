package com.grantbrown.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grantbrown.dojosandninjas.models.Ninja;
import com.grantbrown.dojosandninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	NinjaRepository ninjaRepo;
	
	public List<Ninja> allNinjas() {
		return ninjaRepo.findAll();
	}
	
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepo.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
	}
	
	public List<Ninja> findByDojoId(Long dojoId) {
		return ninjaRepo.findByDojoId(dojoId);
	}
	
	public Ninja createNinja(Ninja ninja) {
		return ninjaRepo.save(ninja);
	}
}
