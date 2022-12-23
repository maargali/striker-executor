package com.scb.fuzzer.model;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class APIResponseMO {

	private HttpStatus statusCode;

	private String status;

	private ResponseEntity<String> entity;

	/**
	 * default constructor
	 */
	public APIResponseMO() {

	}

	/**
	 * Constructor takes response entity and sets it param values.
	 * 
	 * @param entity
	 */
	public APIResponseMO(ResponseEntity<String> entity) {
		this.statusCode = entity.getStatusCode();
		this.status = entity.getStatusCode().name();
	}

	public ResponseEntity<String> getEntity() {
		return entity;
	}

	public void setEntity(ResponseEntity<String> entity) {
		this.entity = entity;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
