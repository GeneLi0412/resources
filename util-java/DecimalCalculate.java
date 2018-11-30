package com.chngenesis.nebula.util;

import java.math.BigDecimal;

public class DecimalCalculate {
   
	
	/**
	 * 与0比较大小
	 * @param bigDecimal
	 * @return 1.大于 0.等于  -1小于
	 */
	public static int compareToZero(BigDecimal bigDecimal) {
		return bigDecimal.compareTo(BigDecimal.ZERO);
	}
	
	/**  
     * 提供精确的加法运算。  
     * @param v1 被加数  
     * @param v2 加数  
     * @return 两个参数的和  
     */   
    public static double add(double v1,double v2){   
        BigDecimal b1 = new BigDecimal(Double.toString(v1));   
        BigDecimal b2 = new BigDecimal(Double.toString(v2));   
        return b1.add(b2).doubleValue();   
    }   
    /**  
     * 提供精确的减法运算。  
     * @param v1 被减数  
     * @param v2 减数  
     * @return 两个参数的差  
     */   
    public static double sub(double v1,double v2){   
        BigDecimal b1 = new BigDecimal(Double.toString(v1));   
        BigDecimal b2 = new BigDecimal(Double.toString(v2));   
        return b1.subtract(b2).doubleValue();   
    }   
    
	
	/**  
     * 提供精确的加法运算。  
     * @param b1 被加数  
     * @param b2 加数  
     * @return 两个参数的和  
     */   
    public static BigDecimal add(BigDecimal b1,BigDecimal b2){   
        return b1.add(b2);   
    }  
    
    
    /**  
     * 提供精确的减法运算。  
     * @param b1 被减数  
     * @param b2 减数  
     * @return 两个参数的差  
     */                
    public static BigDecimal sub(BigDecimal b1,BigDecimal b2){   
        return b1.subtract(b2);   
    }  
    
    /**
	 * 精确比较两个数字
	 * 
	 * @param v1
	 *            需要被对比的第一个数
	 * @param v2
	 *            需要被对比的第二个数
	 * @return 如果两个数一样则返回0，如果第一个数比第二个数大则返回1，反之返回-1
	 */
	public static int compareTo(BigDecimal b1,BigDecimal b2) {
		return b1.compareTo(b2);
	}
	
	
	/**
	 * 提供（相对）精确的除法运算。当发生除不尽的情况时，由scale参数指 定精度，以后的数字四舍五入。
	 * 
	 * @param v1
	 *            被除数
	 * @param v2
	 *            除数
	 * @param scale
	 *            表示表示需要精确到小数点以后几位。
	 * @return 两个参数的商
	 */
	public static double div(double v1, double v2, int scale) {
		if (scale < 0) {
			throw new IllegalArgumentException("参数scale必须为整数为零!");
		}
		BigDecimal b1 = new BigDecimal(Double.toString(v1));
		BigDecimal b2 = new BigDecimal(Double.toString(v2));
		return b1.divide(b2, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
	}
	
}
