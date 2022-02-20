package com.example.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ResetRequest {
	@Id
	private String requestKey;
	
	@OneToOne
	private User requester;
	
	public ResetRequest() {
		this.requestKey = TokenGenerator.nextToken();
	}
	
	public ResetRequest(User requester) {
		this.requester = requester;
		this.requestKey = TokenGenerator.nextToken();
	}

	public User getRequester() {
		return requester;
	}

	public void setRequester(User requester) {
		this.requester = requester;
	}

	public String getRequestKey() {
		return requestKey;
	}

	public void setRequestKey(String key) {
		this.requestKey = key;
	}
}
