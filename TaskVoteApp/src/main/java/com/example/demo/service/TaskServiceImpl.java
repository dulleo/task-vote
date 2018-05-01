package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;

import reactor.core.publisher.Flux;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public Flux<Task> getAllTasks() {
		
		return taskRepository.findAll();
		
	}
}
