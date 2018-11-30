package com.chngenesis.nebula.util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class DateUtil {
	private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>();
	private static final Object object = new Object();

	/**
	 * 获取凌晨时间
	 * 
	 * @return
	 */
	public static Date getBeforeDawnTime() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Long today = c.getTimeInMillis();
		return new Date(today);
	}

	/**
	 * 获取当天24点时间
	 * 
	 * @return
	 */
	public static Date getTwentyFour() {
		Calendar c = Calendar.getInstance();
		c.set(Calendar.HOUR_OF_DAY, 0);
		c.set(Calendar.MINUTE, 0);
		c.set(Calendar.SECOND, 0);
		c.set(Calendar.MILLISECOND, 0);
		Long today = c.getTimeInMillis();
		today += 24 * 60 * 60 * 1000;
		return new Date(today);
	}

	/**
	 * 获取SimpleDateFormat
	 * 
	 * @param pattern
	 *            日期格式
	 * @return SimpleDateFormat对象
	 * @throws RuntimeException
	 *             异常：非法日期格式
	 */
	private static SimpleDateFormat getDateFormat(String pattern) throws RuntimeException {
		SimpleDateFormat dateFormat = threadLocal.get();
		if (dateFormat == null) {
			synchronized (object) {
				if (dateFormat == null) {
					dateFormat = new SimpleDateFormat(pattern, Locale.US);
					dateFormat.setLenient(false);
					threadLocal.set(dateFormat);
				}
			}
		}
		dateFormat.applyPattern(pattern);
		return dateFormat;
	}

	/**
	 * 获取时间字符串
	 * 
	 * @param date
	 * @return
	 */
	public static String getDateString(Date date, String formatString) {
		SimpleDateFormat sdf = new SimpleDateFormat(formatString);
		return sdf.format(date);
	}

	/**
	 * 将日期字符串转化为日期。失败返回null。
	 * 
	 * @param date
	 *            日期字符串
	 * @param dateStyle
	 *            日期风格
	 * @return 日期
	 */
	public static Date StringToDate(String date, DateStyle dateStyle) {
		Date myDate = null;
		if (dateStyle != null) {
			myDate = StringToDate(date, dateStyle.getValue());
		}
		return myDate;
	}

	/**
	 * 将日期字符串转化为日期。失败返回null。
	 * 
	 * @param date
	 *            日期字符串
	 * @param pattern
	 *            日期格式
	 * @return 日期
	 */
	public static Date StringToDate(String date, String pattern) {
		Date myDate = null;
		if (StringUtils.isNotBlank(date)) {
			try {
				myDate = getDateFormat(pattern).parse(date);
			} catch (Exception e) {
			}
		}
		return myDate;
	}

	/**
	 * 获取日期。默认yyyy-MM-dd格式。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @return 日期
	 */
	public static String getDate(Date date) {
		return DateToString(date, DateStyle.YYYY_MM_DD);
	}

	/**
	 * 将日期转化为日期字符串。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @param pattern
	 *            日期格式
	 * @return 日期字符串
	 */
	public static String DateToString(Date date, String pattern) {
		String dateString = null;
		if (date != null) {
			try {
				dateString = getDateFormat(pattern).format(date);
			} catch (Exception e) {
			}
		}
		return dateString;
	}

	/**
	 * 将日期转化为日期字符串。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @param dateStyle
	 *            日期风格
	 * @return 日期字符串
	 */
	public static String DateToString(Date date, DateStyle dateStyle) {
		String dateString = null;
		if (dateStyle != null) {
			dateString = DateToString(date, dateStyle.getValue());
		}
		return dateString;
	}

	/**
	 * 获取两个日期相差的天数，后一个日期的天数减去前一个日期的天数。也就是说，如果后者时间大于前者，则返回正值，否则返回负值。
	 * 
	 * @param date
	 *            日期
	 * @param otherDate
	 *            另一个日期
	 * @return 相差天数。如果失败则返回-1
	 */
	public static int calculateIntervalDays(Date date, Date otherDate) {
		int num = -1;
		Date dateTmp = DateUtil.StringToDate(DateUtil.getDate(date), DateStyle.YYYY_MM_DD);
		Date otherDateTmp = DateUtil.StringToDate(DateUtil.getDate(otherDate), DateStyle.YYYY_MM_DD);
		if (dateTmp != null && otherDateTmp != null) {
			long time = otherDateTmp.getTime() - dateTmp.getTime();
			num = (int) (time / (24 * 60 * 60 * 1000));
		}
		return num;
	}

	/**
	 * 根据年月日计算年龄,birthTimeString:"1994-11-14"
	 * 
	 * @param birthTimeString
	 *            年月日
	 * @return
	 */
	public static String getAgeFromBirthTime(String birthTimeString) {
		// 先截取到字符串中的年、月、日
		String strs[] = birthTimeString.trim().split("-");
		int selectYear = Integer.parseInt(strs[0]);
		int selectMonth = Integer.parseInt(strs[1]);
		int selectDay = Integer.parseInt(strs[2]);
		// 得到当前时间的年、月、日
		Calendar cal = Calendar.getInstance();
		int yearNow = cal.get(Calendar.YEAR);
		int monthNow = cal.get(Calendar.MONTH) + 1;
		int dayNow = cal.get(Calendar.DATE);

		// 用当前年月日减去生日年月日
		int yearMinus = yearNow - selectYear;
		int monthMinus = monthNow - selectMonth;
		int dayMinus = dayNow - selectDay;

		int age = yearMinus;// 先大致赋值
		String str = "";
		Integer day = getDay(selectYear, selectMonth);
		if (yearMinus < 0) {// 选了未来的年份
			str = 0 + "岁";
		} else if (yearMinus == 0) {// 同年的，要么为1，要么为0
			if (monthMinus < 0) {// 选了未来的月份
				str = 0 + "岁";
				return str;
			} else if (monthMinus == 0) {// 同月份的
				if (dayMinus < 0) {// 选了未来的日期
					str = 0 + "岁";
					return str;
				} else if (dayMinus > 0) {
					str = dayMinus + "天";
				} else if (dayMinus == 0) {
					str = "新生儿";
				}
			} else if (monthMinus > 0) {
				if (dayMinus > 0) {
					str = monthMinus + "个月" + dayMinus + "天";
				} else if (dayMinus == 0) {
					str = monthMinus + "个月";
				} else {
					str = monthMinus - 1 != 0 ? monthMinus - 1 + "个月" + (day + dayMinus) + "天" : day + dayMinus + "天";
				}
			}
		} else if (yearMinus >= 6) {
			if (monthMinus < 0) {// 当前月>生日月
				str = yearMinus - 1 + "岁";
			} else if (monthMinus == 0) {// 同月份的，再根据日期计算年龄
				if (dayMinus < 0) {
					str = yearMinus - 1 + "岁";
				} else if (dayMinus >= 0) {
					str = age + "岁";
				}
			} else if (monthMinus > 0) {
				str = age + "岁";
			}
		} else {
			if (monthMinus < 0) {// 选了未来的月份
				str = yearMinus - 1 != 0 ? yearMinus - 1 + "岁" + (12 + monthMinus) + "个月" : 12 + monthMinus + "个月";
			} else if (monthMinus == 0) {// 同月份的
				if (dayMinus < 0) {// 选了未来的日期
					str = yearMinus - 1 != 0 ? yearMinus - 1 + "岁" + 11 + "个月" : 11 + "个月";
				} else if (dayMinus >= 0) {
					str = yearMinus + "岁";
				}
			} else if (monthMinus > 0) {
				if (dayMinus > 0) {
					str = yearMinus + "岁" + monthMinus + "个月";
				} else if (dayMinus == 0) {
					str = yearMinus + "岁" + monthMinus + "个月";
				} else {
					str = monthMinus - 1 != 0 ? yearMinus + "岁" + (monthMinus - 1) + "个月" : yearMinus + "岁";
				}
			}
		}
		return str;
	}

	/**
	 * 根据年获取月份对应天数
	 * 
	 * @param yearMinus
	 *            年份
	 * @param monthMinus
	 *            月份
	 * @return
	 */
	public static Integer getDay(Integer yearMinus, Integer monthMinus) {
		Integer day = 0;
		switch (monthMinus) {
		case 1:
			day = 31;
			break;
		case 2:
			day = yearMinus / 4 == 0 || yearMinus / 400 == 0 ? 29 : 28;
			break;
		case 3:
			day = 31;
			break;
		case 4:
			day = 30;
			break;
		case 5:
			day = 31;
			break;
		case 6:
			day = 30;
			break;
		case 7:
			day = 31;
			break;
		case 8:
			day = 31;
			break;
		case 9:
			day = 30;
			break;
		case 10:
			day = 31;
			break;
		case 11:
			day = 30;
			break;
		default:
			day = 31;
			break;
		}
		return day;
	}

	/**
	 * 根据传入的时间字符串获取Date
	 * 
	 * @param dateStr
	 *            eg:2018-01-03 18:46:00
	 * @param formatter
	 *            eg:yyyy-MM-dd HH:mm:ss
	 * @return
	 */
	public static Date parseToDate(String dateStr, String formatter) {
		Date date = null;
		if (StringUtils.isBlank(dateStr)) {
			return date;
		}
		try {
			SimpleDateFormat s = new SimpleDateFormat(formatter);
			date = s.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * 判断当前时间是否在有效期内
	 * 
	 * @param validPeriod
	 *            有效期
	 * @return -1 过期 ，0有效（大于三个月） ，3三个月内 ，2两个月内 ，1一个月内
	 */
	public static int jugeDate(Date validPeriodDate) {

		long nd = 1000 * 24 * 60 * 60;
		// 获得两个时间的毫秒时间差异
		long diff = validPeriodDate.getTime() - (new Date()).getTime();
		// 计算差多少天
		long day = diff / nd;
		int statu = -1;
		if (day > 90) {
			statu = 0;
			return statu;
		}
		if (60 < day && day <= 90) {
			statu = 3;
			return statu;
		}
		if (30 < day && day <= 60) {
			statu = 2;
			return statu;
		}
		if (0 < day && day <= 30) {
			statu = 1;
			return statu;
		}
		return statu;
	}

	/**
	 * 根据年龄获取出生年月日 ， 并且为凌晨时间
	 * 
	 * @param age
	 * @return
	 */
	public static Date getBirthdayMor(Integer age) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);

		int ageYear = year - age;
		cal.set(ageYear, month, day);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Date date = cal.getTime();
		return date;
	}

	/**
	 * 根据年龄获取出生年月日 ，并且为当天24点
	 * 
	 * @param age
	 * @return
	 */
	public static Date getBirthdayEnd(Integer age) {
		Calendar cal = Calendar.getInstance();
		int year = cal.get(Calendar.YEAR);
		int month = cal.get(Calendar.MONTH);
		int day = cal.get(Calendar.DAY_OF_MONTH);

		int ageYear = year - age;
		cal.set(ageYear, month, day);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		Long today = cal.getTimeInMillis();
		today += 24 * 60 * 60 * 1000;
		return new Date(today);
	}

	/**
	 * 获取传入时间当天的凌晨时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getBeforeDawnTime(Date date) {
		Date time = null;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			String dateStr = simpleDateFormat.format(date);
			time = simpleDateFormat.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
	}

	/**
	 * 获取传入时间当天的24时时间
	 * 
	 * @param date
	 * @return
	 */
	public static Date getTwentyFour(Date date) {
		Date time = null;
		try {
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
			String dateStr = simpleDateFormat.format(date);
			time = simpleDateFormat.parse(dateStr);
			Long today = time.getTime();
			today += 24 * 60 * 60 * 1000;
			return new Date(today);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return time;
	}

	/**
	 * 获取今天之前n天的时间
	 * 
	 * @param day
	 *            天数
	 * @return
	 */
	public static Date getBeforeDay(Long day) {
		Date date = new Date();
		Long current = date.getTime();
		Long range = 24 * 60 * 60 * 1000 * day;
		Long before = current - range;
		return new Date(before);
	}

	/**
	 * 获取当天的开始时间
	 * 
	 * @return
	 */
	public static java.util.Date getDayBegin() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获取某天的开始时间
	 * 
	 * @return
	 */
	public static java.util.Date getDaySomeBegin(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 获取某天的结束时间
	 * 
	 * @return
	 */
	public static java.util.Date getDaySomeEnd(Date date) {
		Calendar cal = new GregorianCalendar();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	/**
	 * 获取当天的结束时间
	 * 
	 * @return
	 */
	public static java.util.Date getDayEnd() {
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.HOUR_OF_DAY, 23);
		cal.set(Calendar.MINUTE, 59);
		cal.set(Calendar.SECOND, 59);
		return cal.getTime();
	}

	/**
	 * 获取昨天的开始时间
	 * 
	 * @return
	 */
	public static Date getBeginDayOfYesterday() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(getDayBegin());
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return cal.getTime();
	}

	/**
	 * 获取昨天的结束时间
	 * 
	 * @return
	 */
	public static Date getEndDayOfYesterDay() {
		Calendar cal = new GregorianCalendar();
		cal.setTime(getDayEnd());
		cal.add(Calendar.DAY_OF_MONTH, -1);
		return cal.getTime();
	}

	/**
	 * 获取明天的开始时间
	 * 
	 * @return
	 */
	public static Date getBeginDayOfTomorrow() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getDayBegin());
		cal.add(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}

	/**
	 * 获取明天的结束时间
	 * 
	 * @return
	 */
	public static Date getEndDayOfTomorrow() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(getDayEnd());
		cal.add(Calendar.DAY_OF_MONTH, 1);
		return cal.getTime();
	}

	/**
	 * 计算两个时间之间相差多少个小时
	 * 
	 * @param admissTime
	 * @param dischargeTime
	 * @return
	 */
	public static Integer timeDifference(Date admissTime, Date dischargeTime) {
		long number = dischargeTime.getTime() - admissTime.getTime();
		long nh = 1000 * 60 * 60;
		long hour = number / nh;
		long remaining = number % nh;
		if (remaining > 0) {
			hour++;
		}
		return new Integer(hour + "");
	}

	/**
	 * 获取日期的星期。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @return 星期
	 */
	public static Week getWeek(Date date) {
		Week week = null;
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		int weekNumber = calendar.get(Calendar.DAY_OF_WEEK) - 1;
		switch (weekNumber) {
		case 0:
			week = Week.SUNDAY;
			break;
		case 1:
			week = Week.MONDAY;
			break;
		case 2:
			week = Week.TUESDAY;
			break;
		case 3:
			week = Week.WEDNESDAY;
			break;
		case 4:
			week = Week.THURSDAY;
			break;
		case 5:
			week = Week.FRIDAY;
			break;
		case 6:
			week = Week.SATURDAY;
			break;
		}
		return week;
	}

	/**
	 * 增加日期的天数。失败返回null。
	 * 
	 * @param date
	 *            日期字符串
	 * @param dayAmount
	 *            增加数量。可为负数
	 * @return 增加天数后的日期字符串
	 */
	public static String addDay(String date, int dayAmount) {
		return addInteger(date, Calendar.DATE, dayAmount);
	}

	/**
	 * 增加日期的天数。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @param dayAmount
	 *            增加数量。可为负数
	 * @return 增加天数后的日期
	 */
	public static Date addDay(Date date, int dayAmount) {
		return addInteger(date, Calendar.DATE, dayAmount);
	}

	/**
	 * 增加日期的分钟数。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @param dayAmount
	 *            增加数量。可为负数
	 * @return 增加分钟数后的日期
	 */
	public static Date addMINUTE(Date date, int dayAmount) {
		return addInteger(date, Calendar.MINUTE, dayAmount);
	}

	/**
	 * 增加日期的分钟数。失败返回null。
	 * 
	 * @param date
	 *            日期
	 * @param dayAmount
	 *            增加数量。可为负数
	 * @return 增加分钟数后的日期
	 */
	public static String addMINUTE(String date, int dayAmount) {
		return addInteger(date, Calendar.MINUTE, dayAmount);
	}

	/**
	 * 增加日期中某类型的某数值。如增加日期
	 * 
	 * @param date
	 *            日期字符串
	 * @param dateType
	 *            类型
	 * @param amount
	 *            数值
	 * @return 计算后日期字符串
	 */
	private static String addInteger(String date, int dateType, int amount) {
		String dateString = null;
		DateStyle dateStyle = getDateStyle(date);
		if (dateStyle != null) {
			Date myDate = StringToDate(date, dateStyle);
			myDate = addInteger(myDate, dateType, amount);
			dateString = DateToString(myDate, dateStyle);
		}
		return dateString;
	}

	public static Date addHour(Date date, int hourAmount) {
		return addInteger(new Date(), Calendar.HOUR, hourAmount);
	}

	/**
	 * 获取日期字符串的日期风格。失敗返回null。
	 * 
	 * @param date
	 *            日期字符串
	 * @return 日期风格
	 */
	public static DateStyle getDateStyle(String date) {
		DateStyle dateStyle = null;
		Map<Long, DateStyle> map = new HashMap<Long, DateStyle>();
		List<Long> timestamps = new ArrayList<Long>();
		for (DateStyle style : DateStyle.values()) {
			if (style.isShowOnly()) {
				continue;
			}
			Date dateTmp = null;
			if (date != null) {
				try {
					ParsePosition pos = new ParsePosition(0);
					dateTmp = getDateFormat(style.getValue()).parse(date, pos);
					if (pos.getIndex() != date.length()) {
						dateTmp = null;
					}
				} catch (Exception e) {
				}
			}
			if (dateTmp != null) {
				timestamps.add(dateTmp.getTime());
				map.put(dateTmp.getTime(), style);
			}
		}
		Date accurateDate = getAccurateDate(timestamps);
		if (accurateDate != null) {
			dateStyle = map.get(accurateDate.getTime());
		}
		return dateStyle;
	}

	/**
	 * 增加日期中某类型的某数值。如增加日期
	 * 
	 * @param date
	 *            日期
	 * @param dateType
	 *            类型
	 * @param amount
	 *            数值
	 * @return 计算后日期
	 */
	private static Date addInteger(Date date, int dateType, int amount) {
		Date myDate = null;
		if (date != null) {
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(date);
			calendar.add(dateType, amount);
			myDate = calendar.getTime();
		}
		return myDate;
	}

	/**
	 * 获取精确的日期
	 * 
	 * @param timestamps
	 *            时间long集合
	 * @return 日期
	 */
	private static Date getAccurateDate(List<Long> timestamps) {
		Date date = null;
		long timestamp = 0;
		Map<Long, long[]> map = new HashMap<Long, long[]>();
		List<Long> absoluteValues = new ArrayList<Long>();

		if (timestamps != null && timestamps.size() > 0) {
			if (timestamps.size() > 1) {
				for (int i = 0; i < timestamps.size(); i++) {
					for (int j = i + 1; j < timestamps.size(); j++) {
						long absoluteValue = Math.abs(timestamps.get(i) - timestamps.get(j));
						absoluteValues.add(absoluteValue);
						long[] timestampTmp = { timestamps.get(i), timestamps.get(j) };
						map.put(absoluteValue, timestampTmp);
					}
				}

				// 有可能有相等的情况。如2012-11和2012-11-01。时间戳是相等的。此时minAbsoluteValue为0
				// 因此不能将minAbsoluteValue取默认值0
				long minAbsoluteValue = -1;
				if (!absoluteValues.isEmpty()) {
					minAbsoluteValue = absoluteValues.get(0);
					for (int i = 1; i < absoluteValues.size(); i++) {
						if (minAbsoluteValue > absoluteValues.get(i)) {
							minAbsoluteValue = absoluteValues.get(i);
						}
					}
				}

				if (minAbsoluteValue != -1) {
					long[] timestampsLastTmp = map.get(minAbsoluteValue);

					long dateOne = timestampsLastTmp[0];
					long dateTwo = timestampsLastTmp[1];
					if (absoluteValues.size() > 1) {
						timestamp = Math.abs(dateOne) > Math.abs(dateTwo) ? dateOne : dateTwo;
					}
				}
			} else {
				timestamp = timestamps.get(0);
			}
		}

		if (timestamp != 0) {
			date = new Date(timestamp);
		}
		return date;
	}

	/**
	 * 获取指定时间零时
	 * 
	 * @return
	 */
	public static Date getSpecifiedZero(Date specifiedDate) {
		return StringToDate(DateToString(specifiedDate, DateStyle.YYYY_MM_DD), DateStyle.YYYY_MM_DD);
	}

	/**
	 * 计算两个时间的时间差
	 * 
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return
	 */
	public static String timeMistiming(Date startTime, Date endTime) {
		long number = endTime.getTime() - startTime.getTime();
		String hms = "";
		long nd = 1000 * 60 * 60 * 24;
		long nh = 1000 * 60 * 60;
		long nm = 1000 * 60;
		long day = number / nd;
		long hour = number % nd / nh;
		long minute = number % nd % nh / nm;
		long second = (number % nd % nh % nm) / 1000;
		String strHour = hour < 10 ? "0" + hour : "" + hour;// 小时
		String strMinute = minute < 10 ? "0" + minute : "" + minute;// 分钟
		String strSecond = second < 10 ? "0" + second : "" + second;// 秒
		if (day > 0) {
			hms = day + "天 ";
		}
		if (day <= 0) {
			hms = strHour + ":" + strMinute + ":" + strSecond;
		}
		return hms;
	}

	/**
	 * 计算时间(按小时计算)
	 * 
	 * @param date
	 *            当前时间
	 * @param hour
	 *            添加时间（减使用使用负数）
	 * @return 返回时间格式("yyyy-MM-dd HH:mm:ss")
	 */
	public static Date computationTime(Date date, Integer hour) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.HOUR, hour);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateStr = sdf.format(now.getTimeInMillis());
		return parseToDate(dateStr, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 计算两个时间的时间差 (以天为单位返回)
	 * 
	 * @param startTime
	 *            开始时间
	 * @param endTime
	 *            结束时间
	 * @return
	 */
	public static String TimeDifferenceDay(Date startTime, Date endTime) {
		long number = endTime.getTime() - startTime.getTime();
		long nd = 1000 * 60 * 60 * 24;
		long nh = 1000 * 60 * 60;
		BigDecimal day = new BigDecimal(Double.toString(number / nd));
		BigDecimal hour = new BigDecimal(Double.toString(number % nd / nh));
		return day.add(hour.divide(new BigDecimal(24), 2, RoundingMode.HALF_UP)).toString();
	}

	/**
	 * 时分秒转汉字
	 * 
	 * @param str
	 * @return
	 */
	public static String getChinese(String str) {
		StringBuilder sb = new StringBuilder();
		String[] strs = str.split(":");
		String h = strs[0].substring(0, 1);
		String hh = strs[0].substring(1, 2);
		if (h.equals("0") && hh.equals("0")) {
			strs[0] = "零时";
		} else {
			if (!h.equals("0") && !h.equals("1")) {
				strs[0] = strs[0].charAt(0) + "十" + strs[0].charAt(1) + "时";
			} else if (h.equals("1")) {
				strs[0] = "十" + strs[0].charAt(1) + "时";
			} else {
				strs[0] = strs[0].charAt(1) + "时";
			}
		}
		String m = strs[1].substring(0, 1);
		String mm = strs[1].substring(1, 2);
		if (m.equals("0") && mm.equals("0")) {
			strs[1] = "";
		} else {
			if (!m.equals("0") && !m.equals("1")) {
				strs[1] = strs[1].charAt(0) + "十" + strs[1].charAt(1) + "分";
			} else if (m.equals("1")) {
				strs[1] = "十" + strs[1].charAt(1) + "分";
			} else {
				strs[1] = strs[1].charAt(1) + "分";
			}
		}
		strs[2] = "";
		String data = Arrays.toString(strs).replace(",", "").replace("[", "").replace("]", "").replace(" ", "");
		for (int i = 0; i < data.length(); i++) {
			char c = data.charAt(i);
			switch (c) {
			case '0':
				sb.append("");
				break;
			case '1':
				sb.append("一");
				break;
			case '2':
				sb.append("二");
				break;
			case '3':
				sb.append("三");
				break;
			case '4':
				sb.append("四");
				break;
			case '5':
				sb.append("五");
				break;
			case '6':
				sb.append("六");
				break;
			case '7':
				sb.append("七");
				break;
			case '8':
				sb.append("八");
				break;
			case '9':
				sb.append("九");
				break;
			default:
				sb.append(c);
			}
		}
		return sb.toString();
	}

	/**
	 * 获取时间段
	 * 
	 * @param number
	 * @return
	 */
	public static Integer getDateStage(Integer number) {
		Integer num = new Integer(0);
		if (number > 2 && number <= 6) {
			num = 4;
		} else if (number > 6 && number <= 10) {
			num = 8;
		} else if (number > 10 && number <= 14) {
			num = 12;
		} else if (number > 14 && number <= 18) {
			num = 16;
		} else if (number > 18 && number <= 22) {
			num = 20;
		} else if (number > 22 && number <= 2) {
			num = 24;
		}
		return num;

	}

	/**
	 * 获取前一天当前时间
	 * 
	 * @return
	 */
	public static Date getPreDayNow() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, -1); // 得到前一天
		Date date = calendar.getTime();
		return date;
	}

	/**
	 * 获取后一天的当前时间
	 * 
	 * @return
	 */
	public static Date getNextDayNow() {
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, +1); // 得到前一天
		Date date = calendar.getTime();
		return date;
	}

	/**
	 * 得到几天前的时间
	 * 
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date getDateBefore(Date d, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) - day);
		return now.getTime();
	}

	/**
	 * 得到几天后的时间
	 * 
	 * @param d
	 * @param day
	 * @return
	 */
	public static Date getDateAfter(Date d, int day) {
		Calendar now = Calendar.getInstance();
		now.setTime(d);
		now.set(Calendar.DATE, now.get(Calendar.DATE) + day);
		return now.getTime();
	}

}
