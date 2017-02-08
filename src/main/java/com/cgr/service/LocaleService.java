package com.cgr.service;

import java.util.List;

import com.cgr.data.model.LocaleModel;
import com.cgr.data.model.LocaleType;

public interface LocaleService {

	public LocaleModel save(LocaleModel model);

	public LocaleModel findOne(String id);

	public List<LocaleModel> findByLocales(LocaleModel parent);

	public List<LocaleModel> findByLocaleType(LocaleType localeType, int page, Integer size);

	public List<LocaleModel> delete(List<LocaleModel> models);

}