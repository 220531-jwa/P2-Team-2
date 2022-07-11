package com.sclass.services;

import com.sclass.models.User;
import com.sclass.repositories.UserDAO;

public class UserService {

	private static UserDAO userDao;
	
	public UserService(UserDAO userDao) {
		this.userDao = userDao;
	}

	public User login(String username, String pass) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public User createUserAccount(String username, String pass) {
		// TODO Auto-generated method stub
		return null;
	}
}
