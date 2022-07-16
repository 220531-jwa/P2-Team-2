package com.sclass;

import static io.javalin.apibuilder.ApiBuilder.get;
import static io.javalin.apibuilder.ApiBuilder.path;
import static io.javalin.apibuilder.ApiBuilder.post;
import static io.javalin.apibuilder.ApiBuilder.put;

import com.sclass.controllers.BuildController;
import com.sclass.controllers.PartController;
import com.sclass.controllers.UserController;
import com.sclass.repositories.BuildDAO;
import com.sclass.repositories.PartDAO;
import com.sclass.repositories.UserDAO;
import com.sclass.services.BuildService;
import com.sclass.services.PartService;
import com.sclass.services.UserService;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class AppDriver {

	public static void main(String[] args) {
		UserController uc = new UserController(new UserService(new UserDAO()));
		PartController pc = new PartController(new PartService(new PartDAO()));
		BuildController bc = new BuildController(new BuildService(new BuildDAO(), new PartDAO()));

		Javalin app = Javalin.create(config -> {
			config.enableCorsForAllOrigins();
			config.addStaticFiles("/public", Location.CLASSPATH);
		});
		app.start(8081);

		app.routes(() -> {
			path("/login", () -> {
				post(uc::loginUser);
			});
			path("/createAccount", () -> {
				post(uc::createAccount);
			});
			path("/users", () -> {
				path("/{id}", () -> {
					path("/builds", () -> {
						get(bc::getAllBuildsForUser);
						post(bc::createBuild);
						path("/{buildId}", () -> {
							put(bc::editBuild);
							get(bc::getSingleBuild);
						});
					});
//					path ("",()->{});
				});
			});
			path("/search", () -> {
				get(pc::getAllParts);
				path("/{partId}", () -> {
					get(pc::getPartById);
				});
			});
		});

	}
}
