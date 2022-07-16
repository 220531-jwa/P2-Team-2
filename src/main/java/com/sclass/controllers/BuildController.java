package com.sclass.controllers;

import java.util.List;

import com.sclass.models.Build;
import com.sclass.models.BuildWithNames;
import com.sclass.services.BuildService;

import io.javalin.http.Context;

public class BuildController {

	private static BuildService bs;

	public BuildController(BuildService bs) {
		BuildController.bs = bs;
	}

	public void getAllBuildsForUser(Context ctx) {
		int id = Integer.parseInt(ctx.pathParam("id"));
		System.out.println(id);
//		List<Build> buildList= bs.getAllBuildsForUser(id);
		List<BuildWithNames> buildList = bs.getAllBuildsWithNames(id);
		if (buildList.isEmpty()) {
			// valid user, no builds
		}
		if (buildList == null) {
			// something wrong
		} else {
			ctx.json(buildList);
			ctx.status(200);
		}

	}

	public void createBuild(Context ctx) {
		int userId = Integer.parseInt(ctx.pathParam("id"));
		Build bodyAsBuild = ctx.bodyAsClass(Build.class);

		try {
			Build newBuild = bs.createBuild(userId, bodyAsBuild.getBuildName(), bodyAsBuild.getMoboId(),
					bodyAsBuild.getCpuId(), bodyAsBuild.getRamId(), bodyAsBuild.getStorageId(), bodyAsBuild.getPsuId(),
					bodyAsBuild.getCaseId(), bodyAsBuild.isHasFourRAM());
			ctx.status(201);
			ctx.json(newBuild);
		} catch (Exception e) {
			ctx.json(e);
			ctx.status(400);
		}
	}

	public void editBuild(Context ctx) {
		int userId = Integer.parseInt(ctx.pathParam("id"));
		int buildId = Integer.parseInt(ctx.pathParam("buildId"));
		Build bodyAsBuild = ctx.bodyAsClass(Build.class);
		bodyAsBuild.setUserId(userId);
		bodyAsBuild.setBuildId(buildId);

		try {
			bs.editBuild(bodyAsBuild);
			ctx.status(202);
			ctx.json(bodyAsBuild);
		} catch (Exception e) {
			ctx.json(e);
			ctx.status(400);
		}

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
