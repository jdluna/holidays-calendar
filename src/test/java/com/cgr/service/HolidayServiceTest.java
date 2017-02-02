package com.cgr.service;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.cgr.data.model.HolidayModel;
import com.cgr.data.model.LocaleModel;
import com.cgr.doc.repo.LocaleRepoTest;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HolidayServiceTest {

	public static final String jsonHoliday = "{\"day\": 0,\"description\": \"0\",\"month\": 0,\"year\": null}";

	@Autowired
	private HolidayService service;

	@Autowired
	private LocaleService localeService;
	
	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	public void t01shouldSave() {
		saveLocaleBR();
		HolidayModel answer = mongoTemplate.getConverter().read(HolidayModel.class, (DBObject) JSON.parse(jsonHoliday));
		HolidayModel save = service.save(answer, "BR");
		assertEquals(answer, save);
	}

	@Test
	public void t02shouldFindOne() {
		HolidayModel answer = mongoTemplate.getConverter().read(HolidayModel.class, (DBObject) JSON.parse(jsonHoliday));
		String idLocale = "BR";
		HolidayModel find = service.findByLocale(idLocale).get(0);
		assertEquals(answer, find);
	}

	private void saveLocaleBR() {
		localeService.save(
				mongoTemplate.getConverter().read(LocaleModel.class, (DBObject) JSON.parse(LocaleRepoTest.jsonBR)));
	}
	
}