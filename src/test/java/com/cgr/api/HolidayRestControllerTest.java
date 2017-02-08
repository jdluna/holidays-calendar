package com.cgr.api;

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

import com.cgr.SuiteTests;
import com.cgr.service.HolidayServiceTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HolidayRestControllerTest {

	@LocalServerPort
	private int port;

	@Before
	public void setup() {
		RestAssured.port = port;
	}

	@Test
	public void t00add() {
		String body = LocaleRestControllerTest.jsonBR;
		// LocaleResource resource =
		// mt.getConverter().read(LocaleResource.class, (DBObject)
		// JSON.parse(body));
		// BDDMockito.given(this.facade.save(resource)).willReturn(resource);
		RestAssured.given().contentType(ContentType.JSON).body(body).when().post("/locales").then().statusCode(SuiteTests.HTTP_OK)
				.body("id", Matchers.equalTo("BR"));
	}

	@Test
	public void t01add() {
		String body = HolidayServiceTest.jsonHoliday;
		RestAssured.given()
//		.queryParam("idLocale", "BR")
		.pathParam("idLocale", "BR")
		.contentType(ContentType.JSON).body(body).when()
				.put("/holidays/{idLocale}").then().statusCode(SuiteTests.HTTP_OK).body("day", Matchers.equalTo(0));
	}

	@Test
	public void t02get() {
		// @RequestParam String idLocale
		RestAssured.given()
//		.param("idLocale", "BR")
		.pathParam("idLocale", "BR")
		.when().get("/holidays/{idLocale}").then().statusCode(SuiteTests.HTTP_OK)
				.contentType(ContentType.JSON).body("[0].day", Matchers.equalTo(0));
	}
	
	@Test
	public void t03delete(){
		RestAssured.given().contentType(ContentType.JSON)
				.body("{\"id\":\"BR\", \"holidays\": [" + HolidayServiceTest.jsonHoliday + "]}").delete("/holidays").then()
				.statusCode(SuiteTests.HTTP_OK).body("$.[0].day", Matchers.equalTo(0));
	}

}