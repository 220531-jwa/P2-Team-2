package com.sclass.controllers;

import com.sclass.services.BuildService;

public class BuildController {
	
	private static BuildService bs;
	
	public BuildController(BuildService bs) {
		BuildController.bs = bs;
		
	}
	

}
