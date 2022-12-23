package com.scb.fuzzer.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class APIIterationFactory {

	@Autowired
	@Qualifier("getAPIIteration")
	private Iteration getAPIIteration;

	@Autowired
	@Qualifier("postAPIIteration")
	private Iteration postAPIIteration;

	public Iteration getAPIIterationBean(APIRestType apiRestType) {

		if (apiRestType.getValue() == 0)
			return null;

		switch (apiRestType.getValue()) {
		case 1:
			return getAPIIteration;
		case 2:
			return postAPIIteration;
		default:
			throw new IllegalArgumentException("Unknown api rest bean type -  " + apiRestType);
		}
	}
}
