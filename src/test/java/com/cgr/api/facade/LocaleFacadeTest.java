package com.cgr.api.facade;

import static org.junit.Assert.assertEquals;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import com.cgr.api.resource.LocaleResource;
import com.cgr.doc.repo.LocaleRepoTest;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@DirtiesContext(classMode=ClassMode.AFTER_CLASS)
public class LocaleFacadeTest {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private LocaleFacade facade;
	
	@Test
	public void t01save() {
		LocaleResource expected = mongoTemplate.getConverter().read(LocaleResource.class, (DBObject) JSON.parse(LocaleRepoTest.jsonBR));
		LocaleResource actual = facade.save(expected);
		assertEquals(expected, actual);
	}

	@Test
	public void t02findOne() {
		LocaleResource expected = mongoTemplate.getConverter().read(LocaleResource.class, (DBObject) JSON.parse(LocaleRepoTest.jsonBR));
		LocaleResource actual = facade.findOne("BR");
		assertEquals(expected, actual);
	}
	
}