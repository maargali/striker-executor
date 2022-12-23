package com.scb.fuzzer.model;

import com.scb.fuzzer.factory.APIRestType;
import com.scb.fuzzer.generator.ParamType;

public class APIReqDataMO {

	private String restAPIURL;

	private Object[] params;

	private APIRestType requestType;

	private ParamType paramType;

	private Object requestObject;
	
	private int iteration;
	
	public int getIteration() {
		return iteration;
	}

	public void setIteration(int iteration) {
		this.iteration = iteration;
	}

	public ParamType getParamType() {
		return paramType;
	}

	public void setParamType(ParamType paramType) {
		this.paramType = paramType;
	}

	public APIRestType getRequestType() {
		return requestType;
	}

	public void setRequestType(APIRestType requestType) {
		this.requestType = requestType;
	}

	public Object getRequestObject() {
		return requestObject;
	}

	public void setRequestObject(Object requestObject) {
		this.requestObject = requestObject;
	}

	public String getRestAPIURL() {
		return restAPIURL;
	}

	public void setRestAPIURL(String restAPIURL) {
		this.restAPIURL = restAPIURL;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

}
