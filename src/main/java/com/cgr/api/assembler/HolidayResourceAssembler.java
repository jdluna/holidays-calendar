package com.cgr.api.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cgr.api.resource.HolidayResource;
import com.cgr.data.model.HolidayModel;
import com.cgr.exceptions.ResourceNotFoundException;

@Component
public class HolidayResourceAssembler {

	public List<HolidayResource> toResources(List<HolidayModel> holidays) {
		if (holidays == null) {
			throw new ResourceNotFoundException("Holiday not found");
		}
		List<HolidayResource> resources = new ArrayList<>(holidays.size());
		for (HolidayModel holiday : holidays) {
			resources.add(toResource(holiday));
		}
		return resources;
	}

	public HolidayModel toModel(HolidayResource resource) {
		return new HolidayModel(resource.getDay(), resource.getMonth(), resource.getYear(), resource.getDescription());
	}

	public HolidayResource toResource(HolidayModel model) {
		if (model == null) {
			throw new ResourceNotFoundException("Holiday not found");
		}
		HolidayResource resource = new HolidayResource();
		resource.setDay(model.getDay());
		resource.setMonth(model.getMonth());
		resource.setYear(model.getYear());
		resource.setDescription(model.getDescription());
		return resource;
	}

}
