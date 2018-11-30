package com.chngenesis.nebula.util;

import java.math.BigDecimal;

import org.apache.commons.lang3.StringUtils;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class StringUtil {
    /**
     * 批量添加占位符(DAO使用)
     *
     * @return
     */
    public static String bulkPlaceholders(String hqlorsql, Object[] placeholder) {
        StringBuffer hqlorsqlBuffer = new StringBuffer(hqlorsql);
        for (int i = 0; i < placeholder.length; i++) {
            if (placeholder.length != i + 1) {
                hqlorsqlBuffer.append(" ?, ");
            } else {
                hqlorsqlBuffer.append(" ? )");
            }
        }
        return hqlorsqlBuffer.toString();
    }

    /**
     * 隐藏身份证号
     *
     * @param str
     * @return
     */
    public static String identityCardHiding(String str) {
        return str = str.substring(0, 6) + "*******" + str.substring(14);
    }

    /**
     * 隐藏电话号码
     *
     * @param str
     * @return
     */
    public static String identityPhoneNumber(String str) {
        if (str.length() == 12) {
            return str = str.substring(0, 4) + "****" + str.substring(8);
        }
        return str = str.substring(0, 3) + "****" + str.substring(7);
    }

    public static boolean isEmpty(Object obj) {
        if (obj == null || "".equals(obj)) {
            return true;
        }
        return false;
    }

    public static boolean isNotEmpty(Object obj) {
        return !isEmpty(obj);
    }

    public static boolean isNotNull(Object obj) {
        return !isNull(obj);
    }

    public static boolean isNull(Object obj) {
        if (obj == null) {
            return true;
        }
        return false;
    }

    /**
     * 获取汉字全拼
     *
     * @param src 汉字
     * @return
     */
    public static String getPingYin(String src) {
        if (StringUtils.isBlank(src)) {
            return "";
        }
        char[] t1 = null;
        t1 = src.toCharArray();
        String[] t2 = new String[t1.length];
        HanyuPinyinOutputFormat t3 = new HanyuPinyinOutputFormat();
        t3.setCaseType(HanyuPinyinCaseType.LOWERCASE);
        t3.setToneType(HanyuPinyinToneType.WITHOUT_TONE);
        t3.setVCharType(HanyuPinyinVCharType.WITH_V);
        String t4 = "";
        int t0 = t1.length;
        try {
            for (int i = 0; i < t0; i++) {
                // 判断是否为汉字字符
                if (java.lang.Character.toString(t1[i]).matches("[\\u4E00-\\u9FA5]+")) {
                    t2 = PinyinHelper.toHanyuPinyinStringArray(t1[i], t3);
                    t4 += t2[0];
                } else {
                    t4 += java.lang.Character.toString(t1[i]);
                }
            }
            return t4;
        } catch (BadHanyuPinyinOutputFormatCombination e1) {
            e1.printStackTrace();
        }
        return t4;
    }

    /**
     * 获取名称缩写拼音
     *
     * @param str 汉字
     * @return
     */
    public static String getPinYinHeadChar(String str) {
        String convert = "";
        for (int j = 0; j < str.length(); j++) {
            char word = str.charAt(j);
            String[] pinyinArray = PinyinHelper.toHanyuPinyinStringArray(word);
            if (pinyinArray != null) {
                convert += pinyinArray[0].charAt(0);
            } else {
                convert += word;
            }
        }
        return convert;
    }
    
    /**
     * 分数字符串转换成BigDecimal
     * @param score
     * @return
     */
    public static BigDecimal getDecimal(String score) {
    	BigDecimal dec = BigDecimal.ZERO;
    	if (score.contains("/")) {
    		String[] split = score.split("/");
    		Integer molecular = Integer.parseInt(split[0]);
    		Integer denominator = Integer.parseInt(split[1]);
    		if( denominator.equals(0) ) {
    			return dec;
    		}
    		
    		return BigDecimal.valueOf(molecular).divide(BigDecimal.valueOf(denominator), 4, BigDecimal.ROUND_HALF_UP);
    	} else {
    		return new BigDecimal(score);
    	}
    	
    }
}
