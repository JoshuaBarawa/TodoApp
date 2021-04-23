package com.joshua.model;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoDao extends CrudRepository<Todo, Long> {

	List<Todo> findByUser(User user);
} 
