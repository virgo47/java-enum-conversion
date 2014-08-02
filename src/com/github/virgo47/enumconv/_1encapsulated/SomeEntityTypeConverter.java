package com.github.virgo47.enumconv._1encapsulated;

import javax.persistence.AttributeConverter;

public class SomeEntityTypeConverter implements AttributeConverter<SomeEntityType, Integer> {
	@Override
	public Integer convertToDatabaseColumn(SomeEntityType someEntityType) {
		return someEntityType.toDbValue();
	}

	@Override
	public SomeEntityType convertToEntityAttribute(Integer dbValue) {
		// this can still return null unless it throws IllegalArgumentException
		// which would be in line with enums static valueOf method
		return SomeEntityType.fromDbValue(dbValue);
	}
}
