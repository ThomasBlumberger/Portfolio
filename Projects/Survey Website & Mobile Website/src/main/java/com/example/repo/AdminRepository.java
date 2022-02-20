package com.example.repo;

import javax.transaction.Transactional;

import com.example.domain.Admin;

@Transactional
public interface AdminRepository extends UserBaseRepository<Admin> {

}
