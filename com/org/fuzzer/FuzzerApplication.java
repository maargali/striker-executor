package com.scb.fuzzer.util;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class IntegerRandoms implements Randoms {

	private int size = 1000;

	@Override
	public Object gererateRandoms() {
		Random rand = new Random();
		// Generate random integers in range 0 to size value
		int genInteger = rand.nextInt(size);
		return genInteger;
	}
	
	public static class Builder {
		private int randomSize;

		public int getRandomSize() {
			return randomSize;
		}

		public void setRandomSize(int randomSize) {
			this.randomSize = randomSize;
		}
		
		
	}
}
