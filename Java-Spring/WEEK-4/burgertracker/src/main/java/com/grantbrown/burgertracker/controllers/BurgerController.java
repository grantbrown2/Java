package com.grantbrown.burgertracker.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grantbrown.burgertracker.models.Burger;
import com.grantbrown.burgertracker.services.BurgerService;

import jakarta.validation.Valid;

@Controller
public class BurgerController {
	private final BurgerService burgerService;
	public BurgerController(BurgerService burgerService) {
		this.burgerService = burgerService;
	}
	
	@RequestMapping("/")
	public String allBurgers(Model viewmodel, @ModelAttribute("burger") Burger burger) {
		List<Burger> burgers = burgerService.allBurgers();
		viewmodel.addAttribute("burgers", burgers);
		return "index.jsp";
	}
	
	@PostMapping("/burger/new")
	public String newBurger(
			@Valid @ModelAttribute("burger") Burger burger,
			BindingResult result,
			Model viewmodel) {
		if (result.hasErrors()) {
			List<Burger> burgers = burgerService.allBurgers();
			viewmodel.addAttribute("burgers", burgers);
			return "index.jsp";
		}
		burgerService.createBurger(burger);
		return "redirect:/";
	}
	
	@GetMapping("/burger/edit/{id}")
	public String editBurger(Model viewmodel, @PathVariable("id") Long id) {
		viewmodel.addAttribute("burger", this.burgerService.findBurger(id));
		return "edit.jsp";
	}
	
	@PutMapping(value="/burger/update/{id}")
	public String update(
			@Valid
			@ModelAttribute("burger") Burger burger, 
			BindingResult result,
			Model viewmodel) {
		if (result.hasErrors()) {
			viewmodel.addAttribute("burger", burger);
			return "edit.jsp"; 
		} else {
			this.burgerService.updateBurger(burger);
			return "redirect:/";
		}
	}
	
	@GetMapping(value="/burger/delete/{id}")
	public String deleteBurger(@PathVariable("id") Long id) {
		burgerService.deleteBurger(id);
		return "redirect:/";
	}
}
