package com.scb.fuzzer.factory;

import org.springframework.stereotype.Component;

import com.scb.fuzzer.model.APIDescMO;

@Component
public interface Iteration {

	 public void specIterate(APIDescMO apiDescMO, int noOfIteration);
	 
	 public void randomIterate(APIDescMO apiDescMO, int noOfIteration);
}
