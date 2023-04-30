package com.grantbrown.burgertracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.grantbrown.burgertracker.models.Burger;
import com.grantbrown.burgertracker.repositories.BurgerRepository;

@Service
public class BurgerService {
	private final BurgerRepository burgerRepository;
	public BurgerService(BurgerRepository burgerRepository) {
		this.burgerRepository = burgerRepository;
	}
	
	public List<Burger> allBurgers() {
		return burgerRepository.findAll();
	}
	
	public Burger findBurger(Long id) {
		Optional<Burger> optionalBurger = burgerRepository.findById(id);
		if(optionalBurger.isPresent()) {
			return optionalBurger.get();
		} else {
			return null;
		}
	}
	
	public Burger createBurger(Burger burger) {
		return burgerRepository.save(burger);
	}
	
	public Burger updateBurger(Burger burger) {
		Optional<Burger> optionalBurger = burgerRepository.findById(burger.getId());
		if(optionalBurger.isPresent()) {
			Burger existingBurger = optionalBurger.get();
			existingBurger.setBurgerName(burger.getBurgerName());
			existingBurger.setRestaurantName(burger.getRestaurantName());
			existingBurger.setRating(burger.getRating());
			existingBurger.setNotes(burger.getNotes());
			return burgerRepository.save(existingBurger);
		} else {
			return null;
		}
	}
	
	public void deleteBurger(Long id) {
		burgerRepository.deleteById(id);
	}
}
