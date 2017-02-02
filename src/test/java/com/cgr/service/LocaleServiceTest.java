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

import com.cgr.data.model.LocaleModel;
import com.cgr.doc.repo.LocaleRepoTest;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocaleServiceTest {

	@Autowired
	private LocaleService service;

	@Autowired
	private MongoTemplate mongoTemplate;

	@Test
	public void t01shouldSave() {
		LocaleModel answer = mongoTemplate.getConverter().read(LocaleModel.class,
				(DBObject) JSON.parse(LocaleRepoTest.jsonSP_BR));
		saveLocaleBR();
		LocaleModel save = service.save(
				mongoTemplate.getConverter().read(LocaleModel.class, (DBObject) JSON.parse(LocaleRepoTest.jsonSP_BR)));
		assertEquals(answer, save);
	}

	private void saveLocaleBR() {
		service.save(
				mongoTemplate.getConverter().read(LocaleModel.class, (DBObject) JSON.parse(LocaleRepoTest.jsonBR)));
	}

	@Test
	public void t02shouldFindOne() {
		LocaleModel answer = mongoTemplate.getConverter().read(LocaleModel.class,
				(DBObject) JSON.parse(LocaleRepoTest.jsonSP_BR));
		LocaleModel find = service.findOne("SP-BR");
		assertEquals(answer, find);
	}

	@Test
	public void t03shouldFindByLocales() {
		LocaleModel answer = mongoTemplate.getConverter().read(LocaleModel.class,
				(DBObject) JSON.parse(LocaleRepoTest.jsonSP_BR));
		LocaleModel locale = mongoTemplate.getConverter().read(LocaleModel.class, (DBObject) JSON.parse("{_id:'BR'}"));
		LocaleModel find = service.findByLocales(locale).get(0);
		assertEquals(answer, find);
	}

}