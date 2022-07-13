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



//select build_id, build_name, mobo.part_name as mobo_name, cpu.part_name as cpu_name, ram.part_name as ram_name, 
//stor.part_name as storage_name, psu.part_name as psu_name, cas.part_name as case_name, build_has_four_ram
//	from pcbuilder.builds bt
//	left outer join pcbuilder.parts mobo on bt.build_mobo = mobo.part_id
//	left outer join pcbuilder.parts cpu on bt.build_cpu = cpu.part_id
//	left outer join pcbuilder.parts ram on bt.build_ram = ram.part_id
//	left outer join pcbuilder.parts stor on bt.build_storage = stor.part_id
//	left outer join pcbuilder.parts psu on bt.build_power_supply = psu.part_id
//	left outer join pcbuilder.parts cas on bt.build_case = cas.part_id
//where user_id = ?;