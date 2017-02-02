package com.cgr.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cgr.api.facade.HolidayFacade;
import com.cgr.api.resource.HolidayResource;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/holidays")
@Api("/holidays")
public class HolidayRestConroller {

	@Autowired
	private HolidayFacade facade;

	@ApiOperation(value = "Holidays list - find by locale.")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<HolidayResource>> get(@RequestParam String idLocale) {
		return ResponseEntity.ok().body(facade.findByLocale(idLocale));
	}

	@ApiOperation(value = "Add holiday for locale.")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<HolidayResource> add(@RequestBody HolidayResource holidayResource,
			@RequestParam String idLocale) {
		return ResponseEntity.ok().body(facade.save(holidayResource, idLocale));
	}

}
