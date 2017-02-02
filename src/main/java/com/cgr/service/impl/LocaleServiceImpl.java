package com.cgr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgr.data.model.LocaleModel;
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
	
}