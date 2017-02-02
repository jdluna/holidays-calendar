package com.cgr.api.facade;

import java.util.List;

import com.cgr.api.resource.HolidayResource;

public interface HolidayFacade {

	List<HolidayResource> findByLocale(String idLocale);

	HolidayResource save(HolidayResource holidayResource, String idLocale);

}
