package com.grantbrown.dojosandninjas.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grantbrown.dojosandninjas.models.Dojo;
import com.grantbrown.dojosandninjas.models.Ninja;
import com.grantbrown.dojosandninjas.services.DojoService;
import com.grantbrown.dojosandninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class NinjaController {
	private final NinjaService ninjaService;
	private final DojoService dojoService;
	public NinjaController(NinjaService ninjaService, DojoService dojoService) {
		this.dojoService = dojoService;
		this.ninjaService = ninjaService;
	}
	
	@RequestMapping("/ninjas/new")
	public String createNinjaForm(Model viewmodel, 
			@ModelAttribute("ninja") Ninja ninja) {
		List<Dojo> dojos = dojoService.allDojos();
		viewmodel.addAttribute("dojos", dojos);
		viewmodel.addAttribute("ninja", ninja);
		return "new-ninja.jsp";
	}
	
	@PostMapping("/ninjas/create")
	public String createNinja(
			@Valid @ModelAttribute("ninja") Ninja ninja,
			BindingResult result,
			Model viewmodel) {
		if (result.hasErrors()) {
			List<Ninja> ninjas = ninjaService.allNinjas();
			viewmodel.addAttribute("ninjas", ninjas);
			return "new-dojo.jsp";
		}
		ninjaService.createNinja(ninja);
		return "redirect:/";
	}
}
