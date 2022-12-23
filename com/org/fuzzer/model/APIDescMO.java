package com.scb.fuzzer.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class APIDescMO {

	@JsonProperty("uri")
	private String requestURI;

	@JsonProperty("reqtype")
	private String requestType;

	@JsonProperty("paramtype")
	private String paramType;

	@JsonProperty("data")
	private Object data;
	
	private int iteration;
	
	public int getIteration() {
		return iteration;
	}

	public void setIteration(int iteration) {
		this.iteration = iteration;
	}

	public String getRequestURI() {
		return requestURI;
	}

	public void setRequestURI(String requestURI) {
		this.requestURI = requestURI;
	}

	public String getRequestType() {
		return requestType;
	}

	public void setRequestType(String requestType) {
		this.requestType = requestType;
	}

	public String getParamType() {
		return paramType;
	}

	public void setParamType(String paramType) {
		this.paramType = paramType;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return " uri - " + requestURI + " request type - " + requestType + "  param type - " + paramType + " data - "
				+ data;
	}

}
