package com.github.virgo47.enumconv._4toomuch;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

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

	protected abstract Class<X> enumClass();

	@Override
	public X convertToEntityAttribute(Y dbValue) {
		try {
			Method method = enumClass().getMethod("fromDbValue", dbValue.getClass());
			return (X) method.invoke(null, dbValue);
		} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
			throw new IllegalArgumentException("...this really doesn't make sense", e);
		}
	}
}
