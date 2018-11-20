/*package com.justransform.dao;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.justransform.model.User;

public class LoginDAOImpl implements LoginDAO {

	@Autowired
	SessionFactory sessionFactory;
	public User getUser(String username, String password)
	{
		Query query = sessionFactory.getCurrentSession()
				.createQuery("from User where emailId = :emailId and password = :password");
		query.setParameter("emailId", username);
		query.setParameter("password", password);
		User users = (User) query.uniqueResult();
		
		System.out.println("User "+users.getFirstName());
		return users;
	}
}
*/