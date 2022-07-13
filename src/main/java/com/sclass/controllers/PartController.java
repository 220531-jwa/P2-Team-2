package com.sclass.controllers;

import com.sclass.services.PartService;

public class PartController {

	private PartService partService;

	public PartController(PartService partService) {
		this.partService = partService;
	}

}
