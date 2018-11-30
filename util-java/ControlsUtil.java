package com.chngenesis.nebula.util;

import java.lang.reflect.Field;
import java.util.Map;

public class ControlsUtil {
	
	/**
	 * 控件查询结果，与实体匹配赋值
	 * @param obj 	实体
	 * @param map	map 值
	 * @return
	 */
	public static Object setObjectField(Object obj, Map<String, Object> map) {
		try {
			Field[] fields = obj.getClass().getDeclaredFields();
			for (Field field : fields) {
				for (String key : map.keySet()) {
					if (field.getName().equals(key)) {
						field.setAccessible(true);
						field.set(obj, map.get(key));
					}
				}
			}
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return obj;
	}

}
