package com.cgr.api.facade;

import com.cgr.api.resource.LocaleResource;

public interface LocaleFacade {
	public LocaleResource findOne(String id);

	public LocaleResource save(LocaleResource resource);

}