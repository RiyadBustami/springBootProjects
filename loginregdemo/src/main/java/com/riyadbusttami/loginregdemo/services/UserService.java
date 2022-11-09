package com.riyadbusttami.loginregdemo.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.riyadbusttami.loginregdemo.models.LoginUser;
import com.riyadbusttami.loginregdemo.models.User;
import com.riyadbusttami.loginregdemo.repositories.UserRepository;

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
}
