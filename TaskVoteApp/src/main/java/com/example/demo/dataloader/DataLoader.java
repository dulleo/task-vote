package com.example.demo.dataloader;

import java.util.ArrayList;
import java.util.List;

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
	
		List<Task> tasks = new ArrayList<>();
		tasks.add(new Task("Task1", 1, 1));
		tasks.add(new Task("Task2", 2, 2));
		tasks.add(new Task("Task3", 3, 3));
		
		logger.info("Loading data started");
		taskRepository.saveAll(tasks).blockLast();
		logger.info("Loading data completed...");	
	}
}
