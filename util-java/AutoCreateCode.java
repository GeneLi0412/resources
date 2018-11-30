package com.chngenesis.nebula.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自动生成标识号工具类
 */
public class AutoCreateCode {
	// 定义常量
	public static final String PREFIX = "PC";
	private static long code;

	// 提供一个静态方法，自动生成批次名称
	public static synchronized String nextCode() {
		code++;
		String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		long m = Long.parseLong((str)) * 1000;
		m += code;
		return PREFIX + m;
	}

	// 生成时间数+2位随机数
	public static synchronized String businessCode() {
		String str = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		String mdStr = MD5Util.md5s(str);
		return str + MD5Util.randomTo(mdStr);
	}
	
	

}
