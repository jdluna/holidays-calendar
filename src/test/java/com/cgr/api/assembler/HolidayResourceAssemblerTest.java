package com.cgr.api.assembler;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.cgr.api.resource.HolidayResource;
import com.cgr.data.model.HolidayModel;
import com.cgr.service.HolidayServiceTest;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HolidayResourceAssemblerTest {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Autowired
	private HolidayResourceAssembler assembler;

	@Test
	public void t01toModel() {
		HolidayModel expected = mongoTemplate.getConverter().read(HolidayModel.class,
				(DBObject) JSON.parse(HolidayServiceTest.jsonHoliday));
		HolidayResource resource = mongoTemplate.getConverter().read(HolidayResource.class,
				(DBObject) JSON.parse(HolidayServiceTest.jsonHoliday));
		HolidayModel actual = assembler.toModel(resource);
		assertEquals(expected, actual);
	}

	@Test
	public void t02toResource() {
		HolidayResource expected = mongoTemplate.getConverter().read(HolidayResource.class,
				(DBObject) JSON.parse(HolidayServiceTest.jsonHoliday));
		HolidayModel model = mongoTemplate.getConverter().read(HolidayModel.class,
				(DBObject) JSON.parse(HolidayServiceTest.jsonHoliday));
		HolidayResource actual = assembler.toResource(model);
		assertEquals(expected, actual);
	}

	@Test
	public void t03toResources() {
		HolidayResource expected = mongoTemplate.getConverter().read(HolidayResource.class,
				(DBObject) JSON.parse(HolidayServiceTest.jsonHoliday));
		HolidayModel model = mongoTemplate.getConverter().read(HolidayModel.class,
				(DBObject) JSON.parse(HolidayServiceTest.jsonHoliday));
		ArrayList<HolidayModel> arrayList = new ArrayList<HolidayModel>(1);
		arrayList.add(model);
		HolidayResource actual = assembler.toResources(arrayList).get(0);
		assertEquals(expected, actual);
	}

}