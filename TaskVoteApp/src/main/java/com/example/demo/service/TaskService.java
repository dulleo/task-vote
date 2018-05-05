package com.example.demo.service;

import com.example.demo.dto.TaskVoteDTO;
import com.example.demo.model.Task;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TaskService {
	
	Flux<Task> getAllTasks();

	Mono<Task> createTask(Task task);

	void deleteTask(String id);
	
	Mono<Task> vote(TaskVoteDTO taskVoteDTO);
	
}
