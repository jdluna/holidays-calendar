package com.cgr;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.cgr.api.HolidayRestConroller;
import com.cgr.api.LocaleRestController;
import com.cgr.ctrl.HomeRestController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationTests {

	@Autowired
	private ApplicationContext context;

	@Test
	public void contextLoads() {
		assertNotNull(context);
		assertNotNull(context.getBean(HomeRestController.class));
		assertNotNull(context.getBean(LocaleRestController.class));
		assertNotNull(context.getBean(HolidayRestConroller.class));
	}

}
