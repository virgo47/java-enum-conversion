package com.github.virgo47.enumconv._0naive;

import javax.persistence.AttributeConverter;

/**
 * This is coupled too much to enum and you always have to change both classes in tandem.
 * That's a big STOP (and think) sign in any case.
 */
public class SomeEntityTypeConverter implements AttributeConverter<SomeEntityType, Integer> {

	@Override
	public Integer convertToDatabaseColumn(SomeEntityType someEntityType) {
		switch (someEntityType) {
			case NORMAL:
				return 0;
			case SPECIAL:
				return 1;
			default:
				// do we need this? if for nothing else it catches forgotten case when enum is modified
				throw new IllegalArgumentException("Invalid value " + someEntityType);
				// actually the value is valid, just this externalized switch sucks of course
		}
	}

	@Override
	public SomeEntityType convertToEntityAttribute(Integer dbValue) {
		switch (dbValue) {
			case 0:
				return SomeEntityType.NORMAL;
			case 1:
				return SomeEntityType.SPECIAL;
		}
		// now what? probably exception would be better just to warn programmer
		// but if it happens in production, it doesn't really matter if it's here or NPE later
		return null;
	}
}
