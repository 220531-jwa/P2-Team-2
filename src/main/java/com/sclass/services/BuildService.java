package com.sclass.services;

import java.util.List;

import com.sclass.models.Build;
import com.sclass.models.Part;
import com.sclass.repositories.BuildDAO;
import com.sclass.repositories.PartDAO;

public class BuildService {

	private static BuildDAO buildDao;
	private static PartDAO partDao;

	public BuildService(BuildDAO buildDao, PartDAO partDao) {
		BuildService.buildDao = buildDao;
		BuildService.partDao = partDao;
	}

	public Build createBuild(int userId, String name, int moboId, int cpuId, int ramId, int storageId, int psuId,
			int caseId, boolean hasFourRam) throws Exception {
		// Get all parts from DB in build
		List<Part> partsInBuild = partDao.getPartsInBuild(moboId, cpuId, ramId, storageId, psuId, caseId);

		// Need to parse this list to individual part objects
		Part mobo = null, cpu = null, ram = null, storage = null, psu = null, casePart = null;
		for (Part part : partsInBuild) {
			switch (part.getPartType()) {
			case MOBO:
				mobo = part;
				break;
			case CPU:
				cpu = part;
				break;
			case RAM:
				ram = part;
				break;
			case STORAGE:
				storage = part;
				break;
			case PSU:
				psu = part;
				break;
			case CASE:
				casePart = part;
				break;
			}
		}
		
		try {
			checkCompatibility(mobo, cpu, ram, storage, psu, casePart, hasFourRam);
		} catch (Exception e) {
			throw e;
		}

		return buildDao.createBuild(userId, name, moboId, cpuId, ramId, storageId, psuId, caseId, hasFourRam);
	}

	public void checkCompatibility(Part mobo, Part cpu, Part ram, Part storage, Part psu, Part casePart, 
			boolean hasFourRam) throws Exception {
		// Check if mobo and cpu have same manufacturer
		if (mobo.getManufacturer() != cpu.getManufacturer()) {
			throw new Exception("Can't create build: CPU isn't compatible with selected motherboard.");
		}

		// Check if mobo has enough capacity for ram
		int ramInBuild = hasFourRam ? ram.getRamSlots() * 2 : ram.getRamSlots();
		if (mobo.getRamSlots() < ramInBuild) {
			throw new Exception("Can't create build: Motherboard doesn't have enough RAM slots.");
		}

		// Check if psu wattage is greater than the sum of the other parts
		int totalWattage = mobo.getPartWattage() + cpu.getPartWattage() + ram.getPartWattage()
				+ storage.getPartWattage() + casePart.getPartWattage();
		if (totalWattage > psu.getPartWattage()) {
			throw new Exception("Can't create build: PSU doesn't supply enough wattage to power the current build.");
		}
	}

	public Build getBuildById(int buildId) throws Exception {
		Build build = buildDao.getBuildById(buildId);
		if (build == null) {
			throw new Exception("Build with id " + buildId + " doesn't exist.");
		} else {
			return build;
		}
	}

	public List<Build> getAllBuildsForUser(int userId) {
		return buildDao.getAllBuildsForUser(userId);
	}
}
