package com.cgr.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	
	public ResourceNotFoundException(String string) {
		super(string);
	}

	private static final long serialVersionUID = -9205120741464578877L;

}
