package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Task;
import com.example.demo.service.TaskService;

import reactor.core.publisher.Flux;

@CrossOrigin(origins= "http://localhost:4200")
@RestController
@RequestMapping("")
public class TaskController {

	@Autowired
	private TaskService taskService; 
	
	@GetMapping(value = "/tasks")
	public Flux<Task> getAllTasks() {
		return taskService.getAllTasks();
	}
}
