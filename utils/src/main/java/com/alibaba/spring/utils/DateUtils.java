package com.alibaba.spring.utils;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by jack on 2018/3/17.
 */
public class DateUtils {
    // 默认日期格式
    public static final String DATE_DEFAULT_FORMAT = "yyyy-MM-dd";

    /**
     * 默认时间格式 yyyy-MM-dd HH:mm:ss
     */
    public static final String DATETIME_DEFAULT_FORMAT = "yyyy-MM-dd HH:mm:ss";

    public static final String TIME_DEFAULT_FORMAT = "HH:mm:ss";


    /**
     * 获取当前时间，再加几年
     *
     * @param year
     * @return
     */
    public static Calendar getCurrentDateAddYears(int year) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.YEAR, year);
        return calendar;
    }

    /**
     * 获取当前时间，再加几年
     *
     * @return
     */
    public static Calendar getCurrentDateAddHours(int hours) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar;
    }

    /**
     * 获取当前时间，再加几年
     *
     * @return
     */
    public static Calendar getCurrentDateAddMinutes(int minutes) {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minutes);
        return calendar;
    }

    /**
     * 获取指定时间加几天
     * @param date
     * @param day
     * @return
     */
    public static Calendar addDays(final Date date, final int day) {
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, day);
        return calendar;
    }

    /**
     * 获取指定时间起始时间
     * @param calendar
     * @return
     */
    public static Calendar getStartCalendar(final Calendar calendar) {
        final Calendar newCalendar = Calendar.getInstance();
        newCalendar.set(Calendar.YEAR,calendar.get(Calendar.YEAR));
        newCalendar.set(Calendar.MONTH,calendar.get(Calendar.MONTH));
        newCalendar.set(Calendar.DATE,calendar.get(Calendar.DATE));
        newCalendar.set(Calendar.HOUR_OF_DAY,0);
        newCalendar.set(Calendar.MINUTE,0);
        newCalendar.set(Calendar.SECOND,0);
        newCalendar.set(Calendar.MILLISECOND,0);
        return newCalendar;
    }

    /**
     * 获取指定时间末尾时间
     * @param calendar
     * @return
     */
    public static Calendar getEndCalendar(final Calendar calendar) {
        final Calendar newCalendar = getStartCalendar(calendar);
        newCalendar.add(Calendar.DATE,1);
        newCalendar.add(Calendar.MILLISECOND,-1);
        return newCalendar;
    }

    /**
     * 获取当前时间
     *
     * @return
     */
    public static Calendar getNowDate() {
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    public static Calendar getDate(Calendar date){
        date.set(date.get(Calendar.YEAR),date.get(Calendar.MONTH),date.get(Calendar.DATE));
        return date;
    }

    public static Calendar convert2Calendar(long time){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(time);
        return calendar;
    }


    /**
     * 把日期字符串格式化成日期类型
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static Date convert2Date(String dateStr, String format) {
        SimpleDateFormat simple = new SimpleDateFormat(format);
        try {
            simple.setLenient(false);
            return simple.parse(dateStr);
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 把日期字符串格式化成日期类型
     *
     * @param dateString
     * @param format
     * @return
     */
    public static Calendar convert2Calendar(String dateString, String format) {
        Date date = convert2Date(dateString, format);
        if (date == null)
            return null;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }

    /**
     * 把日期类型格式化成字符串
     *
     * @param date
     * @param format
     * @return
     */
    public static String convert2String(Date date, String format) {
        SimpleDateFormat formater = new SimpleDateFormat(format);
        try {
            return formater.format(date);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 把日期类型格式化成字符串(默认格式  yyyy-MM-dd)
     *
     * @param date
     * @return
     */
    public static String convert2StringDefaultFormat(Date date) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(DATE_DEFAULT_FORMAT);
            return formatter.format(date);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 把日期类型格式化成字符串(默认格式  yyyy-MM-dd)
     *
     * @param calendar
     * @return
     */
    public static String convert2StringDefaultFormat(Calendar calendar) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(DATE_DEFAULT_FORMAT);
            return formatter.format(calendar.getTime());
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 把日期类型格式化成字符串(默认格式  yyyy-MM-dd)
     *
     * @param date
     * @return
     */
    public static String convert2StringDefaultDate(String date) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat(DATE_DEFAULT_FORMAT);
            return formatter.format(date);
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 把日期类型格式化成字符串
     *
     * @param calendar
     * @param format
     * @return
     */
    public static String convert2String(Calendar calendar, String format) {
        SimpleDateFormat formater = new SimpleDateFormat(format);
        try {
            return formater.format(calendar.getTime());
        } catch (Exception e) {
            return "";
        }
    }

    public static int getDiffDays(Date fromDate,Date toDate){
        long from = fromDate.getTime();
        long to = toDate.getTime();
        return (int) ((to - from)/(1000 * 60 * 60 * 24));
    }

    public static  int getAge(Date birthDay)  {
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) {
            return -1;
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);

        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);

        int age = yearNow - yearBirth;

        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth) age--;
            }else{
                age--;
            }
        }
        return age;
    }



    public static Date getMaxDate(Date d1,Date d2)
    {
        if(d1.compareTo(d2)>0)
        {
            return d1;
        }
        return d2;
    }
    public static Date getMinDate(Date d1,Date d2)
    {
        if(d1.compareTo(d2)<0) {
            return  d1;
        }
        return d2;
    }


    /**
     * 判断是否为相同日期
     * @param d1
     * @param d2
     * @return
     */
    public static boolean isSameDate(Date d1, Date d2) {
        LocalDate localDate1 = ZonedDateTime.ofInstant(d1.toInstant(), ZoneId.systemDefault()).toLocalDate();
        LocalDate localDate2 = ZonedDateTime.ofInstant(d2.toInstant(), ZoneId.systemDefault()).toLocalDate();
        return localDate1.isEqual(localDate2);
    }
}
