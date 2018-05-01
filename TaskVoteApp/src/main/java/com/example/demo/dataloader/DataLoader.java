package com.example.demo.dataloader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;

@Component
public class DataLoader implements CommandLineRunner {
	
	private final Logger logger = LoggerFactory.getLogger(DataLoader.class);
	private final TaskRepository taskRepository;
	
	public DataLoader(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Delete old data from db started.");
		taskRepository.deleteAll().block();
		logger.info("Delete old data from db completed...");
		
		Task t = new Task("Task1", 0, 0);
		
		logger.info("Loading data started");
		taskRepository.save(t).block();
		logger.info("Loading data completed...");
		
	}

}
