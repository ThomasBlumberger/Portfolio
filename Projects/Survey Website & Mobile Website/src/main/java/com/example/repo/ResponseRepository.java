package com.example.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Question;
import com.example.domain.Response;
import com.example.domain.User;

public interface ResponseRepository extends CrudRepository<Response, Integer> {
	public Response findByUser(User user);
	public List<Response> findAll();
	public Response findByQuestion(Question question);
}
