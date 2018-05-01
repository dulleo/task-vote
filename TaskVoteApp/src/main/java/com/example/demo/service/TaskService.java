package com.example.demo.service;

import com.example.demo.model.Task;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TaskService {
	
	Flux<Task> getAllTasks();

	Mono<Task> createTask(Task task);

	void deleteTask(String id);
	
}
