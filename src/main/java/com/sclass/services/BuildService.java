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
		
		// Check if mobo and cpu have same manufacturer
		// Check if mobo has enough capacity for ram (maybe do on frontend?)
		// Check if psu wattage is greater than the sum of the other parts
		
		return buildDao.createBuild(userId, name, moboId, cpuId, ramId, storageId, psuId, caseId, hasFourRam);
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
