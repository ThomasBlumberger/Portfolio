package com.example.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Circumstance;
import com.example.domain.LivesWithCircumstance;
import com.example.domain.OtherCircumstance;
import com.example.domain.Student;
import com.example.domain.User;

@Transactional
public interface OtherCircumstanceRepository extends CircumstanceBaseRepository<OtherCircumstance> {

}