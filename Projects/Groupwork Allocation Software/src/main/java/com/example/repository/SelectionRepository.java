package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.Selection;

public interface SelectionRepository extends CrudRepository<Selection, String> {
	public Selection findById (Integer id);
	public List<Selection> findAll();
}
