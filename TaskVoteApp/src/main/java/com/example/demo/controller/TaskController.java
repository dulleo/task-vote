package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.TaskVoteDTO;
import com.example.demo.model.Task;
import com.example.demo.service.TaskService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

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
	
	@PostMapping("/tasks")
	public Mono<Task> createTask(@Valid @RequestBody Task task) {
		return taskService.createTask(task);
	}
	
	@DeleteMapping("/tasks/{id}")
	public void deleteTask(@PathVariable String id) {
		taskService.deleteTask(id);
	}
	
	/**
	 * 
	 * @param id
	 * @param taskVoteDTO
	 * @return
	 */
	@PutMapping("/tasks/vote/{id}")
	public Mono<Task> vote(@PathVariable("id") String id, @Valid @RequestBody TaskVoteDTO taskVoteDTO) {
		return taskService.vote(taskVoteDTO);
	}
}
