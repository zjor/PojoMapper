package me.zjor.mapper;

import me.zjor.annotations.Key;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author: Sergey Royz
 * Date: 11.12.2013
 */
public class Mapper {

	public static <T> T fromMap(Map<String, Object> map, Class<T> clazz) throws IllegalAccessException, InstantiationException {

		T obj = clazz.newInstance();
		for (Field field: clazz.getDeclaredFields()) {
			Key annotation = field.getAnnotation(Key.class);
			if (annotation != null) {
				Object value = map.get(annotation.value());
				if (value != null) {
					field.setAccessible(true);
					field.set(obj, value);
				}
			}
		}
		return obj;
	}

	public static Map<String, Object> toMap(Object obj) throws IllegalAccessException {
		Map<String, Object> map = new HashMap<String, Object>();
		for (Field field: obj.getClass().getDeclaredFields()) {
			Key annotation = field.getAnnotation(Key.class);
			if (annotation != null) {
				field.setAccessible(true);
				Object value = field.get(obj);
				map.put(annotation.value(), value);
			}
		}
		return map;
	}

}
