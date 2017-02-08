package com.cgr.service.impl;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.cgr.data.model.LocaleModel;
import com.cgr.data.model.LocaleType;
import com.cgr.data.repo.LocaleRepository;
import com.cgr.service.LocaleService;

@Service
public class LocaleServiceImpl implements LocaleService {

	@Autowired
	private LocaleRepository repo;

	@Override
	public LocaleModel findOne(String id) {
		return repo.findOne(id);
	}

	@Override
	public LocaleModel save(LocaleModel model) {
		return repo.save(model);
	}

	@Override
	public List<LocaleModel> findByLocales(LocaleModel parent) {
		return repo.findByLocales(parent);
	}

	@Override
	public List<LocaleModel> findByLocaleType(LocaleType localeType, int page, Integer size) {
		return repo.findByType(localeType, new PageRequest(page, size));
	}

	@Override
	public List<LocaleModel> delete(List<LocaleModel> models) {
		repo.delete(models);
		Iterator<LocaleModel> iterator = models.iterator();
		while (iterator.hasNext()) {
			LocaleModel model = iterator.next();
			if (repo.findOne(model.getId()) != null){
				iterator.remove();
			};
		}
		return models;
	}

}