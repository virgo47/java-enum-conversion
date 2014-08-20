package com.github.virgo47.enumconv._5java8function;

/**
 * Now we don't need to implement any interface for the sake of conversion/reverse resolving itself.
 */
public enum SomeEntityType {
	NORMAL(0, "norm"),
	SPECIAL(1, "spec");

	private final Integer dbValue;
	private final String strValue;

	private SomeEntityType(Integer dbValue, String strValue) {
		this.dbValue = dbValue;
		this.strValue = strValue;
	}

	public Integer getDbValue() {
		return dbValue;
	}

	public String getStrValue() {
		return strValue;
	}

	// static resolving for DB values
	public static final ReverseEnumResolver<SomeEntityType, Integer> dbValueResolver =
		new ReverseEnumResolver<>(SomeEntityType.class, SomeEntityType::getDbValue);

	public static SomeEntityType fromDbValue(Integer dbValue) {
		return dbValueResolver.get(dbValue);
	}

	// static resolving for String values
	public static final ReverseEnumResolver<SomeEntityType, String> strResolver =
		new ReverseEnumResolver<>(SomeEntityType.class, SomeEntityType::getStrValue);

	public static SomeEntityType fromStrValue(String value) {
		return strResolver.get(value);
	}
}

