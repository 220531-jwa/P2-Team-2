package com.sclass.services;

import java.util.List;

import com.sclass.models.Build;
import com.sclass.models.User;
import com.sclass.repositories.UserDAO;

public class UserService {

	private UserDAO userDao; //static?

	public UserService(UserDAO userDao) {
		this.userDao = userDao;
	}

	public User login(String username, String pass) {

		User logi = userDao.getUserByUsername(username); 
		if (logi != null) {
			if (logi.getPass().equals(pass)) {
				return logi;
			}
		}

		return null;
	}


	public User createUserAccount(String username, String pass) throws Exception {
		
		User check = userDao.getUserByUsername(username);
		if (check == null) {
			return(userDao.createUserAccount(username, pass)); //make sure DAO returns created user
		}
		else {
			throw new Exception("A user with this name already exists!");
		}
		
	}

	public List<Build> getBuildsByUser(int id) {
		
		
		
		return null;
	}
}
