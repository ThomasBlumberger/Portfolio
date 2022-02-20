package com.example.repository;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Student;

@Transactional
public interface StudentRepository extends UserBaseRepository<Student> {
	public List<Student> findAll();

}
