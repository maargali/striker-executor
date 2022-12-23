package com.scb.fuzzer.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.scb.fuzzer.factory.APIIterationFactory;
import com.scb.fuzzer.factory.APIRestType;
import com.scb.fuzzer.factory.Iteration;
import com.scb.fuzzer.generator.APIDescGenerator;
import com.scb.fuzzer.generator.Generator;
import com.scb.fuzzer.mapper.FuzzerMapper;
import com.scb.fuzzer.model.APIDescMO;
import com.scb.fuzzer.model.APIReqDataMO;

@Service
public class FuzzerRestImpl implements FuzzerRest {

	@Autowired
	private APIDescGenerator apiDescGenerator;

	@Autowired
	private APIIterationFactory apiIterationFactory;

	@Autowired
	private Generator dataGenerator;

	@Autowired
	private FuzzerMapper fuzzMapper;

	
	@Override
	public void getService(String filePath) throws IOException {

		APIDescMO apiDescMO = apiDescGenerator.convertJsonToObject(filePath);

		APIReqDataMO apiReqDataMO = fuzzMapper.mapApiDescMOToAPIReqMO(apiDescMO, new APIReqDataMO());
		Iteration getIteration = apiIterationFactory.getAPIIterationBean(apiReqDataMO.getRequestType());

		getIteration.specIterate(apiDescMO,5);
		getIteration.randomIterate(apiDescMO,5);

	}

	@Override
	public void postService(String filePath) throws IOException {

		APIDescMO apiDescMO = apiDescGenerator.convertJsonToObject(filePath);

		
		Iteration postIteration = apiIterationFactory.getAPIIterationBean(APIRestType.fromString(apiDescMO.getRequestType()));

		postIteration.specIterate(apiDescMO, 5);
		postIteration.randomIterate(apiDescMO,5);
	}

}
