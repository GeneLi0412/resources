package com.chngenesis.nebula.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

/**
 * 数字格式相关工具类
 * 
 * @author DengXiang 2018年4月14日
 *
 */
public class MathUtil {
	/**
	 * 小数转百分数转化数
	 */
	static final Integer conversionNum = 2;
	
	/**
	 * @param num
	 * @return
	 */
	public static String intToRoman(int num) {
		String[][] RomanDict = new String[][] { { "", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX" },
				{ "", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC" },
				{ "", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM" },
				{ "", "M", "MM", "MMM", "", "", "", "", "", "", "" }, };
		return RomanDict[3][num / 1000] + RomanDict[2][num % 1000 / 100] + RomanDict[1][num % 100 / 10]
				+ RomanDict[0][num % 10];
	}
	
	/**
	 * BigDecimal计算除法,结果保留小数点后位数
	 * @param divisor	除数
	 * @param dividend	被除数
	 * @param scale	小数点后位数
	 * @return
	 */
	public static BigDecimal divideByFewDecimals(BigDecimal dividend,BigDecimal divisor,Integer scale) {
		return dividend.divide(divisor, scale, RoundingMode.HALF_UP);
	}
	
	/**
	 * BigDecimal计算除法,结果转化为百分数,并保留小数点后位数
	 * @param divisor	除数
	 * @param dividend	被除数
	 * @param scale	小数点后位数
	 * @return
	 */
	public static String divideByFewDecimalsForPercentage (BigDecimal dividend,BigDecimal divisor,Integer scale) {
		BigDecimal divide = dividend.divide(divisor, scale+conversionNum, RoundingMode.HALF_UP);
		NumberFormat percent = NumberFormat.getPercentInstance();
		percent.setMaximumFractionDigits(scale);
		return percent.format(divide.doubleValue());
	}
	/**
	 * BigDecimal计算除法,结果转化为百分数(去百分号),并保留小数点后位数
	 * @param divisor	除数
	 * @param dividend	被除数
	 * @param scale	小数点后位数
	 * @return
	 */
	public static String divideByFewDecimalsForNoPercentage (BigDecimal dividend,BigDecimal divisor,Integer scale) {
		String s = divideByFewDecimalsForPercentage(dividend, divisor, scale);
		String replace = s.replace("%", "");
		return replace;

	}
}
