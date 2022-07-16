package com.sclass.controllers;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sclass.models.User;
import com.sclass.services.UserService;

import io.javalin.http.Context;

public class UserController {

	private static UserService us;
	private static Logger log = LogManager.getLogger(UserController.class);

	public UserController(UserService us) {
		UserController.us = us; //this way because it's static
	}

	public void loginUser(Context ctx) {
		User u = ctx.bodyAsClass(User.class);
		log.info("HTTP POST Request received at endpoint /login");
		User loggedIn = us.login(u.getUsername(), u.getPass());

		if (loggedIn != null) {
			log.info("Successful login for user " + u.getUsername());
			ctx.json(loggedIn);
			ctx.status(200);
		} else {
			log.error("Couldn't login user with username " + u.getUsername() + " and password " + u.getPass());
			ctx.status(404);
			ctx.result("Couldn't login user");
		}

	}

	public void createAccount(Context ctx) {
		User u = ctx.bodyAsClass(User.class);
		log.info("HTTP POST Request received at endpoint /createAccount");
		
		try { 
			User newU = us.createUserAccount(u.getUsername(), u.getPass());
			log.info("Successful created account with username " + newU.getUsername());
			ctx.json(newU);
			ctx.status(200);
		}
		catch(Exception e) {
			log.error(e.getMessage());
			ctx.json(e);
			ctx.status(400);
		}

	}
	
	

}
