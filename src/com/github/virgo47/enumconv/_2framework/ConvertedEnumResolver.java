package com.github.virgo47.enumconv._2framework;

import java.util.HashMap;
import java.util.Map;

/**
 * Helps reverse resolving of {@link ConvertedEnum} from a DB value back to enum instance.
 * Enums that can be resolved this way must have unified interface in order to obtain
 * {@link ConvertedEnum#toDbValue()}.
 *
 * @param <T> type of an enum
 * @param <Y> type of DB value
 */
public class ConvertedEnumResolver<T extends ConvertedEnum<Y>, Y> {

	private final Map<Y, T> dbValues = new HashMap<>();

	public ConvertedEnumResolver(Class<T> enumClass) {
		for (T t : enumClass.getEnumConstants()) {
			dbValues.put(t.toDbValue(), t);
		}
	}

	public T get(Y dbValue) {
		return dbValues.get(dbValue);
	}
}
