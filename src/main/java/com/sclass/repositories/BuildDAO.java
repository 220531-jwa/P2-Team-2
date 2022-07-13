package com.sclass.repositories;

import com.sclass.models.Build;
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
}
