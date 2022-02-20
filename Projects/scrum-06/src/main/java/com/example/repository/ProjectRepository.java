package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import com.example.domain.Project;

public interface ProjectRepository extends CrudRepository<Project, Integer> {
	
	public Project findById(int id);

}
