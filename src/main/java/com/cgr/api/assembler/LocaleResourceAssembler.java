package com.cgr.api.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cgr.api.resource.HolidayResource;
import com.cgr.api.resource.LocaleResource;
import com.cgr.data.model.HolidayModel;
import com.cgr.data.model.LocaleModel;
import com.cgr.exceptions.ResourceNotFoundException;

@Component
public class LocaleResourceAssembler {

	@Autowired
	private HolidayResourceAssembler assembler;

	public LocaleResource toResource(LocaleModel model) {
		if (model == null) {
			throw new ResourceNotFoundException("Locale not found");
		}
		LocaleResource localeResource = new LocaleResource();
		localeResource.setId(model.getId());
		localeResource.setName(model.getName());
		localeResource.setType(model.getType());
		localeResource.setHolidays(assembler.toResources(model.getHolidays()));
		localeResource.setLocales(toResources(model.getLocales()));
		return localeResource;
	}

	public List<LocaleResource> toResources(List<LocaleModel> locales) {
		List<LocaleResource> resources = new ArrayList<LocaleResource>(locales.size());
		for (LocaleModel model : locales) {
			resources.add(toResource(model));
		}
		return resources;
	}

	public LocaleModel toModel(LocaleResource resource) {
		List<LocaleModel> locales = null;
		List<LocaleResource> localeResources = resource.getLocales();
		if (localeResources != null) {
			locales = new ArrayList<LocaleModel>(localeResources.size());
			for (LocaleResource localeResource : localeResources) {
				LocaleModel locale = toModel(localeResource);
				locales.add(locale);
			}
		}
		List<HolidayResource> holidayResources = resource.getHolidays();
		List<HolidayModel> holidays = null;
		if (holidayResources != null) {
			holidays = new ArrayList<HolidayModel>(holidayResources.size());
			for (HolidayResource holidayResource : holidayResources) {
				holidays.add(assembler.toModel(holidayResource));
			}
		}
		LocaleModel locale = new LocaleModel(resource.getId(), resource.getName(), resource.getType(), locales,
				holidays);
		return locale;
	}

}
