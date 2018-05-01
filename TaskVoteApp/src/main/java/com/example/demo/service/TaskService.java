package com.example.demo.service;

import com.example.demo.model.Task;

import reactor.core.publisher.Flux;

public interface TaskService {
	
	Flux<Task> getAllTasks();
	
}
