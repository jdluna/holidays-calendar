package com.cgr.api.facade;

import java.util.List;

import com.cgr.api.resource.LocaleResource;
import com.cgr.data.model.LocaleType;

public interface LocaleFacade {
	public LocaleResource findOne(String id);

	public LocaleResource save(LocaleResource resource);

	public List<LocaleResource> getByType(LocaleType localeType, int page, Integer pageSize);

	public List<LocaleResource> delete(List<LocaleResource> locales);

}