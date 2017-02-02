package com.cgr.service.impl;

import java.text.DecimalFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgr.data.model.HolidayModel;
import com.cgr.data.model.LocaleModel;
import com.cgr.data.repo.LocaleRepository;
import com.cgr.exceptions.ResourceNotFoundException;
import com.cgr.service.HolidayService;

@Service
public class HolidayServiceImpl implements HolidayService {

	@Autowired
	private LocaleRepository repo;

	@Override
	public HolidayModel save(HolidayModel holiday, String id) {
		LocaleModel locale = repo.findOne(id);
		if (locale == null) {
			throw new ResourceNotFoundException("idLocale not found.");
		}
		locale.getHolidays().add(holiday);
		LocaleModel save = repo.save(locale);
		return save.getHolidays().contains(holiday) ? holiday : null;
	}

	@Override
	public List<HolidayModel> findByLocale(String id) {
		LocaleModel orgao = repo.findOne(id);
		List<HolidayModel> holidays = getHolidays(orgao);
		holidays.sort((o1, o2) -> {
			String f1 = df.format(o1.getMonth()).concat(df.format(o1.getDay()));
			String f2 = df.format(o2.getMonth()).concat(df.format(o2.getDay()));
			return f1.compareTo(f2);
		});
		return holidays;
	}

	private List<HolidayModel> getHolidays(LocaleModel locale) {
		List<HolidayModel> holidays = locale.getHolidays();
		List<LocaleModel> locales = locale.getLocales();
		if (locales != null) {
			for (LocaleModel locale2 : locales) {
				holidays.addAll(getHolidays(locale2));
			}
		}
		return holidays;
	}

	private DecimalFormat df = new DecimalFormat("00");

}