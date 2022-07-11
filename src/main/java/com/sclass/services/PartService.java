package com.sclass.services;

import com.sclass.repositories.PartDAO;

public class PartService {

	private static PartDAO partDao;

	public PartService(PartDAO partDao) {
		this.partDao = partDao;
	}

}
