package com.sclass.controllers;

import com.sclass.models.User;
import com.sclass.services.UserService;

import io.javalin.http.Context;

public class UserController {

	private static UserService us;

	public UserController(UserService us) {
		UserController.us = us; //this way because it's static
	}

	public void loginUser(Context ctx) {
		User u = ctx.bodyAsClass(User.class);

		User loggedIn = us.login(u.getUsername(), u.getPass());

		if (loggedIn != null) {
			ctx.json(loggedIn);
			ctx.status(200);
		}

		else {
			ctx.status(404);
		}

	}

	public void createAccount(Context ctx) {
		User u = ctx.bodyAsClass(User.class);
		try { 

			User newU = us.createUserAccount(u.getUsername(), u.getPass());

			if (newU != null) {
				ctx.json(newU);
				ctx.status(200);
			}
			else {
				ctx.status(404);
			}
		}
		catch(Exception e) {
			ctx.json(e);
			ctx.status(400);
		}

	}

}//file
