package com.scb.fuzzer.factory;

import org.springframework.stereotype.Service;

import com.scb.fuzzer.handler.FuzzerException;
import com.scb.fuzzer.model.APIReqDataMO;
import com.scb.fuzzer.model.APIResponseMO;

@Service
public interface APIRestCall {

	public APIResponseMO callRestAPI(APIReqDataMO apiModel) throws FuzzerException;

}
