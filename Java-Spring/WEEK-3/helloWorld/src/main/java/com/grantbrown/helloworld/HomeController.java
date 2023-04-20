package com.grantbrown.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	public String test(Model viewmodel) {
		viewmodel.addAttribute("fruit", "bannana");
		String[] test = {"test1", "test2", "test3"};
		viewmodel.addAttribute("test", test);
		return "demo.jsp";
	}
}
