package com.cgr.api.assembler;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.cgr.api.resource.LocaleResource;
import com.cgr.data.model.LocaleModel;
import com.cgr.doc.repo.LocaleRepoTest;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocaleResourceAssemblerTest {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private LocaleResourceAssembler assembler;

	@Test
	public void t01toResource() {
		LocaleResource expected = mongoTemplate.getConverter().read(LocaleResource.class, (DBObject) JSON.parse(LocaleRepoTest.jsonSP_BR));
		LocaleModel model = mongoTemplate.getConverter().read(LocaleModel.class, (DBObject) JSON.parse(LocaleRepoTest.jsonSP_BR));
		LocaleResource actual = assembler.toResource(model);
		assertEquals(expected, actual);
	}
	
	@Test
	public void t02toModel() {
		LocaleModel expected = mongoTemplate.getConverter().read(LocaleModel.class, (DBObject) JSON.parse(LocaleRepoTest.jsonSP_BR));
		LocaleResource resource = mongoTemplate.getConverter().read(LocaleResource.class, (DBObject) JSON.parse(LocaleRepoTest.jsonSP_BR));
		LocaleModel actual = assembler.toModel(resource);
		assertEquals(expected, actual);
	}

	@Test
	public void t03toResources() {
		LocaleResource expected = mongoTemplate.getConverter().read(LocaleResource.class, (DBObject) JSON.parse(LocaleRepoTest.jsonSP_BR));
		LocaleModel model = mongoTemplate.getConverter().read(LocaleModel.class, (DBObject) JSON.parse(LocaleRepoTest.jsonSP_BR));
		List<LocaleModel> models = new ArrayList<LocaleModel>(1);
		models.add(model);
		LocaleResource actual = assembler.toResources(models).get(0);
		assertEquals(expected, actual);
	}

}