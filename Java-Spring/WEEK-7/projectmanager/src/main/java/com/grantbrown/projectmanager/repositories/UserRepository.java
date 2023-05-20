package com.grantbrown.projectmanager.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.grantbrown.projectmanager.models.Project;
import com.grantbrown.projectmanager.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    
    Optional<User> findByEmail(String email);
    User findByUserName(String userName);
    List<User> findAllByProjectsNotContaining(Project project);
    List<User> findAllByProjectsContaining(Project project);
}