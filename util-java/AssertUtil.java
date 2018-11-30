package com.chngenesis.startrek.util;

/**
 * 断言类，对方法参数进行验证 
 * @author Administrator
 */
public class AssertUtil {

	/**
	 * @param expression 验证的参数
	 * @param message    发生异常的说明内容
	 */
	public static void isTrue(boolean expression, String message){
		if(!expression){
			throw new IllegalArgumentException(message);
		}
	}
	public static void isNull(Object object,String message){
		if(object!=null){
			throw new IllegalArgumentException(message);
		}
	}
	public static void notNull(Object object, String message) {
		if (object == null) {
			throw new IllegalArgumentException(message);
		}
	}
	public static void hasText(String text, String message) {
		if (text!=null&&text.trim().length()>0) {
			throw new IllegalArgumentException(message);
		}
	}
}
