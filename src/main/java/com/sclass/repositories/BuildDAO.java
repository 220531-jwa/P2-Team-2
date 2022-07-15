package com.sclass.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.sql.SQLException;

import com.sclass.models.Build;
import com.sclass.models.User;
import com.sclass.utils.ConnectionUtility;

public class BuildDAO {

	private static ConnectionUtility cu = ConnectionUtility.getConnectionUtility();

	public Build createBuild(String name, int moboId, int cpuId, int ramId, int storageId, int psuId, int caseId,
			boolean hasFourRam, int userId) {
		return null;
	}

	public Build getBuildById(int buildId) {
		return null;
	}

	public Build getAllBuildsForUser(int userId) {
		return null;
	}

	public List<Build> getOtherUserBuilds(int id, String sql) {
		String sql = "SELECT\r\n"
				+ "    build_id,\r\n"
				+ "    user_id\r\n"
				+ "FROM\r\n"
				+ "    pcbuilder.builds\r\n"
				+ "WHERE\r\n"
				+ "    user_id != ?";
		
		try (Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, sql);
			ps.setString(2, sql);
					
					ResultSet rs = ps.executeQuery();
					
					if (rs.next()) {
						return (List<Build>) new User(
								rs.getInt("user_id"),
								rs.getString("username"),
								rs.getString("sql")
								);
					}
						
					}catch (SQLException e) {
						e.printStackTrace();
					}
		return null;
	}

}
