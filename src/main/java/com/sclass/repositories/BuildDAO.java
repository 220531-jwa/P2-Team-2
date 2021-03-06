package com.sclass.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sclass.models.Build;
import com.sclass.models.BuildWithNames;
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

		try (Connection conn = cu.getConnection()) {
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

	public List <BuildWithNames> getAllBuildsWithNames(int userId){
		List <BuildWithNames> builds = new ArrayList<>();

		String sql = "select build_id, build_name, mobo.part_name as mobo_name, mobo.part_price as price1,"
				+ " cpu.part_name as cpu_name, cpu.part_price as price2,"
				+ " ram.part_name as ram_name, ram.part_price as price3, " +
				"stor.part_name as storage_name, stor.part_price as price4,"
				+ " psu.part_name as psu_name, psu.part_price as price5,"
				+ " cas.part_name as case_name, cas.part_price as price6,"
				+ " build_has_four_ram from pcbuilder.builds bt" +
				" left outer join pcbuilder.parts mobo on bt.build_mobo = mobo.part_id" +
				" left outer join pcbuilder.parts cpu on bt.build_cpu = cpu.part_id" +
				" left outer join pcbuilder.parts ram on bt.build_ram = ram.part_id" +
				" left outer join pcbuilder.parts stor on bt.build_storage = stor.part_id" +
				" left outer join pcbuilder.parts psu on bt.build_power_supply = psu.part_id" +
				" left outer join pcbuilder.parts cas on bt.build_case = cas.part_id" +
				" where user_id = ?";

		try (Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				double price = rs.getDouble("price1") +
						rs.getDouble("price2") +
						rs.getDouble("price3") +
						rs.getDouble("price4") +
						rs.getDouble("price5") +
						rs.getDouble("price6");
				
				BuildWithNames b = new BuildWithNames(
						rs.getInt("build_id"),
						rs.getString("build_name"),
						rs.getString("mobo_name"),
						rs.getString("cpu_name"),
						rs.getString("ram_name"),
						rs.getString("storage_name"),
						rs.getString("psu_name"),
						rs.getString("case_name"),
						rs.getBoolean("build_has_four_ram"),
						price
						);
				builds.add(b);
			}
			return builds;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List <BuildWithNames>getOtherBuildsWithNames(int userId){
		List <BuildWithNames> builds = new ArrayList<>();

		String sql = "select build_id, build_name, mobo.part_name as mobo_name, mobo.part_price as price1,"
				+ " cpu.part_name as cpu_name, cpu.part_price as price2,"
				+ " ram.part_name as ram_name, ram.part_price as price3, " +
				"stor.part_name as storage_name, stor.part_price as price4,"
				+ " psu.part_name as psu_name, psu.part_price as price5,"
				+ " cas.part_name as case_name, cas.part_price as price6,"
				+ " build_has_four_ram from pcbuilder.builds bt" +
				" left outer join pcbuilder.parts mobo on bt.build_mobo = mobo.part_id" +
				" left outer join pcbuilder.parts cpu on bt.build_cpu = cpu.part_id" +
				" left outer join pcbuilder.parts ram on bt.build_ram = ram.part_id" +
				" left outer join pcbuilder.parts stor on bt.build_storage = stor.part_id" +
				" left outer join pcbuilder.parts psu on bt.build_power_supply = psu.part_id" +
				" left outer join pcbuilder.parts cas on bt.build_case = cas.part_id" +
				" where user_id != ? order by user_id";

		try (Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				
				double price = rs.getDouble("price1") +
						rs.getDouble("price2") +
						rs.getDouble("price3") +
						rs.getDouble("price4") +
						rs.getDouble("price5") +
						rs.getDouble("price6");
				
				BuildWithNames b = new BuildWithNames(
						rs.getInt("build_id"),
						rs.getString("build_name"),
						rs.getString("mobo_name"),
						rs.getString("cpu_name"),
						rs.getString("ram_name"),
						rs.getString("storage_name"),
						rs.getString("psu_name"),
						rs.getString("case_name"),
						rs.getBoolean("build_has_four_ram"),
						price
						);
				builds.add(b);
			}
			return builds;
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public  BuildWithNames getSingleBuildWithNames(int buildId){
//		List <BuildWithNames> builds = new ArrayList<>();

		String sql = "select build_id, build_name, mobo.part_name as mobo_name, mobo.part_price as price1,"
				+ " cpu.part_name as cpu_name, cpu.part_price as price2,"
				+ " ram.part_name as ram_name, ram.part_price as price3, " +
				"stor.part_name as storage_name, stor.part_price as price4,"
				+ " psu.part_name as psu_name, psu.part_price as price5,"
				+ " cas.part_name as case_name, cas.part_price as price6,"
				+ " build_has_four_ram from pcbuilder.builds bt" +
				" left outer join pcbuilder.parts mobo on bt.build_mobo = mobo.part_id" +
				" left outer join pcbuilder.parts cpu on bt.build_cpu = cpu.part_id" +
				" left outer join pcbuilder.parts ram on bt.build_ram = ram.part_id" +
				" left outer join pcbuilder.parts stor on bt.build_storage = stor.part_id" +
				" left outer join pcbuilder.parts psu on bt.build_power_supply = psu.part_id" +
				" left outer join pcbuilder.parts cas on bt.build_case = cas.part_id" +
				" where build_id = ?";

		try (Connection conn = cu.getConnection()){
			PreparedStatement ps = conn.prepareStatement(sql);

			ps.setInt(1, buildId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				
				double price = rs.getDouble("price1") +
						rs.getDouble("price2") +
						rs.getDouble("price3") +
						rs.getDouble("price4") +
						rs.getDouble("price5") +
						rs.getDouble("price6");
				
				BuildWithNames b = new BuildWithNames(
						rs.getInt("build_id"),
						rs.getString("build_name"),
						rs.getString("mobo_name"),
						rs.getString("cpu_name"),
						rs.getString("ram_name"),
						rs.getString("storage_name"),
						rs.getString("psu_name"),
						rs.getString("case_name"),
						rs.getBoolean("build_has_four_ram"),
						price
						);
//				builds.add(b);
//				
				System.out.println(b);
				return b;
			}
			
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public Build editBuild(Build bodyAsBuild) {

		String sql = "update pcbuilder.builds set build_id = ?, user_id = ?, build_name = ?, build_mobo = ?, build_cpu = ?, build_ram = ?, build_storage = ?, build_power_supply = ?, build_case = ?, build_has_four_ram = ? where build_id = ? returning *";

		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bodyAsBuild.getBuildId());
			ps.setInt(2, bodyAsBuild.getUserId());
			ps.setString(3, bodyAsBuild.getBuildName());
			ps.setInt(4, bodyAsBuild.getMoboId());
			ps.setInt(5, bodyAsBuild.getCpuId());
			ps.setInt(6, bodyAsBuild.getRamId());
			ps.setInt(7, bodyAsBuild.getStorageId());
			ps.setInt(8, bodyAsBuild.getPsuId());
			ps.setInt(9, bodyAsBuild.getCaseId());
			ps.setBoolean(10, bodyAsBuild.isHasFourRAM());
			ps.setInt(11, bodyAsBuild.getBuildId());

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
	

	public Build deleteBuild(int id) {
		String sql = "delete from pcbuilder.builds where build_id = ? returning *";
		
		try (Connection conn = cu.getConnection()) {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
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
}

