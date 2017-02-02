package com.cgr.api.resource;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
public class HolidayResource {

	private Integer day;
	private Integer month;
	private Integer year;
	private String description;

}