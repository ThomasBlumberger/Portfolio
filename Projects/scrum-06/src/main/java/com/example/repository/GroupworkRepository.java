package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.LivesWithCircumstance;
import com.example.domain.Groupwork;

public interface GroupworkRepository extends CrudRepository<Groupwork, String> {
	public Groupwork findById(Integer Id);
	public Groupwork findByName(String name);
	public List<Groupwork> findAll();
	public Groupwork findByCircumstances(LivesWithCircumstance c);
}
