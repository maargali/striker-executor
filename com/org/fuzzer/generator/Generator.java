package com.scb.fuzzer.generator;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.scb.fuzzer.model.APIDescMO;
import com.scb.fuzzer.model.APIReqDataMO;

@Component
public interface Generator {

	public ArrayList<APIReqDataMO> specGenerate(APIDescMO apiDescMO);
	
	public ArrayList<APIReqDataMO> specGenerateForGET(APIDescMO apiDescMO);
	
	public ArrayList<APIReqDataMO> randomGenerateForGET(APIDescMO apiDescMO);
	
	public ArrayList<APIReqDataMO> randomGenerate(APIDescMO apiDescMO);
}
