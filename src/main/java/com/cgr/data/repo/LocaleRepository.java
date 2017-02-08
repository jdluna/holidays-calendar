package com.cgr.data.repo;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.cgr.data.model.LocaleModel;
import com.cgr.data.model.LocaleType;

public interface LocaleRepository extends MongoRepository<LocaleModel, String> {

	List<LocaleModel> findByLocales(LocaleModel parent);

	List<LocaleModel> findByType(LocaleType localeType, Pageable pageable);

}