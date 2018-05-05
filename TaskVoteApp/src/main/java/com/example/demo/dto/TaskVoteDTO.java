package com.example.demo.dto;

import com.example.demo.model.Vote;

public class TaskVoteDTO {

	private String id;
	private Vote vote;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Vote getVote() {
		return vote;
	}
	public void setVote(Vote vote) {
		this.vote = vote;
	}
}
