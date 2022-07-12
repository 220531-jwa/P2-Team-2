package com.sclass.repositories;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sclass.models.User;
import com.sclass.utils.ConnectionUtility;

public class UserDAO {
	//not sure if cu should be static
	private static ConnectionUtility cu = ConnectionUtility.getConnectionUtility();

	public User getUserByUsername(String username) {
		String sql = "select * from pcbuilder.users where username = ?";

		try (Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return new User(
						rs.getInt("user_id"),
						rs.getString("username"),
						rs.getString("pword")
						);
			}

		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public User createUserAccount(String username, String pass) {
		String sql = "insert into pcbuilder.users values (default, ?, ?) returning *";
		
		try (Connection conn = cu.getConnection()){
		PreparedStatement ps = conn.prepareStatement(sql);
		
		ps.setString(1, username);
		ps.setString(2, pass);
		ResultSet rs = ps.executeQuery();
		
		if (rs.next()) {
			return new User(
					rs.getInt("user_id"),
					rs.getString("username"),
					rs.getString("pword")
					);
		}
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}




}
