package com.scb.fuzzer.util;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class IntegerRandoms implements Randoms {

	private int size = 1000;

	private int iterationSize;

	public int getIterationSize() {
		return iterationSize;
	}

	public IntegerRandoms(Builder builder) {
		this.iterationSize = builder.iterationSize;
	}

	@Override
	public Integer[] gererateRandoms() {
		Integer[] randomNumbers = new Integer[iterationSize];
		Random rand = new Random();
		// get base no by dividing size by iteration size
		int baseNumber = size / iterationSize;
		int min = -1 * baseNumber;
		int max = 0;
		for (int count = 0; count < iterationSize; count++) {
			// Generate random integers in range 0 to size specified eg:- 1000, 10000 etc
			// min and max size is calculated based on basenumber above, within min & max
			// range, random numbers
			// are generated, including one negative integer
			int genInteger = rand.nextInt((max - min) + 1) + min;
			randomNumbers[count] = genInteger;
			min = max;
			max = max + baseNumber;
		}

		return randomNumbers;
	}

	/**
	 * to access integerrandoms parameters
	 * @author 1633686
	 *
	 */
	public static class Builder {
		private int iterationSize;

		public Builder(int iterationSize) {
			this.iterationSize = iterationSize;
		}

		public IntegerRandoms build() {
			return new IntegerRandoms(this);
		}
	}
}
