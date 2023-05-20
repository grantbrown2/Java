package com.grantbrown.projectmanager.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grantbrown.projectmanager.models.Project;
import com.grantbrown.projectmanager.models.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Long>{
	List<Project> findAll();
	List<Project> findAllByUsersNotContaining(User user); // retrieves a list of projects that the user does not associate with
	List<Project> findAllByUsersContaining(User user);
}
