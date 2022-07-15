package com.sclass.controllers;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sclass.models.Build;
import com.sclass.services.BuildService;

import io.javalin.http.Context;


public class BuildController {
	
	private boolean reqs = true;
	private static BuildService bs;
	
	public BuildController(BuildService bs) {
		BuildController.bs = bs;
		
	}
	
	public void getOtherUserBuilds (Context ctx) {

		int id = Integer.parseInt(ctx.pathParam("id"));

		List<Build> builds = bs.getOtherUserBuilds(id);

		if (builds == null) {

		ctx.status(400);
		}

		else if (builds.isEmpty()) {

		ctx.json(builds);
		ctx.status(404);

		}

		else {

		ctx.json(builds);
		ctx.status(200);

		}

	}
	
}
	


