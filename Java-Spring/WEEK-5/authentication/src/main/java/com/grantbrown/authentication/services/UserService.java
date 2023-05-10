package com.grantbrown.authentication.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.grantbrown.authentication.models.LoginUser;
import com.grantbrown.authentication.models.User;
import com.grantbrown.authentication.repositories.UserRepository;
    
@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepo;
    
    // TO-DO: Write register and login methods!
    // This method will be called from the controller
    // whenever a user submits a registration form.
    
    public User register(User newUser, BindingResult result) {
    
    	
        // Reject if email is taken (present in database)
        Optional<User> existingEmail = userRepo.findByEmail(newUser.getEmail());
        if (existingEmail.isPresent()) {
        	result.rejectValue("email", "Matches", "Email already in use!");
        }
        // Reject if password doesn't match confirmation
        // Return null if result has errors
        if (!newUser.getPassword().equals(newUser.getConfirm())) {
        	result.rejectValue("confirm", "Matches", "Passwords must match!");
        }
        
     // TO-DO - Reject values or register if no errors:
        if (result.hasErrors()) {
        	return null;
        }
        // Hash and set password, save user to database
        String hashed = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
        newUser.setPassword(hashed);
        return userRepo.save(newUser);
        
    }

    // This method will be called from the controller
    // whenever a user submits a login form.
    public User login(LoginUser newLoginObject, BindingResult result) {
    	Optional<User> existingUser = userRepo.findByEmail(newLoginObject.getLoginEmail());
        // Reject if NOT present
         if(!existingUser.isPresent()) {
           	 result.rejectValue("loginEmail", "Matches", "Incorrect login");
           	 return null;
            }
         User user = existingUser.get();
        // Reject if BCrypt password match fails
         if(!BCrypt.checkpw(newLoginObject.getLoginPassword(), user.getPassword())) {
        	 result.rejectValue("loginPassword", "Matches", "Incorrect login");
         }
         
        // Return null if result has errors
         if(result.hasErrors()) {
        	 return null;
         }
        // Otherwise, return the user object
         return user;
    }

}
