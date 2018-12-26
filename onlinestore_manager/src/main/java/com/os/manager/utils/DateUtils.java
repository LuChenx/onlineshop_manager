
package com.os.manager.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.apache.commons.lang.StringUtils;

/**
 * 
 * @ClassName: DateUtils
 * @Description:TODO(日期转化用工具类)
 * @author: 陆晨曦
 * @date: 2018年12月26日 下午11:52:49
 * 
 * @Copyright: 2018 luchenxi. All rights reserved.
 *             注意：本内容仅限于陆晨曦以及授权组织使用，禁止外泄以及用于其他的商业目
 */
public class DateUtils
{
	/** 格式：yyyy-MM-dd HH:mm:ss.S */
	public static final String FULL_STANDARD_DATETIME_FORMAT = "yyyy-MM-dd HH:mm:ss.S";
	/** 格式：yyyy-MM-dd HH:mm:ss */
	public static final String STANDARD_DATETIME_FORMAT	 = "yyyy-MM-dd HH:mm:ss";
	/** 格式：yyyy-MM-dd HH:mm */
	public static final String INCOMPLETE_DATETIME_FORMAT	 = "yyyy-MM-dd HH:mm";
	/** 格式：yyyyMMddHHmmss */
	public static final String SHORT_DATETIME_FORMAT	 = "yyyyMMddHHmmss";
	/** 格式：yyyyMMddHHmmssS */
	public static final String SHORT_FULL_DATETIME_FORMAT	 = "yyyyMMddHHmmssSSS";
	/** 格式：yyyyMMddHHmm */
	public static final String DYNAMICS_DATETIME_FORMAT	 = "yyyy-MM-dd HH:mm";
	/** 格式：yyyy-MM-dd */
	public static final String STANDARD_DATE_FORMAT		 = "yyyy-MM-dd";
	/** 格式：yyyy-MM-dd HH */
	public static final String DAY_DATE_FORMAT		 = "yyyy-MM-dd HH";
	/** 格式：yyyyMMdd */
	public static final String SHORT_DATE_FORMAT		 = "yyyyMMdd";
	/** 格式：MMdd */
	public static final String SHORT_MMDD_FORMAT		 = "MMdd";
	/** 格式：HHmmss */
	public static final String SHORT_TIME_FORMAT		 = "HHmmss";
	/** 格式: yyyy-MM-dd'T'HH:mm:ss'Z' */
	public static final String UTC_DATETIME_FORMAT		 = "yyyy-MM-dd'T'HH:mm:ss'Z'";
	public static final String SHORT_YYMM_FORMAT		 = "yyyyMM";
	/** 格式：MM-dd */
	public static final String TIME_FORMAT			 = "HH:mm";

	private DateUtils()
	{}

	/**
	 * 格式完全日期时间字符串（包含毫秒，标准格式：yyyy-MM-dd HH:mm:ss.S）
	 *
	 * @param date 日期时间
	 * @return 完全日期时间字符串
	 */
	public static String formatFullStandardDateTime(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(FULL_STANDARD_DATETIME_FORMAT);
		return sdf.format(date);
	}

	public static String formatShortDateYM(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_YYMM_FORMAT);
		return sdf.format(date);
	}

	/**
	 * 格式日期时间字符串（标准格式：yyyy-MM-dd HH:mm:ss）
	 *
	 * @param date 日期时间
	 * @return 日期时间字符串
	 */
	public static String formatStandardDateTime(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(DYNAMICS_DATETIME_FORMAT);
		return sdf.format(date);
	}

	/**
	 * 格式日期时间字符串（标准格式：yyyy-MM-dd HH:mm:ss）
	 *
	 * @param date 日期时间
	 * @return 日期时间字符串
	 */
	public static String formatStandardDateTime2(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(STANDARD_DATETIME_FORMAT);
		return sdf.format(date);
	}

	/**
	 * 格式日期时间字符串（短格式：yyyyMMddHHmmss）
	 *
	 * @param date 日期时间
	 * @return 日期时间字符串
	 */
	public static String formatShortDateTime(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATETIME_FORMAT);
		return sdf.format(date);
	}

	/**
	 * 格式日期时间字符串（短格式：yyyyMMddHHmmssS）
	 *
	 * @param date 日期时间
	 * @return 日期时间字符串
	 */
	public static String formatShortFullDateTime(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_FULL_DATETIME_FORMAT);
		return sdf.format(date);
	}

	/**
	 * 格式日期时间字符串（短格式：yyyyMMddHHmmss）
	 *
	 * @param date 日期时间
	 * @param zone 时区
	 * @return 日期时间字符串
	 */
	public static String formatShortDateTime(Date date , TimeZone zone)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATETIME_FORMAT);
		sdf.setTimeZone(zone);
		return sdf.format(date);
	}

	/**
	 * 格式日期字符串（标准格式：yyyy-MM-dd）
	 *
	 * @param date 日期
	 * @return 日期字符串
	 */
	public static String formatStandardDate(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(STANDARD_DATE_FORMAT);
		return sdf.format(date);
	}

	/**
	 * 格式日期字符串（短格式：yyyyMMdd）
	 *
	 * @param date 日期
	 * @return 日期字符串
	 */
	public static String formatShortDate(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATE_FORMAT);
		return sdf.format(date);
	}

	/**
	 * 格式日期字符串（短格式：yyyyMMdd）
	 *
	 * @param date 日期
	 * @param zone 时区
	 * @return 日期字符串
	 */
	public static String formatShortDate(Date date , TimeZone zone)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATE_FORMAT);
		sdf.setTimeZone(zone);
		return sdf.format(date);
	}

	/**
	 * 格式日期字符串（短格式：yyyyMMdd）
	 *
	 * @param date 日期
	 * @return 日期字符串
	 */
	public static Date formatToShortDate(Date date) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATE_FORMAT);
		return parseShortDate(sdf.format(date));
	}

	/**
	 * 格式日期字符串（短格式：MMdd）
	 *
	 * @param date 日期
	 * @return 日期字符串
	 */
	public static String formatShortMMDDDate(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_MMDD_FORMAT);
		return sdf.format(date);
	}

	/**
	 * 格式时间字符串（短格式：HHmmss）
	 *
	 * @param date 时间
	 * @return 时间字符串
	 */
	public static String formatShortTime(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_TIME_FORMAT);
		return sdf.format(date);
	}

	/**
	 * 解析完全日期时间字符串（包含毫秒，标准格式：yyyy-MM-dd HH:mm:ss.S）
	 *
	 * @param dateTimeStr 完全日期时间字符串
	 * @return 日期时间
	 * @throws ParseException
	 */
	public static Date parseFullStandardDateTime(String dateTimeStr) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(FULL_STANDARD_DATETIME_FORMAT);
		return sdf.parse(dateTimeStr);
	}

	/**
	 * 解析日期时间字符串（标准格式：yyyy-MM-dd HH:mm:ss）
	 *
	 * @param dateTimeStr 日期时间字符串
	 * @return 日期时间
	 * @throws ParseException
	 */
	public static Date parseStandardDateTime(String dateTimeStr) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(STANDARD_DATETIME_FORMAT);
		return sdf.parse(dateTimeStr);
	}

	/**
	 * 解析日期时间字符串 (不完整格式：yyyy-MM-dd HH:mm)
	 *
	 * @param dateTimeStr
	 * @return
	 * @throws ParseException
	 */
	public static Date parseIncompleteDateTime(String dateTimeStr) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(INCOMPLETE_DATETIME_FORMAT);
		return sdf.parse(dateTimeStr);
	}

	public static String formatIncompleteDateTime(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(INCOMPLETE_DATETIME_FORMAT);
		return sdf.format(date);
	}

	public static Date getIncompleteDateTime(Date date) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(INCOMPLETE_DATETIME_FORMAT);
		String strdate = sdf.format(date);
		return parseIncompleteDateTime(strdate);
	}

	/**
	 * 解析日期时间字符串（短格式：yyyyMMddHHmmss）
	 *
	 * @param dateTimeStr 日期时间字符串
	 * @return 日期时间
	 * @throws ParseException
	 */
	public static Date parseShortDateTime(String dateTimeStr) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATETIME_FORMAT);
		return sdf.parse(dateTimeStr);
	}

	/**
	 * 解析日期时间字符串（短格式：yyyyMMddHHmmss）
	 *
	 * @param dateTimeStr 日期时间字符串
	 * @param zone 时区
	 * @return 日期时间
	 * @throws ParseException
	 */
	public static Date parseShortDateTime(String dateTimeStr , TimeZone zone) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATETIME_FORMAT);
		sdf.setTimeZone(zone);
		return sdf.parse(dateTimeStr);
	}

	/**
	 * 解析日期字符串（标准格式：yyyy-MM-dd）
	 *
	 * @param dateStr 日期字符串
	 * @return 日期
	 * @throws ParseException
	 */
	public static Date parseStandardDate(String dateStr) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(STANDARD_DATE_FORMAT);
		return sdf.parse(dateStr);
	}

	/**
	 * 解析日期字符串（短格式：yyyyMMdd）
	 *
	 * @param dateStr 日期字符串
	 * @return 日期
	 * @throws ParseException
	 */
	public static Date parseShortDate(String dateStr) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATE_FORMAT);
		return sdf.parse(dateStr);
	}

	/**
	 * 解析日期字符串（短格式：yyyyMMdd）
	 *
	 * @param dateStr 日期字符串
	 * @param zone 时区
	 * @return 日期
	 * @throws ParseException
	 */
	public static Date parseShortDate(String dateStr , TimeZone zone) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_DATE_FORMAT);
		sdf.setTimeZone(zone);
		return sdf.parse(dateStr);
	}

	/**
	 * 解析日期字符串（短格式：MMdd）
	 *
	 * @param dateStr 日期字符串
	 * @return 日期
	 * @throws ParseException
	 */
	public static Date parseShortMMDDDate(String dateStr) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_MMDD_FORMAT);
		return sdf.parse(dateStr);
	}

	/**
	 * 解析时间字符串（短格式：HHmmss）
	 *
	 * @param dateStr 时间字符串
	 * @return 时间
	 * @throws ParseException
	 */
	public static Date parseShortTime(String dateStr) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(SHORT_TIME_FORMAT);
		return sdf.parse(dateStr);
	}

	/**
	 * 获取传入日期的上一天
	 *
	 * @param date
	 * @return 日期
	 */
	public static Date getStandardDatePre(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, -1);
		return cal.getTime();
	}

	/**
	 * 获取传入日期的下一天
	 *
	 * @param date
	 * @return 日期
	 */
	public static Date getStandardDateNext(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);
		return cal.getTime();
	}

	public static int getSecondToDateNext(Date date) throws ParseException
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, 1);
		Date nextDay = cal.getTime();
		String standDay = formatStandardDate(nextDay);
		Date nextStand = parseStandardDate(standDay);
		long ms = nextStand.getTime() - date.getTime();
		return (int) (ms / 1000);
	}

	/**
	 * 获取前几天
	 *
	 * @param date
	 * @return 日期
	 */
	public static String getBeforeDays(int days)
	{
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, (0 - days));
		String daString = formatStandardDate(cal.getTime());
		return daString;
	}

	public static Date getAfterDays(int days)
	{
		Date date = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.DATE, days);
		return cal.getTime();
	}

	/**
	 * 获取指定日期的0时0分0秒
	 *
	 * @param date
	 * @return
	 */
	public static Date getStartTimeOfDay(Date date)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MILLISECOND, 0);
		return cal.getTime();
	}

	/**
	 * 根据传入格式获取时间
	 */
	public static String getNowDateTimeByFormat(String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(new Date());
	}

	/**
	 * 根据格式获取时间
	 */
	public static String getDateTimeByFormat(Date date , String format)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		return sdf.format(date);
	}

	/**
	 * 将字符串格式转换为日期
	 * 
	 * @param() @return
	 */
	public static Date parseTime(String createTime , String formate) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(formate);
		return sdf.parse(createTime);
	}

	/**
	 * 获取两个日期的相差天数
	 * 
	 * @param() @return
	 */
	public static int daysBeteen(String smdate , String bdate , String formate) throws ParseException
	{
		if(StringUtils.isEmpty(formate))
		{
			formate = SHORT_DATE_FORMAT;
		}
		SimpleDateFormat sdf = new SimpleDateFormat(formate);
		Calendar cal = Calendar.getInstance();
		cal.setTime(sdf.parse(smdate));
		long time1 = cal.getTimeInMillis();
		cal.setTime(sdf.parse(bdate));
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);
		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 当前时间戳
	 */
	public static long toUnixTime() throws ParseException
	{
		return new Date().getTime();
	}

	/**
	 * 将日期转化指定格式
	 * 
	 * @param date
	 * @param format
	 * @return
	 */
	public static Date formatDate(Date date , String format) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String newDate = sdf.format(date);
		return sdf.parse(newDate);
	}

	/**
	 * 解析时间字符串（格式：yyyy-MM-dd HH）
	 *
	 * @param dateTimeStr
	 * 
	 * @return 日期时间
	 * @throws ParseException
	 */
	public static Date parseDayDateTime(String dateTimeStr) throws ParseException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(DAY_DATE_FORMAT);
		return sdf.parse(dateTimeStr);
	}

	/**
	 * 当前月的天数
	 * 
	 * @return
	 */
	public static int getCurrentMonthLastDay()
	{
		Calendar a = Calendar.getInstance();
		a.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	/**
	 * 指定月份的天数
	 * 
	 * @param year
	 * @param month
	 * @return
	 */
	public static int getMonthLastDay(int year , int month)
	{
		Calendar a = Calendar.getInstance();
		a.set(Calendar.YEAR, year);
		a.set(Calendar.MONTH, month - 1);
		a.set(Calendar.DATE, 1);// 把日期设置为当月第一天
		a.roll(Calendar.DATE, -1);// 日期回滚一天，也就是最后一天
		int maxDate = a.get(Calendar.DATE);
		return maxDate;
	}

	/**
	 * 格式日期字符串（短格式：yyyy-MM-dd HH）
	 *
	 * @param date 日期
	 * @return 日期字符串
	 */
	public static String formatDayDate(Date date)
	{
		SimpleDateFormat sdf = new SimpleDateFormat(DAY_DATE_FORMAT);
		return sdf.format(date);
	}

	/**
	 * 获取两个日期之间的间隔天数
	 * @return
	 */
	public static int getGapCount(Date startDate , Date endDate)
	{
		Calendar fromCalendar = Calendar.getInstance();
		fromCalendar.setTime(startDate);
		fromCalendar.set(Calendar.HOUR_OF_DAY, 0);
		fromCalendar.set(Calendar.MINUTE, 0);
		fromCalendar.set(Calendar.SECOND, 0);
		fromCalendar.set(Calendar.MILLISECOND, 0);
		Calendar toCalendar = Calendar.getInstance();
		toCalendar.setTime(endDate);
		toCalendar.set(Calendar.HOUR_OF_DAY, 0);
		toCalendar.set(Calendar.MINUTE, 0);
		toCalendar.set(Calendar.SECOND, 0);
		toCalendar.set(Calendar.MILLISECOND, 0);
		return (int) ((toCalendar.getTime().getTime() - fromCalendar.getTime().getTime()) /
			(1000 * 60 * 60 * 24));
	}
}
