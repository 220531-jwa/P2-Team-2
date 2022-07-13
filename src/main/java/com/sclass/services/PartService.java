package com.sclass.services;

import java.util.List;

import com.sclass.models.Part;
import com.sclass.repositories.PartDAO;

public class PartService {

	private PartDAO partDao;

	public PartService(PartDAO partDao) {
		this.partDao = partDao;
	}

	public Part getPartById(int partId) throws Exception {
		Part part = partDao.getPartById(partId);
		if (part == null) {
			throw new Exception("Part with ID: " + partId + " doesn't exist.");
		}
		return part;
	}

	public List<Part> getPartsByType(Part.partType partType) throws Exception {
		List<Part> parts = partDao.getPartsByType(partType);
		if (parts.isEmpty()) {
			throw new Exception("No parts of type: \"" + partType.toString() + "\" are available.");
		}
		return parts;
	}

	public List<Part> getAllParts() throws Exception {
		List<Part> parts = partDao.getAllParts();
		if (parts.isEmpty()) {
			throw new Exception("We are plum out of parts. Check back later!");
		}
		return parts;
	}

	public List<Part> getAllPartsWithParams(double priceFloor, double priceCeiling) throws Exception {
		List<Part> parts = partDao.getAllPartsWithParams(priceFloor, priceCeiling);
		if (parts.isEmpty()) {
			throw new Exception("No parts available between: $" + priceFloor + " and $" + priceCeiling);
		}

		return parts;
	}

}
