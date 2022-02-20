package com.example.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.example.domain.User;

@NoRepositoryBean
public interface UserBaseRepository<T extends User> extends CrudRepository<T, String> {
	public T findByName(String name);
	public T findByUsername(String username);
	public T findByEmail(String email);
}
