package com.scb.fuzzer.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class APIRequestTypeFactory {

	@Autowired
	@Qualifier("getAPIRestCall")
	private APIRestCall getAPIRestCall;

	@Autowired
	@Qualifier("postAPIRestCall")
	private APIRestCall postAPIRestCall;

	public APIRestCall createAPIRestCallBean(APIRestType apiRestType) {

		if (apiRestType.getValue() == 0)
			return null;

		switch (apiRestType.getValue()) {
		case 1:
			return getAPIRestCall;
		case 2:
			return postAPIRestCall;
		default:
			throw new IllegalArgumentException("Unknown api rest bean type -  " + apiRestType);
		}
	}
}
