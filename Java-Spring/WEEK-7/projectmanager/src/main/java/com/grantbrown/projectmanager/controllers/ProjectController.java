package com.grantbrown.projectmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.grantbrown.projectmanager.services.ProjectService;
import com.grantbrown.projectmanager.services.UserService;

@Controller
public class ProjectController {
	@Autowired
	ProjectService projectServ;
	
	@Autowired
	UserService userServ;
	
	
}
