package com.cgr.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

	@ApiOperation(value = "Locale types.", produces = "application/json")
	@RequestMapping(value = "/types", method = RequestMethod.GET)
	public LocaleType[] types() {
		return LocaleType.values();
	}

	@ApiOperation(value = "Add/Update locale.")
	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<LocaleResource> add(@RequestBody LocaleResource localeResource) {
		return ResponseEntity.ok().body(facade.save(localeResource));
	}

	@ApiOperation(value = "Consult locale.")
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ResponseEntity<LocaleResource> get(@PathVariable(value = "id") String id) {
		return ResponseEntity.ok().body(facade.findOne(id));
	}

	@ApiOperation(value = "Consult by Locale Type. To see available types access /locales/types.")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<LocaleResource>> getByType(
			@RequestParam(required = false, defaultValue = "COUNTRY") String type,
			@RequestParam(required = false, defaultValue = "0") int page,
			@RequestParam(required = false, defaultValue = "10") Integer pageSize) {
		return ResponseEntity.ok().body(facade.getByType(LocaleType.jsonCreate(type), page, pageSize));
	}

	@ApiOperation(value = "Delete locales.")
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<List<LocaleResource>> delete(@RequestBody List<LocaleResource> locales) {
		return ResponseEntity.ok().body(facade.delete(locales));
	}

}