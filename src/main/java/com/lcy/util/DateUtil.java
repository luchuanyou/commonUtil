package com.lcy.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

/**
 *
 */
public class DateUtil {
    private final static Logger logger = LoggerFactory.getLogger(DateUtil.class);
    /**
     * 日期格式
     */
    public static final String FORMAT_YYYY_MM_DD_HMS = "yyyy-MM-dd HH:mm:ss";
    public static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";
    public static final String FORMAT_YYYYMMDD = "yyyyMMdd";
    public static final String FORMAT_YYYY_MM_DD_STR = "yyyy年MM月dd";
    public static final String FORMAT_YYYY_MM_DD_T = "yyyy-MM-dd'T'HH:mm:ss.SSS";

    /**
     * 获取日期
     *
     * @param dateStr
     * @param format
     * @return
     */
    public static Date getDateFromStr(String dateStr, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.parse(dateStr);
        } catch (Exception e) {
            logger.error("日期解析系统异常,getDateFromStr Exception,dateStr:" + dateStr, e);
            throw new RuntimeException(e);
        }
    }

    public static String getStrFromDate(Date date, String format) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(format);
            return sdf.format(date);
        } catch (Exception e) {
            logger.error("日期转换系统异常,getStrFromDate Exception,date:" + date, e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取日期相差天数
     *
     * @param startDate
     * @param endDate
     * @return
     */
    public static long daysBetween(Date startDate, Date endDate) {
        LocalDate startLocalDate = dateToLocalDate(startDate);
        LocalDate endLocalDate = dateToLocalDate(endDate);
        return endLocalDate.toEpochDay() - startLocalDate.toEpochDay();
    }

    /**
     * 日期转换
     *
     * @param date
     * @return
     */
    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zone = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, zone);
        LocalDate localDate = localDateTime.toLocalDate();
        return localDate;
    }

    public static Date getBeginOfDay(Date date) {
        Date reDate = null;
        if (null != date) {
            Calendar ca = Calendar.getInstance();
            ca.setTime(date);
            ca.set(Calendar.HOUR_OF_DAY, 0);
            ca.set(Calendar.SECOND, 0);
            ca.set(Calendar.MINUTE, 0);
            reDate = ca.getTime();
        }
        return reDate;
    }

    public static Date getEndOfDay(Date date) {
        Date reDate = null;
        if (null != date) {
            Calendar ca = Calendar.getInstance();
            ca.setTime(date);
            ca.set(Calendar.HOUR_OF_DAY, 23);
            ca.set(Calendar.SECOND, 59);
            ca.set(Calendar.MINUTE, 59);
            reDate = ca.getTime();
        }
        return reDate;
    }

    public static void main(String[] args) {
        /*Date date = DateUtil.getDateFromStr("2016-08-03", DateUtil.FORMAT_YYYY_MM_DD);
        System.out.println(date);
        System.out.println(DateUtil.getStrFromDate(date, DateUtil.FORMAT_YYYY_MM_DD));

        Date date2 = DateUtil.getDateFromStr("2016-08-03", DateUtil.FORMAT_YYYY_MM_DD);
        System.out.println(DateUtil.getStrFromDate(date2, DateUtil.FORMAT_YYYY_MM_DD));
        System.out.println(daysBetween(date, date2));

        System.out.println("====3====");
        String date3Str = DateUtil.getStrFromDate(new Date(),DateUtil.FORMAT_YYYY_MM_DD_T);
        Date date3 = DateUtil.getDateFromStr("2018-12-29T12:58:17.136", DateUtil.FORMAT_YYYY_MM_DD_T);
        System.out.println(date3Str);
        System.out.println(DateUtil.getStrFromDate(date3, DateUtil.FORMAT_YYYY_MM_DD_HMS));*/

        Date startDate = getBeginOfDay(new Date());
        System.out.println(DateUtil.getStrFromDate(startDate, DateUtil.FORMAT_YYYY_MM_DD_HMS));

        Date endDate = getEndOfDay(new Date());
        System.out.println(DateUtil.getStrFromDate(endDate, DateUtil.FORMAT_YYYY_MM_DD_HMS));
    }

}
