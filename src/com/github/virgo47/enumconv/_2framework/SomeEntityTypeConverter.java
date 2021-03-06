package com.github.virgo47.enumconv._2framework;

public class SomeEntityTypeConverter extends EnumAttributeConverter<SomeEntityType, Integer> {
	@Override
	public SomeEntityType convertToEntityAttribute(Integer integer) {
		return notNull(SomeEntityType.fromDbValue(integer));
	}
}
