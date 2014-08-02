package com.github.virgo47.enumconv._3refined;

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
}
