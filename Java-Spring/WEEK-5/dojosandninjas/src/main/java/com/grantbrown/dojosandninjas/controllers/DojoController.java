package com.grantbrown.dojosandninjas.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grantbrown.dojosandninjas.models.Dojo;
import com.grantbrown.dojosandninjas.models.Ninja;
import com.grantbrown.dojosandninjas.services.DojoService;
import com.grantbrown.dojosandninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class DojoController {
	private final DojoService dojoService;
	private final NinjaService ninjaService;
	public DojoController(DojoService dojoService, NinjaService ninjaservice) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaservice;
	}
	
	@RequestMapping("/")
	public String redirect() {
		return "redirect:/dojos/new";
	}
	
	@RequestMapping("/dojos/{id}")
	public String showDojo(@PathVariable("id") Long id, Model viewmodel) {
		List<Ninja> ninjas = ninjaService.findByDojoId(id);
		Dojo dojo = dojoService.findDojo(id);
		viewmodel.addAttribute("dojo", dojo);
		viewmodel.addAttribute("ninjas", ninjas);
		return "show-ninjas.jsp";
	}
	
	@RequestMapping("/dojos/new")
	public String createDojoForm(Model viewmodel, @ModelAttribute("dojo") Dojo dojo) {
		viewmodel.addAttribute("dojo", dojo);
		return "new-dojo.jsp";
	}
	
	@PostMapping("/dojos/create")
	public String createDojo(
			@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result,
			Model viewmodel) {
		if (result.hasErrors()) {
			List<Dojo> dojos = dojoService.allDojos();
			viewmodel.addAttribute("dojos", dojos);
			return "new-dojo.jsp";
		}
		dojoService.createDojo(dojo);
		return "redirect:/";
	}
}
