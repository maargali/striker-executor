package com.scb.fuzzer.util;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class DoubleRandoms implements Randoms {


	@Override
	public Object gererateRandoms() {
		Random rand = new Random();
		// Generate random double
		double genDouble = rand.nextDouble();
		return genDouble;
	}

}
