package com.jixiao.common.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <p>
 * 时间工具
 * </p>
 *
 * @author jiang
 * @since 2018-08-30
 */
public class DateUtil {

    /**
     * 获取当前时间
     *
     * @return date
     */
    public static Date date() {
        return new Date();
    }

    /**
     * 两个时间戳的时差（分）
     *
     * @param date 时间
     * @return int
     */
    public static long subtract2Date(Date date) {
        return (System.currentTimeMillis() - date.getTime()) / (60 * 60 * 1000);
    }

    /**
     * 把日期类型格式化成字符串
     *
     * @param date    时间
     * @param pattern 格式
     * @return str
     */
    public static String convert2String(Date date, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        return format.format(date);
    }

    /**
     * 把日期字符串格式化成日期类型
     *
     * @param dateStr 时间
     * @param pattern 格式
     * @return str
     */
    public static Date convert2Date(String dateStr, String pattern) {
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        try {
            return format.parse(dateStr);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 将时间戳转换为时间字符串
     *
     * @param timestamp 时间戳
     * @param pattern   格式
     * @return str
     */
    public static String timestamp2Date(Integer timestamp, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(new Date(timestamp * 1000L));
    }


    /**
     * 格式化时间
     *
     * @param source 时间
     * @return str
     */
    public static String formatDate(String source) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Calendar sourceCalendar = Calendar.getInstance();
            sourceCalendar.setTime(formatter.parse(source));

            Calendar calendar = Calendar.getInstance();
            long diff = calendar.getTimeInMillis() - sourceCalendar.getTimeInMillis();
            long minutes = diff / (60 * 1000);
            long hours = diff / (60 * 60 * 1000);
            long days = diff / (24 * 60 * 60 * 1000);

            if (hours < 1) {
                return minutes + "分钟之前";
            }
            if (hours > 1 && days < 1) {
                return hours + "小时前";
            }
            if (days < 4) {
                return days + "天前";
            }
            return sourceCalendar.get(Calendar.YEAR) + "-" + (sourceCalendar.get(Calendar.MONTH) + 1) + "-" + sourceCalendar.get(Calendar.DATE);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return source;
    }

}
