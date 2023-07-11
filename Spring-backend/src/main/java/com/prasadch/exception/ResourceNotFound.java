package com.prasadch.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ResourceNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String resource;
	private String fieldname;
	private Object fieldvalue;

	public ResourceNotFound(String resource, String fieldname, Object fieldvalue) {
		super(String.format("%s not found with %s :'%s'", resource, fieldname, fieldvalue));
		this.resource = resource;
		this.fieldname = fieldname;
		this.fieldvalue = fieldvalue;
	}

	public String getResource() {
		return resource;
	}

	public String getFieldname() {
		return fieldname;
	}

	public Object getFieldvalue() {
		return fieldvalue;
	}

}
