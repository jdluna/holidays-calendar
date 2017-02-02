package com.cgr.service;

import java.util.List;

import com.cgr.data.model.LocaleModel;

public interface LocaleService {

	public LocaleModel save(LocaleModel model);

	public LocaleModel findOne(String id);

	public List<LocaleModel> findByLocales(LocaleModel parent);

}