package com.sclass.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sclass.models.Part;
import com.sclass.models.Part.manufacturer;
import com.sclass.models.Part.partType;
import com.sclass.utils.ConnectionUtility;

public class PartDAO {

	private static ConnectionUtility cu = ConnectionUtility.getConnectionUtility();

	public Part getPartById(int partId) {

		String sql = "select * from parts where part_id = ?";

		try (Connection conn = cu.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, partId);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return new Part(rs.getInt("part_id"), rs.getString("part_name"),
						rs.getObject("part_type", partType.class), rs.getInt("part_wattage"),
						rs.getDouble("part_price"), rs.getObject("manufacturer", manufacturer.class),
						rs.getInt("ram_slots"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Part> getPartsByType(Part.partType partType) {

		List<Part> parts = new ArrayList<>();

		String sql = "select * from parts where part_type = ?";

		try (Connection conn = cu.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, partType);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int partId = rs.getInt("part_id");
				String partName = rs.getString("part_name");
				int partWattage = rs.getInt("part_wattage");
				double partPrice = rs.getDouble("part_price");
				manufacturer manufacturer = rs.getObject("manufacturer", manufacturer.class);
				int ramSlots = rs.getInt("ram_slots");

				Part part = new Part(partId, partName, partType, partWattage, partPrice, manufacturer, ramSlots);

				parts.add(part);

			}
			return parts;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Part> getAllParts() {

		List<Part> parts = new ArrayList<>();

		String sql = "select * from parts";

		try (Connection conn = cu.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int partId = rs.getInt("part_id");
				String partName = rs.getString("part_name");
				partType partType = rs.getObject("part_type", partType.class);
				int partWattage = rs.getInt("part_wattage");
				double partPrice = rs.getDouble("part_price");
				manufacturer manufacturer = rs.getObject("manufacturer", manufacturer.class);
				int ramSlots = rs.getInt("ram_slots");

				Part part = new Part(partId, partName, partType, partWattage, partPrice, manufacturer, ramSlots);

				parts.add(part);

			}
			return parts;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Part> getAllPartsWithParams(double priceFloor, double priceCeiling) {

		List<Part> parts = new ArrayList<>();

		String sql = "select * from parts where part_price <= ? and part_price >= ?";

		try (Connection conn = cu.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setObject(1, priceCeiling);
			ps.setObject(2, priceFloor);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int partId = rs.getInt("part_id");
				String partName = rs.getString("part_name");
				partType partType = rs.getObject("part_type", partType.class);
				int partWattage = rs.getInt("part_wattage");
				double partPrice = rs.getDouble("part_price");
				manufacturer manufacturer = rs.getObject("manufacturer", manufacturer.class);
				int ramSlots = rs.getInt("ram_slots");

				Part part = new Part(partId, partName, partType, partWattage, partPrice, manufacturer, ramSlots);

				parts.add(part);

			}
			return parts;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<Part> getPartsInBuild(int moboId, int cpuId, int ramId, int storageId, int psuId,
			int caseId) {
		List<Part> parts = new ArrayList<>();

		String sql = "select * from parts where part_id = ? or part_id = ? or part_id = ? or part_id = ?"
				+ "part_id = ? or part_id = ?";

		try (Connection conn = cu.getConnection()) {

			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, moboId);
			ps.setInt(2, cpuId);
			ps.setInt(3, ramId);
			ps.setInt(4, storageId);
			ps.setInt(5, psuId);
			ps.setInt(6, caseId);
			
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Part part = new Part(rs.getInt("part_id"), rs.getString("part_name"), 
						rs.getObject("part_type", partType.class), rs.getInt("part_wattage"), 
						rs.getDouble("part_price"), rs.getObject("manufacturer", manufacturer.class), 
						rs.getInt("ram_slots"));

				parts.add(part);
			}
			return parts;

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

}
