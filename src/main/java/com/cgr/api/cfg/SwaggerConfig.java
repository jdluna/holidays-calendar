package com.cgr.api.cfg;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.annotations.ApiOperation;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		// @formatter:off
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)).paths(PathSelectors.any())
				.build().apiInfo(apiInfo());
		// @formatter:on
	}

	private ApiInfo apiInfo() {
		String title = "Calendar";
		String description = "Holidays by County, State and Country.";
		String version = "0.0.1";
		String termsOfServiceUrl = "";
		String name = "iWorks";
		String url = "";
		String email = "";
		Contact contact = new Contact(name, url, email);
		String license = "";
		String licenseUrl = "";
		ApiInfo apiInfo = new ApiInfo(title, description, version, termsOfServiceUrl, contact, license, licenseUrl);
		return apiInfo;
	}
}