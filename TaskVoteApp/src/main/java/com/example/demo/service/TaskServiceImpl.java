package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public Flux<Task> getAllTasks() {
		
		return taskRepository.findAll();
		
	}

	@Override
	public Mono<Task> createTask(Task task) {

		return taskRepository.save(task);
	}

	@Override
	public void deleteTask(String id) {
		
		taskRepository.deleteById(id);
	}
}
