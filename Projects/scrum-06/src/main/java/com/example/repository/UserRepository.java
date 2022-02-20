package com.example.repository;

import org.springframework.transaction.annotation.Transactional;

import com.example.domain.User;

@Transactional
public interface UserRepository extends UserBaseRepository<User> {

}
