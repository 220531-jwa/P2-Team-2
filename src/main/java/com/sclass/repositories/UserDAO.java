package com.sclass.repositories;



import com.sclass.models.User;
import com.sclass.utils.ConnectionUtility;

public class UserDAO {
//not sure if cu should be static
	private static ConnectionUtility cu = ConnectionUtility.getConnectionUtility();

	public User getUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public User createUserAccount(String username, String pass) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
