package com.scb.fuzzer.mapper;

import org.springframework.stereotype.Component;

import com.scb.fuzzer.factory.APIRestType;
import com.scb.fuzzer.generator.ParamType;
import com.scb.fuzzer.model.APIDescMO;
import com.scb.fuzzer.model.APIReqDataMO;

@Component
public class FuzzerMapper {

	public APIReqDataMO mapApiDescMOToAPIReqMO(APIDescMO apiDescMO, APIReqDataMO apiReqDataMO) {
		apiReqDataMO.setRestAPIURL(apiDescMO.getRequestURI());
		apiReqDataMO.setRequestType(APIRestType.fromString(apiDescMO.getRequestType()));
		apiReqDataMO.setIteration(apiDescMO.getIteration());
		if(apiDescMO.getParamType().equalsIgnoreCase("1") || apiDescMO.getParamType().equalsIgnoreCase("2") ) {
			apiReqDataMO.setParamType(ParamType.fromString(apiDescMO.getParamType()));
		}
		return apiReqDataMO;
	}
}
