package com.github.virgo47.enumconv._4toomuch;

import java.lang.reflect.Method;

public class SomeEntityTypeConverter extends EnumAttributeConverter<SomeEntityType, Integer> {
	@Override
	protected Class<SomeEntityType> enumClass() {
		return SomeEntityType.class;
	}

	public static void main(String[] args) throws Exception {
		SomeEntityTypeConverter converter = new SomeEntityTypeConverter();
		System.out.println("converter.convertToDatabaseColumn(SomeEntityType.NORMAL) = " + converter.convertToDatabaseColumn(SomeEntityType.NORMAL));
		System.out.println("converter.convertToEntityAttribute(0) = " + converter.convertToEntityAttribute(0));
		// throws IAE
//		System.out.println("converter.convertToEntityAttribute(2) = " + converter.convertToEntityAttribute(2));

		// throws NoSuchMethodException
//		Method method = converter.getClass().getMethod("convertToDatabaseColumn", Integer.class);
		Method method = converter.getClass().getMethod("convertToDatabaseColumn", Object.class);
		System.out.println("method = " + method);
	}
}
