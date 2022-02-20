package com.example.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Option;

public interface OptionRepository extends CrudRepository<Option, Integer> {
	public Option findByQuestionOption(String questionOption);
	public List<Option> findAll();
	public Option findById(int id);
}
