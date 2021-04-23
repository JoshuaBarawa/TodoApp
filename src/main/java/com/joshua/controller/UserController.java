package com.joshua.controller;
import java.util.List;
import java.util.Random;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.joshua.model.User;
import com.joshua.service.UserService;


@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private PasswordEncoder passEncoder;
	
	@RequestMapping(value="/login")
	String login(ModelAndView modelAndView) {
		
		return "app.login";
	}
	
	
	@RequestMapping(value="/logout")
	String logout(ModelAndView modelAndView) {
		
		return "app.logout";
	}
	
	@RequestMapping(value="/user/signup", method=RequestMethod.GET)
	ModelAndView signupPage(ModelAndView modelAndView) {
		
		modelAndView.setViewName("app.signup");
		
		modelAndView.getModel().put("user", new User());
		
		return modelAndView;
	}
	
	@RequestMapping(value="/user/signup", method=RequestMethod.POST)
	ModelAndView signup(ModelAndView modelAndView, @Valid @ModelAttribute("user") User user, BindingResult result) {
		boolean exists = userService.loadUserByUsername(user.getEmail()) != null;
		if(exists) {
			modelAndView.getModel().put("error", "Email Already Exists!!!");
			modelAndView.setViewName("app.signup");
		}
		
		else {
			userService.register(user);
			modelAndView.setViewName("app.login");
		}
		
		return modelAndView;
	}
	
	@RequestMapping(value="/profile", method=RequestMethod.GET)
	ModelAndView profile(ModelAndView modelAndView, @AuthenticationPrincipal Authentication auth) {
		User user = userService.getLoggediuser(auth);
		
		modelAndView.setViewName("app.profile");
		modelAndView.getModel().put("user", user);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/updateuser", method=RequestMethod.POST)
	ModelAndView updateUser(ModelAndView modelAndView,@Valid @ModelAttribute("user") User user, BindingResult result,
			@AuthenticationPrincipal Authentication auth) {
		
		userService.updateUser(user, auth);
		modelAndView.setViewName("app.profile");
		modelAndView.getModel().put("msg", "User Details Updated Successful");

		return modelAndView;
	}
	
	@RequestMapping(value="/users", method=RequestMethod.GET)
	ModelAndView getUsers(ModelAndView modelAndView) {
		List<User> users = userService.getUsers();

		modelAndView.setViewName("app.users");
		modelAndView.getModel().put("users", users);
		
		return modelAndView;
	}
	
	
	
	@RequestMapping(value="/reset", method=RequestMethod.GET)
	ModelAndView resetPassword(ModelAndView modelAndView) {
		modelAndView.setViewName("app.reset");
		
		return modelAndView;
	}
	
	@RequestMapping(value="/reset", method=RequestMethod.POST)
	ModelAndView resetPassword(ModelAndView modelAndView ,@RequestParam("email")String email) {
		
		User user = (User) userService.loadUserByUsername(email);
		
		if(user == null) {
			modelAndView.setViewName("app.reset");
			modelAndView.getModel().put("error", "Email does not exits!!");
		}
		
		else {
		Random random = new Random();
		int code = random.nextInt(9999);
		user.setPassword(passEncoder.encode(String.valueOf(code)));
		
		userService.edit(user);
		
		modelAndView.setViewName("app.reset");
		modelAndView.getModel().put("msg", "Use this code < " + code + "> to login and reset your password");
		}
		return modelAndView;
	}
	
	
}
