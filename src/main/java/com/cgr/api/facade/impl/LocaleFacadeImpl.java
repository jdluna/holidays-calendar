package com.cgr.api.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cgr.api.assembler.LocaleResourceAssembler;
import com.cgr.api.facade.LocaleFacade;
import com.cgr.api.resource.LocaleResource;
import com.cgr.data.model.LocaleModel;
import com.cgr.service.LocaleService;

@Component
public class LocaleFacadeImpl implements LocaleFacade {

	@Autowired
	private LocaleService service;

	@Autowired
	private LocaleResourceAssembler assembler;

	@Override
	public LocaleResource findOne(String id) {
		LocaleModel model = service.findOne(id);
		LocaleResource resource = assembler.toResource(model);
		return resource;
	}

	@Override
	public LocaleResource save(LocaleResource resource) {
		LocaleModel model = assembler.toModel(resource);
		model = service.save(model);
		return assembler.toResource(model);
	}

}
