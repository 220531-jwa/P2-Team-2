package com.sclass.controllers;

import java.util.List;

import com.sclass.models.Part;
import com.sclass.services.PartService;

import io.javalin.http.Context;

public class PartController {

	private PartService partService;

	public PartController(PartService partService) {
		this.partService = partService;
	}

	public void getAllParts(Context ctx) {
		String priceFloor = ctx.queryParam("priceFloor");
		String priceCeiling = ctx.queryParam("priceCeiling");
		List<Part> parts;
		System.out.println("floor:"+priceFloor+" ceiling:"+priceCeiling);
		try {
			if (priceFloor == null || priceCeiling == null) { //should this be and? a 0-check?
				parts = partService.getAllParts();
			} else {
				parts = partService.getAllPartsWithParams(Double.parseDouble(priceFloor),
						Double.parseDouble(priceCeiling));
			}
			ctx.status(200);
			ctx.json(parts);
		} catch (Exception e) {
			e.printStackTrace();
			ctx.status(404);
			ctx.result("Parts not found");
		}
	}

	public void GetPartById(Context ctx) {
		int partId = Integer.parseInt(ctx.pathParam("partId"));
	}

}
