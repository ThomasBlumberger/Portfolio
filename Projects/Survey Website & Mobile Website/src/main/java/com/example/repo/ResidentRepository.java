package com.example.repo;

import java.util.List;

import javax.transaction.Transactional;

import com.example.domain.Resident;

@Transactional
public interface ResidentRepository extends UserBaseRepository<Resident> {
	public List<Resident> findAll();
}
