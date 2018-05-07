package com.example.demo.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
	
	private final Logger logger = LoggerFactory.getLogger(TaskController.class);

	@Autowired
	private TaskService taskService; 
	
	@GetMapping(value = "/tasks", produces = MediaType.TEXT_EVENT_STREAM_VALUE)//produces=MediaType.APPLICATION_STREAM_JSON_VALUE)//produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Task> getAllTasks() {
		logger.info("Getting all tasks...");
		return taskService.getAllTasks().log();
	}
	
	@PostMapping("/tasks")
	public Mono<Task> createTask(@Valid @RequestBody Task task) {
		logger.info("Creatting task....");
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
