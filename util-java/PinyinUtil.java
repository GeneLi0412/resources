package com.chngenesis.nebula.util;

import net.sourceforge.pinyin4j.PinyinHelper;
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType;
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat;
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType;
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType;
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination;

public class PinyinUtil {

	/**
	 * 将文字转为汉语拼音
	 * 
	 * @param ChineseLanguage
	 *            要转成拼音的中文
	 */
	public static String toHanyuPinyin(String ChineseLanguage) {
		char[] cl_chars = ChineseLanguage.trim().toCharArray();
		String hanyupinyin = "";
		HanyuPinyinOutputFormat defaultFormat = new HanyuPinyinOutputFormat();
		defaultFormat.setCaseType(HanyuPinyinCaseType.LOWERCASE);// 输出拼音全部小写
		defaultFormat.setToneType(HanyuPinyinToneType.WITHOUT_TONE);// 不带声调
		defaultFormat.setVCharType(HanyuPinyinVCharType.WITH_V);
		try {
			for (int i = 0; i < cl_chars.length; i++) {
				if (String.valueOf(cl_chars[i]).matches("[\u4e00-\u9fa5]+")) {// 如果字符是中文,则将中文转为汉语拼音
					hanyupinyin += PinyinHelper.toHanyuPinyinStringArray(cl_chars[i], defaultFormat)[0];
				} else {// 如果字符不是中文,则不转换
					hanyupinyin += cl_chars[i];
				}
			}
		} catch (BadHanyuPinyinOutputFormatCombination e) {
			System.out.println("字符不能转成汉语拼音");
		}
		return hanyupinyin;
	}

	public static void main(String[] args) {
		String a = getHeadByChar("血常规jhka15325..*-");
		System.out.println(a);
	}

	/**
	 * 取汉字的首字母
	 * 
	 * @param ChineseLanguage
	 * @return
	 */
	public static String getHeadByChar(String ChineseLanguage) {
		
		//将字符串装换为字符数组 方便判断
		char[] src = ChineseLanguage.toCharArray();
		String pycode = "";

		// 如果不是汉字直接返回
		for (char c : src) {
			if (c <= 128) {
				pycode = pycode + Character.toUpperCase(c);
			} else {
				// 获取所有的拼音
				String[] pinyingStr = PinyinHelper.toHanyuPinyinStringArray(c);
				//获取当前拼音的首字母并大写
				if(pinyingStr!=null&&pinyingStr.length!=0) {
					pycode = pycode + Character.toUpperCase(pinyingStr[0].toCharArray()[0]);
				}
			}
		}
		return pycode;
	}

}
