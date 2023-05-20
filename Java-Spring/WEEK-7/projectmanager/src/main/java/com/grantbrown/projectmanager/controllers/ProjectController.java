package com.grantbrown.projectmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.grantbrown.projectmanager.models.Project;
import com.grantbrown.projectmanager.services.ProjectService;
import com.grantbrown.projectmanager.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class ProjectController {
	@Autowired
	ProjectService projectServ;
	
	@Autowired
	UserService userServ;
	
	@GetMapping("/dashboard")
	public String dashboard(
			@ModelAttribute("project") Project project,
			Model viewmodel,
			HttpSession session) {
		String nameInSession = (String) session.getAttribute("userName");
		if (nameInSession == null) { // checking if there is any current users in session, if not redirect to login and register
			return "redirect:/";
		}
		viewmodel.addAttribute("nameInSession", nameInSession); // displays current users name on dash board
		
		Long userId = (Long) session.getAttribute("userId"); // grabs user's id from session
		List<Project> projectsNotAssociated = projectServ.getProjectsNotAssociated(userId); // shows list of projects that aren't associated with the user
		viewmodel.addAttribute("projectsNotAssociated", projectsNotAssociated); // allows for displaying the list
		List<Project> projectsAssociated = projectServ.getProjectsByAssociated(userId);
		viewmodel.addAttribute("projectsAssociated", projectsAssociated);
		return "dashboard.jsp";
	}
	
	@GetMapping("/projects/{id}")
	public String showProjet(@PathVariable("id") Long projectId,
			Model viewmodel,
			HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Project project = projectServ.findProject(projectId);
		viewmodel.addAttribute("project", project);
		return "show-project.jsp";
	}
	
	@GetMapping("/projects/new")
	public String projectAddForm(
			@ModelAttribute("project") Project project,
			Model viewmodel,
			HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		viewmodel.addAttribute("project", project);
		return "new-project.jsp";
	}
	
	@PostMapping("/projects/create")
	public String newProject(
			@Valid @ModelAttribute("project") Project project,
			BindingResult result,
			Model viewmodel,
			HttpSession session) {
		if (result.hasErrors()) {
			List<Project> projects = projectServ.allProjects();
			viewmodel.addAttribute(projects);
			return "new-project.jsp";
		}
		Long userId = (Long) session.getAttribute("userId");
		if (userId == null) {
			return "redirect:/";
		}
		
		Project createdProject = projectServ.createProject(project, userId);
		if (createdProject != null) {
			projectServ.addUserToProject(createdProject.getId(), userId);
		}
		return "redirect:/dashboard";
	}
	
	@GetMapping("/projects/join/{id}")
	public String joinUserToProject(
			@PathVariable("id") Long projectId,
			HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId != null) {
			projectServ.addUserToProject(projectId, userId);
		}
		return "redirect:/dashboard";
	}
	
	@GetMapping("/projects/leave/{id}")
	public String removeUserFromProject(
			@PathVariable("id") Long projectId,
			HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		if (userId != null) {
			projectServ.removeUserFromProject(projectId, userId);
		}
		return "redirect:/dashboard";
	}
	
	@GetMapping("/projects/delete/{id}")
	public String deleteProject(@PathVariable("id") Long projectId, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		projectServ.deleteProject(projectId);
		return "redirect:/dashboard";
	}
	
	@GetMapping("projects/edit/{id}")
	public String updateProjectForm(@PathVariable("id") Long projectId, Model viewmodel, HttpSession session) {
		if (session.getAttribute("userId") == null) {
			return "redirect:/";
		}
		Project project = projectServ.findProject(projectId);
		viewmodel.addAttribute("project", project);
		return "edit-project.jsp";
	}
	
	@PutMapping(value="/projects/edit/{id}")
	public String updateProject(@Valid @ModelAttribute("project") Project project,
			BindingResult result,
			Model viewmodel) {
		if (result.hasErrors()) {
			viewmodel.addAttribute("project", project);
			return "edit-project.jsp";
		} else {
			this.projectServ.editProject(project);
			return "redirect:/dashboard";
		}
	}
}
