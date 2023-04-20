package com.grantbrown.fruityloops.controllers;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grantbrown.fruityloops.models.Item;

@Controller
public class MainController {
	@RequestMapping("/")
	public String index(Model viewmodel) {
		
		ArrayList<Item> fruits = new ArrayList<Item>();
	     fruits.add(new Item("Kiwi", 1.5));
	     fruits.add(new Item("Mango", 2.0));
	     fruits.add(new Item("Goji Berries", 4.0));
	     fruits.add(new Item("Guava", .75));
		
	    viewmodel.addAttribute("fruits", fruits);
		
// remember to edit the src/main/resources/applications.properties and add spring.mvc.view.prefix=/WEB-INF/
		return "index.jsp";
	}
}