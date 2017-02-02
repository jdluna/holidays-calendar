package com.cgr.api;

import static org.hamcrest.Matchers.hasItems;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.cgr.data.model.LocaleType;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LocaleRestControllerTest {

	public static final String jsonBR = "{ \"id\": \"BR\", \"name\": \"Brazil\", \"type\": \"COUNTRY\", \"locales\": [], \"holidays\": [ { \"day\": 0, \"description\": \"0\", \"month\": 0, \"year\": null } ] }";

	public static final String jsonSP_BR = "{ \"id\": \"SP-BR\", \"name\": \"São Paulo\", \"type\": \"STATE\", \"locales\": [ { \"id\": \"BR\", \"name\": \"Brazil\", \"type\": \"COUNTRY\", \"locales\": [], \"holidays\": [ { \"day\": 0, 	 \"description\": \"0\", \"month\": 0, \"year\": null } ] } ], \"holidays\": [ { \"day\": 1, \"description\": \"1\", \"month\": 1, \"year\": 2017 } ]}";
	
	@LocalServerPort
	private int port;
	
//	@MockBean
//	private LocaleFacadeImpl facade;
//
//	@Autowired
//	private MongoTemplate mt;
	
	@Before
	public void setup() {
		RestAssured.port = port;
	}

	@Test
	public void t01add() {
		String body = jsonBR;
//		LocaleResource resource = mt.getConverter().read(LocaleResource.class, (DBObject) JSON.parse(body));
//		BDDMockito.given(this.facade.save(resource)).willReturn(resource);
		RestAssured.given().contentType(ContentType.JSON).body(body).when().post("/locales").then().statusCode(200)
				.body("id", Matchers.equalTo("BR"));
	}

	// @RequestMapping(method = RequestMethod.GET, value = "/{id}")
	@Test
	public void t02get() {
		RestAssured.given().pathParam("id", "BR").when().get("/locales/{id}").then().statusCode(200)
		.body("id", Matchers.equalTo("BR"));
	}

	@Test
	public void t03tipos() {
		LocaleType[] types = LocaleType.values();
		String[] descriptions = new String[types.length];
		for (int i = 0; i < types.length; i++) {
			descriptions[i] = types[i].getDescription();
		}
		RestAssured.given().when().get("/locales/types").then().statusCode(200).body("$", hasItems(descriptions));
	}

}