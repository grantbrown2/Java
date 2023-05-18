package com.grantbrown.projectmanager.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grantbrown.projectmanager.models.Project;
import com.grantbrown.projectmanager.repositories.ProjectRepository;
import com.grantbrown.projectmanager.repositories.UserRepository;

@Service
public class ProjectService {
	@Autowired
	ProjectRepository projectRepo;
	
	@Autowired
	UserRepository userRepo;
	
	public List<Project> allProjects() {
		return projectRepo.findAll();
	}
	
	public Project findBook(Long id) {
		Optional<Project> existingProject = projectRepo.findById(id);
		if (existingProject.isPresent()) {
			return existingProject.get();
		} else {
			return null;
		}
	}
	
	public Project createProject(Project project) {
		return projectRepo.save(project);
	}
	
	public Project editProject(Project project) {
		Optional<Project> optionalProject = projectRepo.findById(project.getId());
		if (optionalProject.isPresent()) {
			Project existingProject = optionalProject.get();
			existingProject.setTitle(project.getTitle());
			existingProject.setDescrtiption(project.getDescrtiption());
			existingProject.setDueDate(project.getDueDate());
			return projectRepo.save(existingProject);
		} else {
			return null;
		}
	}
	
	public void deleteProject(Long id) {
		projectRepo.deleteById(id);
	}
}






