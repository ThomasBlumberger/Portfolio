package com.example.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import com.example.domain.Convenor;

@Transactional
public interface ConvenorRepository extends UserBaseRepository<Convenor> {
	public List<Convenor> findAll();

}
