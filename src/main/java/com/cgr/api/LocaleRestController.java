package com.cgr.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cgr.api.facade.LocaleFacade;
import com.cgr.api.resource.LocaleResource;
import com.cgr.data.model.LocaleType;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/locales")
public class LocaleRestController {

	@Autowired
	private LocaleFacade facade;

	@ApiOperation(value = "Add/Update locale.")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<LocaleResource> add(@RequestBody LocaleResource localeResource) {
		return ResponseEntity.ok().body(facade.save(localeResource));
	}
	
	@ApiOperation(value = "Consult locale.")
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<LocaleResource> get(@PathVariable(value = "id") String id) {
		return ResponseEntity.ok().body(facade.findOne(id));
	}

	@ApiOperation(value = "Locale types.", produces = "application/json")
	@RequestMapping(value = "/types", method = RequestMethod.GET)
	public LocaleType[] types() {
		return LocaleType.values();
	}
	
}