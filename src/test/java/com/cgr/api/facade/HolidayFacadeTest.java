package com.cgr.api.facade;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.cgr.api.resource.HolidayResource;
import com.cgr.data.model.LocaleModel;
import com.cgr.doc.repo.LocaleRepoTest;
import com.cgr.service.HolidayServiceTest;
import com.cgr.service.LocaleService;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HolidayFacadeTest {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private HolidayFacade facade;

	@Autowired
	private LocaleService localeService;
	
	@Test
	public void t01save() {
		saveLocaleBR();
		HolidayResource expected = mongoTemplate.getConverter().read(HolidayResource.class,
				(DBObject) JSON.parse(HolidayServiceTest.jsonHoliday));
		String idLocale = "BR";
		HolidayResource actual = facade.save(expected, idLocale);
		assertEquals(expected, actual);
	}

	@Test
	public void t02findByLocale() {
		HolidayResource expected = mongoTemplate.getConverter().read(HolidayResource.class,
				(DBObject) JSON.parse(HolidayServiceTest.jsonHoliday));
		String idLocale = "BR";
		HolidayResource actual = facade.findByLocale(idLocale).get(0);
		assertEquals(expected, actual);
	}
	
	private void saveLocaleBR() {
		localeService.save(
				mongoTemplate.getConverter().read(LocaleModel.class, (DBObject) JSON.parse(LocaleRepoTest.jsonBR)));
	}
}