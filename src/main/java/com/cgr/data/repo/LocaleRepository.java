package com.cgr.data.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cgr.data.model.LocaleModel;

public interface LocaleRepository extends MongoRepository<LocaleModel, String> {

	List<LocaleModel> findByLocales(LocaleModel parent);

}