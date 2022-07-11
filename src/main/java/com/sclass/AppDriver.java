package com.sclass;


import static io.javalin.apibuilder.ApiBuilder.*;

import com.sclass.controllers.BuildController;
import com.sclass.controllers.UserController;
import com.sclass.repositories.BuildDAO;
import com.sclass.repositories.UserDAO;
import com.sclass.services.BuildService;
import com.sclass.services.UserService;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;

public class AppDriver {

	

	public static void main(String[] args) {
		UserController uc = new UserController(new UserService(new UserDAO()));
		BuildController bc = new BuildController(new BuildService(new BuildDAO()));
		
		Javalin app = Javalin.create(config -> {
			config.enableCorsForAllOrigins();
			config.addStaticFiles("/public", Location.CLASSPATH);
		});
		app.start(8081);
		
		app.routes(()->{
			path("/login", () ->{
				post(uc::loginUser);
			});
			path("/createAccount",()->{
				post(uc::createAccount);
			});
		});

	}
}
