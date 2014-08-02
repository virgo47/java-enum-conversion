package com.github.virgo47.enumconv._1encapsulated;

import java.util.HashMap;
import java.util.Map;

public enum SomeEntityType {
	NORMAL(0),
	SPECIAL(1);

	// ENUM -> DB VALUE CONVERSION
	// first part is easy and most programmers get here
	// fields are not final implicitly, but we better make them
	private final Integer dbValue;

	private SomeEntityType(Integer dbValue) {
		this.dbValue = dbValue;
	}

	public Integer toDbValue() {
		return dbValue;
	}

	// DB VALUE -> ENUM CONVERSION
	// static reverse resolving:
	public static final Map<Integer, SomeEntityType> dbValues = new HashMap<>();

	static {
		for (SomeEntityType value : values()) {
			dbValues.put(value.dbValue, value);
		}
	}

	public static SomeEntityType fromDbValue(Integer dbValue) {
		// this returns null for invalid value, check for null and throw exception if you need it
		return dbValues.get(dbValue);
	}
}