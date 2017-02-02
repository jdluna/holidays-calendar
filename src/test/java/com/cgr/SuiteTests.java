package com.cgr;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.cgr.api.HolidayRestControllerTest;
import com.cgr.api.LocaleRestControllerTest;
import com.cgr.api.assembler.HolidayResourceAssemblerTest;
import com.cgr.api.assembler.LocaleResourceAssemblerTest;
import com.cgr.api.facade.HolidayFacadeTest;
import com.cgr.api.facade.LocaleFacadeTest;
import com.cgr.doc.repo.LocaleRepoTest;
import com.cgr.service.HolidayServiceTest;
import com.cgr.service.LocaleServiceTest;

//@RunWith(ClasspathSuite.class)
//@ClassnameFilters(value = {".*Test"})
@RunWith(Suite.class)
@SuiteClasses(value = { ApplicationTests.class, LocaleRepoTest.class, HolidayServiceTest.class, LocaleServiceTest.class,
		HolidayResourceAssemblerTest.class, LocaleResourceAssemblerTest.class, HolidayFacadeTest.class,
		LocaleFacadeTest.class, LocaleRestControllerTest.class, HolidayRestControllerTest.class })
public class SuiteTests {

}