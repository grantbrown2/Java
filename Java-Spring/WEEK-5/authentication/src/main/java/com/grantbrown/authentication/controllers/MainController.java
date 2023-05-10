package com.grantbrown.authentication.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.grantbrown.authentication.models.LoginUser;
import com.grantbrown.authentication.models.User;
import com.grantbrown.authentication.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;


@Controller
public class MainController {
 
 @Autowired
 private UserService userServ;
 
 @GetMapping("/")
 public String index(Model model, HttpSession session) {

	 session.invalidate();
     // Bind empty User and LoginUser objects to the JSP
     // to capture the form input
     model.addAttribute("newUser", new User());
     model.addAttribute("newLogin", new LoginUser());
     return "index.jsp";
 }
 
 @GetMapping("/logout")
 public String logout(HttpSession session) {
	 session.invalidate();
	 return "redirect:/";
 }
 
 @PostMapping("/register")
 public String register(@Valid @ModelAttribute("newUser") User newUser, 
         BindingResult result, Model model, HttpSession session) {
     
     // TO-DO Later -- call a register method in the service 
	 User registeredUser = userServ.register(newUser, result);
     // to do some extra validations and create a new user!
     
     if(result.hasErrors()) {
         // Be sure to send in the empty LoginUser before 
         // re-rendering the page.
         model.addAttribute("newLogin", new LoginUser());
         return "index.jsp";
     }
     
     // No errors! 
     // TO-DO Later: Store their ID from the DB in session, 
     // in other words, log them in.
     session.setAttribute("userId", registeredUser.getId());
     session.setAttribute("userName", registeredUser.getUserName());
 
     return "redirect:/home";
 }
 
 @RequestMapping("/home")
 public String home(Model viewmodel, HttpSession session) {
	 String userName = (String) session.getAttribute("userName");
	 if (userName == null) {
		 return "redirect:/";
	 }
	 viewmodel.addAttribute("userName", userName);
	 return "home.jsp";
 }
 
 @PostMapping("/login")
 public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
         BindingResult result, Model model, HttpSession session) {
     
     // Add once service is implemented:
     User user = userServ.login(newLogin, result);
 
     if(result.hasErrors()) {
         model.addAttribute("newUser", new User());
         return "index.jsp";
     }
 
     // No errors! 
     // TO-DO Later: Store their ID from the DB in session, 
     // in other words, log them in.
     session.setAttribute("userId", user.getId());
     session.setAttribute("userName", user.getUserName());
 
     return "redirect:/home";
 }
 
}
