package com.sclass.services;

import java.util.List;

import com.sclass.models.Build;
import com.sclass.repositories.BuildDAO;

public class BuildService {

	private static BuildDAO buildDao;
	
	public BuildService(BuildDAO buildDao) {
		this.buildDao = buildDao;
	}
	
	public Build createBuild(int userId, String name, int moboId, int cpuId, int ramId, int storageId, int psuId, 
			int caseId, boolean hasFourRam) throws Exception {
		// Will need more logic here
		// Get all parts from DB in build
		// Check if mobo and cpu have same manufacturer
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
