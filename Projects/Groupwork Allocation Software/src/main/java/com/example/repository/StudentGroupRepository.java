package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.example.domain.StudentGroup;

public interface StudentGroupRepository extends CrudRepository<StudentGroup, Integer> {
	
	public StudentGroup findById(int id);

	public List<StudentGroup> findAll();
}
