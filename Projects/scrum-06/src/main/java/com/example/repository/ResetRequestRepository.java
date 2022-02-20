package com.example.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.ResetRequest;
import com.example.domain.User;

@Transactional	
public interface ResetRequestRepository extends CrudRepository<ResetRequest, String> {
	public ResetRequest findByRequester(User user);
	public ResetRequest findByRequestKey(String key);
}

