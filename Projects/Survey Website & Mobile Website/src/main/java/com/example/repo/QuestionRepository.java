package com.example.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Question;

public interface QuestionRepository extends CrudRepository<Question, Integer> {
	public List<Question> findAll();
	public Question findByID(Integer ID);
}
