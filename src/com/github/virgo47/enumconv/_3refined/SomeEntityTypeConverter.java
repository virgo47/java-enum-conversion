package com.github.virgo47.enumconv._3refined;

public class SomeEntityTypeConverter extends EnumAttributeConverter<SomeEntityType, Integer> {
	@Override
	public SomeEntityType convertToEntityAttribute(Integer integer) {
		return SomeEntityType.fromDbValue(integer);
	}
}
