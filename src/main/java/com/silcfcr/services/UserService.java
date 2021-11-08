package com.silcfcr.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.silcfcr.models.User;
import com.silcfcr.repositories.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    // register user and hash their password
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }
    
    
    // find user by email
    public User findByEmail(String email) {
    	System.out.println("I enter here");
        return userRepository.findByEmail(email);
    }
    
 // find user by email
    public List<User> findUsersByEmail(String email) {
    	System.out.println("I enter here");
        return userRepository.findUsersByEmail(email);
    }
    
    // find user by id
    public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
    }
    
    // authenticate user
    public boolean authenticateUser(String email, String password) {
        // first find the user by email
        User user = userRepository.findByEmail(email);
        // if we can't find it by email, return false
        if(user == null) {
        	System.out.println("User is null");
            return false;
        } else {
            // if the passwords match, return true, else, return false
            if(BCrypt.checkpw(password, user.getPassword())) {
            	System.out.println("Pass in correct");
                return true;
                
            } else {
            	System.out.println("Pass is wrong");
                return false;
                
            }
        }
    }
}
 