package com.github.virgo47.enumconv._4toomuch;

public enum SomeEntityType implements ConvertedEnum<Integer> {
	NORMAL(0),
	SPECIAL(1);

	private final Integer dbValue;

	private SomeEntityType(Integer dbValue) {
		this.dbValue = dbValue;
	}

	@Override
	public Integer toDbValue() {
		return dbValue;
	}

	// static resolving:
	public static final ConvertedEnumResolver<SomeEntityType, Integer> resolver = new ConvertedEnumResolver<>(SomeEntityType.class);

	public static SomeEntityType fromDbValue(Integer dbValue) {
		return resolver.get(dbValue);
	}
}
