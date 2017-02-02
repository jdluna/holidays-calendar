package com.cgr.api.facade.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cgr.api.assembler.HolidayResourceAssembler;
import com.cgr.api.facade.HolidayFacade;
import com.cgr.api.resource.HolidayResource;
import com.cgr.data.model.HolidayModel;
import com.cgr.service.HolidayService;

@Component
public class HolidayFacadeImpl implements HolidayFacade {

	@Autowired
	private HolidayService service;

	@Autowired
	private HolidayResourceAssembler assembler;

	@Override
	public List<HolidayResource> findByLocale(String idLocale) {
		List<HolidayModel> holidays = service.findByLocale(idLocale);
		return assembler.toResources(holidays);
	}

	@Override
	public HolidayResource save(HolidayResource resource, String idLocale) {
		HolidayModel holiday = assembler.toModel(resource);
		holiday = service.save(holiday, idLocale);
		return assembler.toResource(holiday);
	}

}
