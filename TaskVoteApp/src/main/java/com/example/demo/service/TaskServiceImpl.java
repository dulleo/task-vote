package com.example.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.dto.TaskVoteDTO;
import com.example.demo.model.Task;
import com.example.demo.model.Vote;
import com.example.demo.repository.TaskRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TaskServiceImpl implements TaskService {
	
	private final Logger logger = LoggerFactory.getLogger(TaskServiceImpl.class);

	@Autowired
	private TaskRepository taskRepository;
	
	@Override
	public Flux<Task> getAllTasks() {
		logger.info("findAll() tasks...");
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
	
	@Override
	public Mono<Task> vote(TaskVoteDTO taskVoteDTO) {
		//find task
		Mono<Task> task = taskRepository.findById(taskVoteDTO.getId());
		
		if(task != null) {
			if(Vote.UPVOTE.equals(taskVoteDTO.getVote())) {
				task.map(taskData -> {
					taskData.setUpVote(taskData.getUpVote() + 1);
					return taskRepository.save(taskData);
				});
			} 
			
			if(Vote.DOWNVOTE.equals(taskVoteDTO.getVote()))
				task.map(taskData -> {
					taskData.setDownVote(taskData.getDownVote() + 1);
					return taskRepository.save(taskData);
				});
		}
		
		return null;
	}
}
