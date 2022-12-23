package com.scb.fuzzer.generator;

public enum ParamType {

	PATH(1), REQUEST(2);

	int paramType;

	ParamType(int value) {
		paramType = value;
	}

	public int getValue() {
		return paramType;
	}

	public static ParamType fromString(String text) {
		for (ParamType b : ParamType.values()) {
			if (b.paramType == Integer.valueOf(text)) {
				return b;
			}
		}
		return null;
	}
}
