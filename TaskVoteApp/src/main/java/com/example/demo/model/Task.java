package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Task {
	
	@Id
	private String id;
	private String name;
	private Integer upVote;
	private Integer downVote;
	
	//Empty constructor is needed for Jakson to deserialize JSON
	public Task() {}
	
	@Override
	public String toString() {
		return "Task [id=" + id + ", name=" + name + ", upVote=" + upVote + ", downVote=" + downVote + "]";
	}

	public Task(String name, int upVote, int downVote) {
		this.name = name;
		this.upVote = upVote;
		this.downVote = downVote;
	}

	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getUpVote() {
		return upVote;
	}
	
	public void setUpVote(Integer upVote) {
		this.upVote = upVote;
	}
	
	public Integer getDownVote() {
		return downVote;
	}
	
	public void setDownVote(Integer downVote) {
		this.downVote = downVote;
	}
}
