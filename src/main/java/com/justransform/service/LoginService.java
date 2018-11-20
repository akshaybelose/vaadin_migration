package com.justransform.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import com.justransform.model.User;

public interface LoginService {

	public User login(String userName,String password) throws NoSuchAlgorithmException, InvalidKeySpecException;
}
