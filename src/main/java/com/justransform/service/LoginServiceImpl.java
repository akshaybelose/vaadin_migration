package com.justransform.service;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.justransform.dao.LoginDAO;
import com.justransform.model.User;
@Repository
@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginDAO loginDao;
	
	  public User login(String userName,String password) throws NoSuchAlgorithmException, InvalidKeySpecException {
		  System.out.println("In loginservice");
	    	
		  User user = loginDao.findByEmailId(userName);
		  String encryptedPassword = user.getPassword();
		  String salt = user.getSalt();
		  if(new PasswordEncryptionService().authenticate(password, encryptedPassword, salt)) {
			  //System.out.println(user.getFirstName());
			  return user;
		  }
			  
		return null;
	    }
}
