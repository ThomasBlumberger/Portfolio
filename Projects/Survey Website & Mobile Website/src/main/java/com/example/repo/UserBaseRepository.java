package com.example.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.example.domain.User;

@NoRepositoryBean
public interface UserBaseRepository<T extends User> extends CrudRepository<T, String> {
	public T findByFullName(String fullName);
	public T findByUserid(String userid);
	public T findByDOB(String DOB);
//	public T findByHomeAddress(String homeAddress);
	public T findBySni(String sni);
}
