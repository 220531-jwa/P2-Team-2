package com.sclass.services;

import com.sclass.models.Build;
import com.sclass.repositories.BuildDAO;

public class BuildService {

	private static BuildDAO buildDao;
	
	public BuildService(BuildDAO buildDao) {
		this.buildDao = buildDao;
	}
	
	public Build createBuild(String name, int moboId, int cpuId, int ramId, int storageId, int psuId, int caseId, 
			boolean hasFourRam, int userId) throws Exception {
		return null;
	}

	public Build getBuildById(int buildId) throws Exception {
		return null;
	}

	public Object getAllBuildsForUser(int userId) {
		return null;
	}
}
