package com.grantbrown.projectmanager.services;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grantbrown.projectmanager.models.Project;
import com.grantbrown.projectmanager.models.User;
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
	
	public Project findProject(Long id) {
		Optional<Project> existingProject = projectRepo.findById(id);
		if (existingProject.isPresent()) {
			return existingProject.get();
		} else {
			return null;
		}
	}
	
	public Project createProject(Project project, Long userId) {
		User user = userRepo.findById(userId).orElse(null);
		if (user == null) {
			return null;
		}
		project.getUsers().add(user);
		project.setTeamLead(user);
		return projectRepo.save(project);
	}
	
	public Project editProject(Project project) {
		Optional<Project> optionalProject = projectRepo.findById(project.getId());
		if (optionalProject.isPresent()) {
			Project existingProject = optionalProject.get();
			existingProject.setTitle(project.getTitle());
			existingProject.setDescription(project.getDescription());
			existingProject.setDueDate(project.getDueDate());
			return projectRepo.save(existingProject);
		} else {
			return null;
		}
	}
	
	public void deleteProject(Long id) {
		projectRepo.deleteById(id);
	}
	
	public List<Project> getProjectsByAssociated(Long userId) {
		User user = userRepo.findById(userId).orElse(null);
		if (user == null) {
			return Collections.emptyList();
		}
		return projectRepo.findAllByUsersContaining(user);
	}
	
	public List<Project> getProjectsNotAssociated(Long userId) {
		User user = userRepo.findById(userId).orElse(null);
		if (user == null) {
			return Collections.emptyList();
		}
		return projectRepo.findAllByUsersNotContaining(user);
	}
	
	public void addUserToProject(Long projectId, Long userId) {
		Optional<Project> optionalProject = projectRepo.findById(projectId); // gets the selected project by id
		User user = userRepo.findById(userId).orElse(null); // gets the selected user by id
		if (optionalProject.isPresent() && user != null) { // checking if the user and project exist
			Project project = optionalProject.get(); // if the project exists, then it extracts the project from the optional
			if (!project.getUsers().contains(user)) { // checking if the user is already associated with the project 
				project.getUsers().add(user); // adds the user to the projects list of users
				projectRepo.save(project); // saves project
			}
		}
	}
	
	public void removeUserFromProject(Long projectId, Long userId) {
		Optional<Project> optionalProject = projectRepo.findById(projectId);
		User user = userRepo.findById(userId).orElse(null);
		if (optionalProject.isPresent() && user != null) {
			Project project = optionalProject.get();
			
			if (project.getTeamLead().getId().equals(userId)) {
				return;
			}
			
			project.getUsers().remove(user);
			projectRepo.save(project);
		}
	}
	
	public void removeProject(Long projectId) {
		projectRepo.deleteById(projectId);
	}
}






