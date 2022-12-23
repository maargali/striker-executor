package com.scb.fuzzer.factory;

import java.util.LinkedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.scb.fuzzer.generator.URIGenerator;
import com.scb.fuzzer.model.APIReqDataMO;
import com.scb.fuzzer.model.APIResponseMO;

@Service
public class PostAPIRestCall implements APIRestCall {

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public APIResponseMO callRestAPI(APIReqDataMO apiReqDataMO) {
		String apiURL = URIGenerator.getAPIURL(apiReqDataMO);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
		LinkedHashMap<Object, Object> map = (LinkedHashMap<Object, Object>) apiReqDataMO.getRequestObject();
		APIResponseMO apiResponseMO = new APIResponseMO();
		HttpEntity<LinkedHashMap<Object, Object>> request = new HttpEntity<LinkedHashMap<Object, Object>>(map, headers);
		ResponseEntity<String> httpRes = restTemplate.postForEntity(apiURL, request, String.class);
		apiResponseMO.setStatus(httpRes.getStatusCode().name());
		apiResponseMO.setStatusCode(httpRes.getStatusCode());
		return apiResponseMO;
	}

}
