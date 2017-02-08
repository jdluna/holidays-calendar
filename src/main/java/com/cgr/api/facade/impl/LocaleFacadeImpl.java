package com.cgr.api.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cgr.api.assembler.LocaleResourceAssembler;
import com.cgr.api.facade.LocaleFacade;
import com.cgr.api.resource.LocaleResource;
import com.cgr.data.model.LocaleModel;
import com.cgr.data.model.LocaleType;
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

	@Override
	public List<LocaleResource> getByType(LocaleType localeType, int page, Integer pageSize) {
		return assembler.toResources(service.findByLocaleType(localeType, page, pageSize));
	}

	@Override
	public List<LocaleResource> delete(List<LocaleResource> locales) {
		List<LocaleModel> models = assembler.toModels(locales);
		return assembler.toResources(service.delete(models));
	}

}