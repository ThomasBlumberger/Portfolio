package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.example.domain.Circumstance;
import com.example.domain.LivesWithCircumstance;
import com.example.domain.User;

@NoRepositoryBean
public interface CircumstanceBaseRepository<T extends Circumstance> extends CrudRepository<T, String> {
	public Circumstance findById(Integer id);
	public List<T> findAll();
	public void deleteById(int id);
}
