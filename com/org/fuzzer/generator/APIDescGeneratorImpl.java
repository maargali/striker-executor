package com.scb.fuzzer.generator;

import java.io.FileReader;
import java.io.IOException;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.scb.fuzzer.model.APIDescMO;

@Service
public class APIDescGeneratorImpl implements APIDescGenerator {

	public APIDescMO convertJsonToObject(String filePath) throws IOException {

		ObjectMapper mapper = new ObjectMapper();
		APIDescMO apiDescMO = null;
		try (FileReader reader = new FileReader(ClassLoader.getSystemResource(filePath).getFile())) {
			apiDescMO = mapper.readValue(reader, APIDescMO.class);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return apiDescMO;
	}
}
