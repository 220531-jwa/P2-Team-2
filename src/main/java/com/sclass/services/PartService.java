package com.sclass.services;

import java.util.List;

import com.sclass.models.Part;
import com.sclass.repositories.PartDAO;

public class PartService {

	private static PartDAO partDao;

	public PartService(PartDAO partDao) {
		this.partDao = partDao;
	}

	public Part getPartById(int partId) {
		Part part = partDao.getPartById(partId);
		return part;
	}

	public List<Part> getPartsByType(Part.partType partType) {
		List<Part> parts = partDao.getPartsByType(partType);
//		return parts;

		List<Part> test = partDao.getAllParts();
		for (Part part : test) {
			if (part.getPartType() != partType) {
				test.remove(part);
			}
		}

		return test;
	}

	public List<Part> getAllParts() {
		List<Part> parts = partDao.getAllParts();
		return parts;
	}

	public List<Part> getAllPartsWithParams(double priceFloor, double priceCeiling) {
		List<Part> parts = partDao.getAllPartsWithParams(priceFloor, priceCeiling);
		return parts;
	}

}
