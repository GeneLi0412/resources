package com.chngenesis.startrek.util;

import com.alibaba.fastjson.serializer.PropertyFilter;

/**
 * json相关工具类
 * 
 * @author gongliang 2017.11.22
 *
 */
public class JsonUtil {

	/**
	 * 字段排除
	 * @param fieldName 需要排除的字段名称
	 * @return 字段过滤对象
	 */
	public static PropertyFilter ruleOut(final String ... fieldName) {
		PropertyFilter propertyFilter = new PropertyFilter(){
            boolean flag = true;
            @Override
            public boolean apply(Object obj, String name, Object value) {
            	for(int i = 0; i < fieldName.length; i++) {
            		if(name.equalsIgnoreCase(fieldName[i])) {
            			return false;
            		}
            	}
                return flag;
            }
        };
        return propertyFilter;
	}
}
