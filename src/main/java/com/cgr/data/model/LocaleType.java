package com.cgr.data.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

@JsonFormat(shape = Shape.OBJECT)
public enum LocaleType {
	COUNTRY("Country"), STATE("State"), COUNTY("County");

	private String description;

	private LocaleType(String description) {
		this.description = description;
	}

	@JsonValue
	public String getDescription() {
		return this.description;
	}

	@JsonCreator
	public static LocaleType jsonCreate(String description) {
		LocaleType[] locales = LocaleType.values();
		for (LocaleType type : locales) {
			if (description != null && description.toLowerCase().contains(type.getDescription().toLowerCase())) {
				return type;
			}
		}
		return null;
	}

}
