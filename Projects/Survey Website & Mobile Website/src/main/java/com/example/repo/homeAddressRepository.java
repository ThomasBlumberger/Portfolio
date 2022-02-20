package com.example.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.domain.User;
import com.example.domain.homeAddress;

public interface homeAddressRepository extends CrudRepository<homeAddress, User> {
	
	public List<homeAddress> findAll();

}
