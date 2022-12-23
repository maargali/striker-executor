package com.scb.fuzzer.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.scb.fuzzer.generator.URIGenerator;
import com.scb.fuzzer.model.APIReqDataMO;
import com.scb.fuzzer.model.APIResponseMO;

@Service
public class GetAPIRestCall implements APIRestCall {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public APIResponseMO callRestAPI(APIReqDataMO apiModel) {
		String apiURL = URIGenerator.getAPIURL(apiModel);
		ResponseEntity<String> httpRes = restTemplate.getForEntity(apiURL, String.class);
		return new APIResponseMO(httpRes);
	}
}
