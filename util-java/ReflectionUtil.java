package com.chngenesis.nebula.util;

import java.lang.reflect.Field;

/**
 * 反射工具类
 * @author Administrator
 *
 */
public class ReflectionUtil {
	@SuppressWarnings("rawtypes")
	public static boolean haveField(Class clazz,String fieldName) {
		Field[] declaredFields = clazz.getDeclaredFields();
		for (Field field : declaredFields) {
			if(field.getName().equals(fieldName.trim())){
				return true;
			}
		}
		return false;
	}
}
