package com.chngenesis.nebula.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 集合工具类
 * @author 龚帅
 *
 */
public class CollectionUtil {

	/**
	 * list去重
	 * @param list
	 * @return
	 */
	public static <T> List<T> removeDuplicate(List<T> list){  
        return new ArrayList<T>(new HashSet<T>(list));
	} 
	
	/**
	 * object[]转String[]
	 * @param obj
	 * @return
	 */
	public static String[] objToStrArry (Object[] obj){ 
		String [] str = null;
		if (obj!=null) {
			 str = new String[obj.length];
			for (int i = 0; i < obj.length; i++) {
				str[i] = obj[i].toString();
			}
		}
        return str;
	} 
}
