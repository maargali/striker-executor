package com.scb.fuzzer.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

@Service
public interface FuzzerRest {


	public void getService(String filePath) throws IOException ;

	public void postService(String filePath) throws IOException;
}
