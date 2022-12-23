package com.scb.fuzzer.generator;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.scb.fuzzer.model.APIDescMO;

@Service
public interface APIDescGenerator {

	public APIDescMO convertJsonToObject(String filePath) throws IOException;
}
