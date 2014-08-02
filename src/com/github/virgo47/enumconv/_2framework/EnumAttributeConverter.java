package com.github.virgo47.enumconv._2framework;

import javax.persistence.AttributeConverter;

/**
 * Base implementation for converting enums stored in DB.
 * Enums must implement {@link ConvertedEnum}.
 */
public abstract class EnumAttributeConverter<X extends ConvertedEnum<Y>, Y>
	implements AttributeConverter<X, Y>
{

	@Override
	public final Y convertToDatabaseColumn(X x) {
		return x.toDbValue();
	}

	public X notNull(X x) {
		return notNull(x, null);
	}

	public X notNull(X x, Y dbValue) {
		if (x == null) {
			throw new IllegalArgumentException("No enum constant" + (dbValue != null ? (" for DB value " + dbValue) : ""));
		}

		return x;
	}

	public X withDefault(X x, X defaultValue) {
		return x != null ? x : defaultValue;
	}
}
