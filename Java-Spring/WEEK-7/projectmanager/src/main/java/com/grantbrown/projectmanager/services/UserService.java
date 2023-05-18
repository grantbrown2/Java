package com.grantbrown.projectmanager.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.grantbrown.projectmanager.models.LoginUser;
import com.grantbrown.projectmanager.models.User;
import com.grantbrown.projectmanager.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;
	
	public User register(User newUser, BindingResult result) {
		Optional<User> existingEmail = userRepo.findByEmail(newUser.getEmail());
		if (existingEmail.isPresent()) {
			result.rejectValue("email", "EmailInUse", "Email already in use!");
		}
		if (!newUser.getPassword().equals(newUser.getConfirmPassword())) {
			result.rejectValue("confirmPassword", "PasswordMismatch", "Passwords must match!");
		}
		if (result.hasErrors()) {
			return null;
		}
		String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
		newUser.setPassword(hashed);
		return userRepo.save(newUser);
	}
	
	public User login(LoginUser newLoginUser, BindingResult result) {
		Optional<User> existingUser = userRepo.findByEmail(newLoginUser.getLoginEmail());
		if (!existingUser.isPresent()) {
			result.rejectValue("loginEmail", "IncorrectLogin", "Incorrect Login!");
			return null;
		}
		User user = existingUser.get();
		if (!BCrypt.checkpw(newLoginUser.getLoginPassword(), user.getPassword())) {
			result.rejectValue("loginPassword", "IncorrectLogin", "Incorrect Login!");
		}
		if (result.hasErrors()) {
			return null;
		}
		return user;
	}
	
	public User findByUserName(String userName) {
		return userRepo.findByUserName(userName);
	}
}
