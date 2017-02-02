package com.cgr.data.model;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import lombok.Data;

@Data
public class HolidayModel {

	public HolidayModel(Integer day, Integer month, Integer year, String description) {
		this.day = day;
		this.month = month;
		this.year = year;
		this.description = description;
	}

	@NotNull
	private Integer day;

	@NotNull
	private Integer month;

	private Integer year;
	
	@NotEmpty
	private String description;

}