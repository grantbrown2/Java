package com.grantbrown.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
	
	@RequestMapping("/")
	public String index(Model viewmodel, HttpSession session) {
		
		Integer count = (Integer) session.getAttribute("count");
		if(count == null) {
			count = 0;
			session.setAttribute("count", count);
		} else {
			count++;
			session.setAttribute("count", count);
			viewmodel.addAttribute("count", count);
		}
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter(Model viewmodel, HttpSession session) {
		Integer count = (Integer) session.getAttribute("count");
		if (count == null) {
			count = 0;
		}
		viewmodel.addAttribute("count", count);
		return "counter.jsp";
	}
	
	@RequestMapping("/clear")
	public String clearSession(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
