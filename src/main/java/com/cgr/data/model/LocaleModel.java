package com.cgr.data.model;

import java.util.List;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = LocaleModel.COLLECTION_NAME)
public class LocaleModel {

	public static final String COLLECTION_NAME = "locales";

	@Id
	private String id;

	@NotEmpty
	private String name;

	@NotEmpty
	@Indexed
	private LocaleType type;

	@DBRef
	private List<LocaleModel> locales;

	private List<HolidayModel> holidays;

	public LocaleModel(String id, String name, LocaleType type, List<LocaleModel> locales,
			List<HolidayModel> holidays) {
		this.id = id;
		this.name = name;
		this.type = type;
		this.locales = locales;
		this.holidays = holidays;
	}

}