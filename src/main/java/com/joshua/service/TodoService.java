package com.joshua.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joshua.model.Todo;
import com.joshua.model.TodoDao;
import com.joshua.model.User;

@Service
public class TodoService {

	@Autowired
	private TodoDao todoDao;
	
	public Todo save(Todo todo) {
	 return todoDao.save(todo);
	}
	
	
	public List<Todo> getTodos(User user) {
		return (List<Todo>) todoDao.findByUser(user);
	}
	public Todo getTodo(Long id) {
		return todoDao.findById(id).get();
	}
	
	public void updateTodo(Todo todo, Long id) {
		Todo tod = getTodo(id);
		tod.setName(todo.getName());
		tod.setTargetDate(todo.getTargetDate());
		
		todoDao.save(tod);
	}
	
	public void deleteTodo(Long id) {
		todoDao.deleteById(id);
	}
	
	
	
}
