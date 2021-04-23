package com.joshua.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.joshua.model.Todo;
import com.joshua.model.User;
import com.joshua.service.TodoService;
import com.joshua.service.UserService;

@Controller
public class TodoController {

	@Autowired
	private TodoService todoService;
	
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public ModelAndView home(ModelAndView modelAndView, @Valid @ModelAttribute("todo") Todo todo, BindingResult result,
			@AuthenticationPrincipal Authentication auth) {
		modelAndView.setViewName("app.homepage");
		getTodos(modelAndView, auth);
		return modelAndView;
	}
	
	public ModelAndView getTodos(ModelAndView modelAndView, @AuthenticationPrincipal Authentication auth) {
        User user = userService.getLoggediuser(auth);
		modelAndView.setViewName("app.homepage");
		modelAndView.getModel().put("todoList", todoService.getTodos(user));

		return modelAndView;
	}

	@RequestMapping(value = "/addtodo", method = RequestMethod.POST)
	public ModelAndView addedTodo(ModelAndView modelAndView, @Valid @ModelAttribute("todo") Todo todo, BindingResult result,
			@AuthenticationPrincipal Authentication auth) {
		
         User user = userService.getLoggediuser(auth);
             todo.setUser(user);
			todoService.save(todo);
			modelAndView.setViewName("app.homepage");
			getTodos(modelAndView, auth);
			
		return modelAndView;
	}

	@RequestMapping(value = "/deletetodo/{id}", method = RequestMethod.GET)
	public ModelAndView deleteTodo(ModelAndView modelAndView, @PathVariable(name = "id") Long id, Todo todo,@AuthenticationPrincipal Authentication auth) {

		todoService.deleteTodo(id);
		getTodos(modelAndView, auth);

		modelAndView.setViewName("app.homepage");
		return modelAndView;
	}

	@RequestMapping(value = "/updatetodo/{id}", method = RequestMethod.GET)
	public ModelAndView UpdateTodo(ModelAndView modelAndView, @PathVariable(name = "id") Long id) {
		
		Todo todo = todoService.getTodo(id);
		modelAndView.getModel().put("todo", todo);

		modelAndView.setViewName("app.updatetodo");
		return modelAndView;
	}

	@RequestMapping(value = "/updatetodo/{id}", method = RequestMethod.POST)
	public ModelAndView Updated(ModelAndView modelAndView, @Valid @ModelAttribute("todo") Todo todo,@PathVariable Long id, BindingResult result
			,@AuthenticationPrincipal Authentication auth) {
		
			todoService.updateTodo(todo,id);
			modelAndView.setViewName("app.homepage");
			getTodos(modelAndView, auth);
		

		return modelAndView;
	}
}
