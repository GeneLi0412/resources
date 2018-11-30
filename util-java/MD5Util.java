package com.chngenesis.nebula.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class MD5Util {
	public static String str;

	public static String md5s(String plainText) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();
			int i;
			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			str = buf.toString();
			System.out.println("result: " + buf.toString());// 32位的加密
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return str;
	}
	/**
	 * 在字符串中随机获取5位字符
	 * @param str
	 * @return
	 */
	public static String random(String str) {
		// 声明返回值
		String temp = "";
		Random random = new Random();

		for (int i = 0; i < 5; i++) {

			// 随机获取数字 5次 charAt(num);
			int num = random.nextInt(str.length());

			char c1 = str.charAt(num); // 索引从0开始

			temp += c1;

		}

		return temp;
	}
	
	/**
	 * 在字符串中随机获取2位字符
	 * @param str
	 * @return
	 */
	public static String randomTo(String str) {
		// 声明返回值
		String temp = "";
		Random random = new Random();

		for (int i = 0; i < 2; i++) {

			// 随机获取数字 2次 charAt(num);
			int num = random.nextInt(str.length());

			char c1 = str.charAt(num); // 索引从0开始

			temp += c1;

		}

		return temp;
	}
}
