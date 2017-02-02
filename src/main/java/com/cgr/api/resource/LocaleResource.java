package com.cgr.api.resource;

import java.util.LinkedList;
import java.util.List;

import com.cgr.data.model.LocaleType;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LocaleResource {

	private String id;
	private String name;
	private LocaleType type;
	private List<LocaleResource> locales;
	private List<HolidayResource> holidays;

	@JsonFormat(shape = JsonFormat.Shape.OBJECT)
    public void setType(LocaleType type) {
        this.type = type;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    public LocaleType getType() {
        return type;
    }
	
	public List<LocaleResource> getLocales() {
		if (locales == null) {
			locales = new LinkedList<LocaleResource>();
		}
		return locales;
	}

	public List<HolidayResource> getHolidays() {
		if (holidays == null) {
			holidays = new LinkedList<HolidayResource>();
		}
		return holidays;
	}

}