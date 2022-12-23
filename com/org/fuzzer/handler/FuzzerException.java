package com.scb.fuzzer.handler;

import java.io.IOException;

import com.scb.fuzzer.model.APIResponseMO;

public class FuzzerException extends IOException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private APIResponseMO expModel;

	public FuzzerException(APIResponseMO model) {
		this.expModel = model;
	}
}
