package com.cgr.doc.repo;

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
import com.cgr.data.repo.LocaleRepository;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocaleRepoTest {

	@Autowired
	private LocaleRepository repo;

	@Autowired
	private MongoTemplate mongoTemplate;

	public static final String jsonBR = "{ \"_id\": \"BR\", \"name\": \"Brazil\", \"type\": \"COUNTRY\", \"locales\": [], \"holidays\": [ { \"day\": 0, \"description\": \"0\", \"month\": 0, \"year\": null } ] }";

	public static final String jsonSP_BR = "{ \"_id\": \"SP-BR\", \"name\": \"São Paulo\", \"type\": \"STATE\", \"locales\": [ { \"_id\": \"BR\", \"name\": \"Brazil\", \"type\": \"COUNTRY\", \"locales\": [], \"holidays\": [ { \"day\": 0, 	 \"description\": \"0\", \"month\": 0, \"year\": null } ] } ], \"holidays\": [ { \"day\": 1, \"description\": \"1\", \"month\": 1, \"year\": 2017 } ]}";

	@Test
	public void t01shouldSaveLocale() {
		LocaleModel answer = mongoTemplate.getConverter().read(LocaleModel.class, (DBObject) JSON.parse(jsonSP_BR));
		repo.save(mongoTemplate.getConverter().read(LocaleModel.class, (DBObject) JSON.parse(jsonBR)));
		LocaleModel save = repo
				.save(mongoTemplate.getConverter().read(LocaleModel.class, (DBObject) JSON.parse(jsonSP_BR)));
		assertEquals(answer, save);
	}

	@Test
	public void t02shouldFindByLocales() {
		LocaleModel answer = mongoTemplate.getConverter().read(LocaleModel.class, (DBObject) JSON.parse(jsonSP_BR));
		LocaleModel parent = mongoTemplate.getConverter().read(LocaleModel.class, (DBObject) JSON.parse("{_id: 'BR'}"));
		LocaleModel find = repo.findByLocales(parent).get(0);
		assertEquals(answer, find);
	}

}