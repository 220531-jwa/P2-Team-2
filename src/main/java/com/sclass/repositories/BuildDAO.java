package com.sclass.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sclass.models.Build;
import com.sclass.utils.ConnectionUtility;

public class BuildDAO {

	private static ConnectionUtility cu = ConnectionUtility.getConnectionUtility();
	
	public Build createBuild(int userId, String name, int moboId, int cpuId, int ramId, int storageId, int psuId, 
			int caseId, boolean hasFourRam) {
		String sql = "insert into pcbuilder.builds values (default, ?, ?, ?, ?, ?, ?, ?, ?, ?) returning *";

		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			ps.setString(2, name);
			ps.setInt(3, moboId);
			ps.setInt(4, cpuId);
			ps.setInt(5, ramId);
			ps.setInt(6, storageId);
			ps.setInt(7, psuId);
			ps.setInt(8, caseId);
			ps.setBoolean(9, hasFourRam);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Build(rs.getInt("build_id"), rs.getInt("user_id"), rs.getString("build_name"),
						rs.getInt("build_mobo"), rs.getInt("build_cpu"), rs.getInt("build_ram"),
						rs.getInt("build_storage"), rs.getInt("build_power_supply"), rs.getInt("build_case"),
						rs.getBoolean("build_has_four_ram"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public Build getBuildById(int buildId) {
		String sql = "select * from pcbuilder.builds where build_id = ?";

		try (Connection conn = cu.getConnection();) {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, buildId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Build(rs.getInt("build_id"), rs.getInt("user_id"), rs.getString("build_name"),
						rs.getInt("build_mobo"), rs.getInt("build_cpu"), rs.getInt("build_ram"),
						rs.getInt("build_storage"), rs.getInt("build_power_supply"), rs.getInt("build_case"),
						rs.getBoolean("build_has_four_ram"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Build> getAllBuildsForUser(int userId) {
		List<Build> builds = new ArrayList<>();
		String sql = "select * from pcbuilder.builds where user_id = ?";

		try (Connection conn = cu.getConnection();) {
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Build b = new Build(rs.getInt("build_id"), rs.getInt("user_id"), rs.getString("build_name"),
						rs.getInt("build_mobo"), rs.getInt("build_cpu"), rs.getInt("build_ram"),
						rs.getInt("build_storage"), rs.getInt("build_power_supply"), rs.getInt("build_case"),
						rs.getBoolean("build_has_four_ram"));
				builds.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return builds;
	}
}
