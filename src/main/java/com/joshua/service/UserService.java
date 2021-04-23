package com.joshua.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.joshua.model.User;
import com.joshua.model.UserDao;
import com.joshua.model.UserRole;

@Service
public class UserService implements UserDetailsService{
	
	@Autowired
	private UserDao userDao;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
	return userDao.findByEmail(email);
		
	}
	
	public void register(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRole(UserRole.USER);
		userDao.save(user);
		
	}
	
	public User getLoggediuser(Authentication auth) {
		Object principal = auth.getPrincipal();
		
		User user =null;
		
		if(principal instanceof UserDetails) {
			String name = ((UserDetails) principal).getUsername();
			user = (User) loadUserByUsername(name);
		}
		
		return user;
	}
	
	public void updateUser(User user,Authentication auth) {
	
		User logginuser =getLoggediuser(auth);
		logginuser.setUserName(user.getUserName());
		logginuser.setEmail(user.getEmail());
		logginuser.setPassword(passwordEncoder.encode(user.getPassword()));
		
		userDao.save(logginuser);
	}
	
	public List<User> getUsers(){
		return (List<User>) userDao.findAll();
	}
	
	public void edit(User user) {
		userDao.save(user);
	}
	
}
