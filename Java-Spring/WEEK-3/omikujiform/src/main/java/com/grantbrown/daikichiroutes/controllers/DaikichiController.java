package com.grantbrown.daikichiroutes.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class DaikichiController {
	@RequestMapping("/")
	public String redirect() {
		return "redirect:/omikuji";
	}
	@RequestMapping("/omikuji")
	public String home() {
		return "index.jsp";
	}
	@RequestMapping("/omikuji/show")
	public String show() {
		return "results.jsp";
	}
	@RequestMapping(value="/omikuji/show/process", method=RequestMethod.POST)
	public String processForm(
			@RequestParam(value="numberPick") int numberPick,
			@RequestParam(value="city") String city,
			@RequestParam(value="person") String person,
			@RequestParam(value="endeavor") String endeavor,
			@RequestParam(value="pet") String pet,
			@RequestParam(value="message") String message,
			HttpSession session) {
		session.setAttribute("numberPick", numberPick);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("endeavor", endeavor);
		session.setAttribute("pet", pet);
		session.setAttribute("message", message);
		return "redirect:/omikuji/show";
	}
	
	
	
	
	
	
	
	@RequestMapping("/today")
	public String todayMessage() {
		return "Today you will find luck in all your endeavors!";
	}
	@RequestMapping("/tomorrow")
	public String tomorrowMessage() {
		return "Tomorrow, an opportunity will arise, so be sure to be open to new ideas!";
	}
	@RequestMapping("/travel/{location}")
	public String travelMessage(
			@PathVariable("location") String location) {
		return "Congratulations! You will soon travel to " + location;
	}
	@RequestMapping("/lotto/{number}")
	public String lotto(@PathVariable("number") int number) {
		if (number %2 == 0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";
		} else {
			return "You have enjoyed the fruits of your labor but now is a greate time to spend time with family and friends";
		}
	}
}
