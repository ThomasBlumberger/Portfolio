package com.example.repo;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;

@Transactional
public interface UserRepository extends UserBaseRepository<User> {
	public List<User> findAll();
}
