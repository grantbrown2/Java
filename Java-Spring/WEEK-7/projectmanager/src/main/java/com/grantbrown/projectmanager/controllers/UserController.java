package com.grantbrown.projectmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.grantbrown.projectmanager.models.LoginUser;
import com.grantbrown.projectmanager.models.User;
import com.grantbrown.projectmanager.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class UserController {
	@Autowired
	private UserService userServ;
	
	@GetMapping("/")
	public String index(Model viewmodel, HttpSession session) {
		if (session.getAttribute("userName") != null) {
			return "redirect:/dashboard";
		}
		viewmodel.addAttribute("newUser", new User());
		viewmodel.addAttribute("newLogin", new LoginUser());
		return "loginandregistration.jsp";
	}
	
	@PostMapping("/register")
	public String registerPost(
			@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result,
			Model viewmodel,
			HttpSession session) {
		User registeredUser = userServ.register(newUser, result);
		if (result.hasErrors()) {
			viewmodel.addAttribute("newLogin", new LoginUser());
			return "loginandregistration.jsp";
		}
		session.setAttribute("userId", registeredUser.getId());
		session.setAttribute("userName", registeredUser.getUserName());
		return "redirect:/dashboard";
	}
	
	@PostMapping("/login")
	public String login(
			@Valid @ModelAttribute("newLogin")LoginUser newLogin,
			BindingResult result,
			Model viewmodel,
			HttpSession session) {
		User user = userServ.login(newLogin, result);
		if (result.hasErrors()) {
			viewmodel.addAttribute("newUser", new User());
			return "loginandregistration.jsp";
		}
		session.setAttribute("userId", user.getId());
		session.setAttribute("userName", user.getUserName());
		return "redirect:/dashboard";
	}
	
	@GetMapping("/logout")
	 public String logout(HttpSession session) {
		 session.invalidate();
		 return "redirect:/";
	 }
}
