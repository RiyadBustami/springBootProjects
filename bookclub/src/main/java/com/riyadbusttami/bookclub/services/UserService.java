package com.riyadbusttami.bookclub.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.riyadbusttami.bookclub.models.LoginUser;
import com.riyadbusttami.bookclub.models.User;
import com.riyadbusttami.bookclub.repositories.UserRepository;

@Service
public class UserService {
	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	public User register(User newUser, BindingResult result) {
		if(userRepository.findByEmail(newUser.getEmail()).isPresent()) {
			result.rejectValue( "email", "Unique", "This email is already in use!");
		}
		if(!newUser.getPassword().equals(newUser.getConfirm())) {
			result.rejectValue("confirm", "Matches", "The confirm pwd must match pwd!");
		}
		if(result.hasErrors()) {
			return null;
		}
		else {
			String hashedPwd = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
			newUser.setPassword(hashedPwd);
			return userRepository.save(newUser);
		}
	}
	
	public User login(LoginUser newLogin,BindingResult result) {
		if(result.hasErrors()) {
			return null;
		}
		Optional<User> potentialUser = userRepository.findByEmail(newLogin.getEmail());
		if(!potentialUser.isPresent()) {
			result.rejectValue("email", "Unique", "Email or Pwd wrong");
			return null;
		}
		User user = potentialUser.get();
		if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
			result.rejectValue("password", "Matches", "Email or Pwd wrong");
		}
		if(result.hasErrors()) {
			return null;
		}
		else {
			return user;
		}
	}
	
	public User get(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		else {
			return null;
		}
	}
	
	public User get(User user) {
		Optional<User> optionalUser = userRepository.findById(user.getId());
		if(optionalUser.isPresent()) {
			return optionalUser.get();
		}
		else {
			return null;
		}
	}
}
