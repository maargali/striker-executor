package com.scb.fuzzer.factory;

public enum APIRestType {

	GET(1), POST(2);

	int restType;

	APIRestType(int value) {
		restType = value;
	}

	public int getValue() {
		return restType;
	}

	public static APIRestType fromString(String text) {
		for (APIRestType b : APIRestType.values()) {
			if (b.restType == Integer.valueOf(text)) {
				return b;
			}
		}
		return null;
	}
}
