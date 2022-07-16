package com.sclass.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.sclass.models.Part;
import com.sclass.services.PartService;

import io.javalin.http.Context;

public class PartController {

	private PartService partService;
	private static Logger log = LogManager.getLogger(PartController.class);

	public PartController(PartService partService) {
		this.partService = partService;
	}

	public void getAllParts(Context ctx) {
		log.info("HTTP GET Request received at endpoint /search");
		String priceFloor = ctx.queryParam("priceFloor");
		String priceCeiling = ctx.queryParam("priceCeiling");
		List<Part> parts;
		
		try {
			if (priceFloor == null || priceCeiling == null) { //should this be and? a 0-check?
				log.info("Request is to get all parts");
				parts = partService.getAllParts();
			} else {
				log.info("Request is to get parts within " + priceFloor + " and " + priceCeiling);
				parts = partService.getAllPartsWithParams(Double.parseDouble(priceFloor),
						Double.parseDouble(priceCeiling));
			}
			log.info("Successfully got requested parts");
			ctx.status(200);
			ctx.json(parts);
		} catch (Exception e) {
			log.error(e.getMessage());
			ctx.json(e);
			ctx.status(404);
		}
	}

	public void getPartById(Context ctx) {
		int partId = Integer.parseInt(ctx.pathParam("partId"));
		log.info("HTTP GET Request received at endpoint /search/" + partId);
		
		try {
			log.info("Successfully got part with id " + partId);
			ctx.status(200);
			ctx.json(partService.getPartById(partId));
		} catch (Exception e) {
			log.error(e.getMessage());
			ctx.json(e);
			ctx.status(404);
		}
	}

//	public void getPartsByType(Context ctx) {
//		Part.partType partType = String.valueOf(ctx.pathParam("partType"));
//		Part part = partService.getPartsByType();
//
//	}

}
