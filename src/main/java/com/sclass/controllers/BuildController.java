package com.sclass.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sclass.models.Build;
import com.sclass.models.BuildWithNames;
import com.sclass.services.BuildService;

import io.javalin.http.Context;

public class BuildController {

	private static BuildService bs;
	private static Logger log = LogManager.getLogger(BuildController.class);

	public BuildController(BuildService bs) {
		BuildController.bs = bs;
	}

	public void getAllBuildsForUser(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		log.info("HTTP GET Request received at endpoint /users/" + id + "/builds");

		List<BuildWithNames> buildList = bs.getAllBuildsWithNames(id);
		if (buildList.isEmpty()) {
			// valid user, no builds
			log.info("Successfully got builds for user with id " + id + " but they have no builds currently");
		}
//		if (buildList == null) {
//			// something wrong
//		} 
		else {
			log.info("Successfully got builds for user with id " + id);
		}
		ctx.json(buildList);
		ctx.status(200);
	}

	public void createBuild(Context ctx) {
		int userId = Integer.parseInt(ctx.pathParam("id"));
		log.info("HTTP POST Request received at endpoint /users/" + userId + "/builds");
		
		Build bodyAsBuild = ctx.bodyAsClass(Build.class);
		try {
			Build newBuild = bs.createBuild(userId, bodyAsBuild.getBuildName(), bodyAsBuild.getMoboId(),
					bodyAsBuild.getCpuId(), bodyAsBuild.getRamId(), bodyAsBuild.getStorageId(), bodyAsBuild.getPsuId(),
					bodyAsBuild.getCaseId(), bodyAsBuild.isHasFourRAM());
			
			log.info("Successfully created build with id " + newBuild.getBuildId() + " for user with id " + userId);
			ctx.status(201);
			ctx.json(newBuild);
		} catch (Exception e) {
			log.error(e.getMessage());
			ctx.json(e);
			ctx.status(400);
		}
	}

	public void editBuild(Context ctx) {
		int userId = Integer.parseInt(ctx.pathParam("id"));
		int buildId = Integer.parseInt(ctx.pathParam("buildId"));
		log.info("HTTP PUT Request received at endpoint /users/" + userId + "/builds " + buildId);
		
		Build bodyAsBuild = ctx.bodyAsClass(Build.class);
		bodyAsBuild.setUserId(userId);
		bodyAsBuild.setBuildId(buildId);

		try {
			bs.editBuild(bodyAsBuild);
			log.info("Successfully edited build with id " + buildId);
			ctx.status(202);
			ctx.json(bodyAsBuild);
		} catch (Exception e) {
			log.error(e.getMessage());
			ctx.json(e);
			ctx.status(400);
		}

	}

}
