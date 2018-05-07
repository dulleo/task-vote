package com.example.demo.websocket;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.socket.WebSocketHandler;
import org.springframework.web.reactive.socket.WebSocketMessage;
import org.springframework.web.reactive.socket.WebSocketSession;
import com.fasterxml.jackson.core.JsonProcessingException;

import com.example.demo.model.Task;
import com.example.demo.repository.TaskRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ReactiveWebSocketHandler implements WebSocketHandler {

	private TaskRepository taskRepository;
	private static final ObjectMapper json = new ObjectMapper();
	
	@Autowired
	public ReactiveWebSocketHandler(TaskRepository taskRepository) {
		this.taskRepository = taskRepository;
	}
	
	private Flux<String> eventFlux = Flux.generate(sink -> {
        //Event event = new Event(randomUUID().toString(), now().toString());
		
		if(taskRepository == null) {
			System.out.println("task repo is null!!!");
		}
		Flux<Task> allTask = taskRepository.findAll();
		
        try {
            sink.next(json.writeValueAsString(allTask));								//json.writeValueAsString(event));
        } catch (JsonProcessingException e) {//JsonProcessingException e) {
            sink.error(e);
        }
		});
	
	private Flux<String> intervalFlux = Flux.interval(Duration.ofMillis(1000L))
			.zipWith(eventFlux, (time, event) -> event);

	@Override
	public Mono<Void> handle(WebSocketSession webSocketSession) {
		return webSocketSession.send(eventFlux
		          .map(webSocketSession::textMessage))
		          .and(webSocketSession.receive()
		.map(WebSocketMessage::getPayloadAsText).log());
	}

}
