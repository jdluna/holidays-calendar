package com.cgr.service;

import java.util.List;

import com.cgr.data.model.HolidayModel;

public interface HolidayService {

	public HolidayModel save(HolidayModel holiday, String id);

	public List<HolidayModel> findByLocale(String idLocale);

}
