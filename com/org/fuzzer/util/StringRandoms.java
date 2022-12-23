package com.scb.fuzzer.util;

import java.util.Random;

import org.springframework.stereotype.Component;

/**
 * generates random string values with specified <i>limits</i>
 * 
 * @author 1633686
 *
 */
@Component
public class StringRandoms implements Randoms {

	/**
	 * generates string random values with length value set = 10
	 */
	@Override
	public Object gererateRandoms() {
		int leftLimit = 48; // numeral '0'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 10;
		Random random = new Random();

		String generatedString = random.ints(leftLimit, rightLimit + 1)
				.filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97)).limit(targetStringLength)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
		return generatedString;
	}

}
