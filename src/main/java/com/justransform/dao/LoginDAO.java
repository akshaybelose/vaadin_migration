package com.justransform.dao;

import org.springframework.data.repository.CrudRepository;

import com.justransform.model.User;

public interface LoginDAO extends CrudRepository <User, Long> {

	public User findByEmailId(String emailId);
}
