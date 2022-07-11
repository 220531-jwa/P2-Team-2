package com.sclass.repositories;

import com.sclass.models.Build;

public class BuildDAO {

	private static ConnectionUtility cu = ConnectionUtility.getConnectionUtility();
	
	public Build createBuild(String name, int moboId, int cpuId, int ramId, int storageId, int psuId, int caseId, 
			boolean hasFourRam, int userId) {
		return null;
	}
	
	public Build getBuildById(int buildId) {
		return null;
	}

	public Object getAllBuildsForUser(int userId) {
		return null;
	}
}
