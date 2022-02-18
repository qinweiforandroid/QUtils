package com.qw.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 操作时间的工具类.
 */
public class TimeHelper {
    public static final String FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

    public static SimpleDateFormat getDateFormat(String format) {
        return new SimpleDateFormat(format);
    }

    /**
     * 获取当前时间
     *
     * @return 当前时间戳
     * @deprecated use currentTimeMillis()
     */
    public static long getCurrentTime() {
        return currentTimeMillis();
    }

    public static long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public static String currentDateStr() {
        Date date = new Date();
        return formatDate(date);
    }

    public static Date currentDate() {
        Date date = new Date();
        String str = formatDate(date);
        //去掉時分秒后的日期
        return parseDate(str);
    }

    /**
     * 日期格式化
     *
     * @param timestamp 时间戳
     * @return yyyy-MM-dd
     */
    public static String getDate(long timestamp) {
        return getFormatTime(timestamp, FORMAT_YYYY_MM_DD);
    }


    public static Date parse(String date, String format) {
        try {
            return getDateFormat(format).parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Date parseDate(String date) {
        return parse(date, FORMAT_YYYY_MM_DD);
    }

    public static String format(Date date, String format) {
        return getDateFormat(format).format(date);
    }

    public static String format(long timestamp, String format) {
        Date date = new Date(timestamp);
        return format(date, format);
    }

    public static String formatDate(long timestamp) {
        return getFormatTime(timestamp, FORMAT_YYYY_MM_DD);
    }

    /**
     * 格式化日期字符串 {@link #FORMAT_YYYY_MM_DD}
     *
     * @param date 日期
     * @return
     */
    public static String formatDate(Date date) {
        return format(date, FORMAT_YYYY_MM_DD);
    }

    /**
     * 比较目标日期是否在时间区间内
     *
     * @param targetDate 目标时间
     * @param startDate  开始时间
     * @param endDate    结束时间
     * @return
     */
    public static boolean between(Date targetDate, Date startDate, Date endDate) {
        return targetDate.getTime() >= startDate.getTime() && targetDate.getTime() <= endDate.getTime();
    }

    /**
     * 日期格式化
     *
     * @param dateTimeStr yyyy-MM-dd HH:mm:ss
     * @return yyyy-MM-dd
     */
    public static String getDate(String dateTimeStr) {
        SimpleDateFormat myFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            return getDate(myFormatter.parse(dateTimeStr).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * 获取当前时间
     *
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getTime() {
        return getTime(System.currentTimeMillis());
    }

    /**
     * @param time 时间戳
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getTime(long time) {
        return getFormatTime(time, "yyyy-MM-dd HH:mm:ss");
    }


    /**
     * 获取时间
     *
     * @return MM-dd HH:mm
     */
    public static String getHeadTime() {
        return getFormatTime(getCurrentTime(), "MM-dd HH:mm");
    }


    /**
     * 格式化时间
     *
     * @param time   时间戳
     * @param format 样式 例如 yyyy-MM-dd HH:mm:ss
     * @return yyyy-MM-dd HH:mm:ss 则返回2019-04-03 15:19
     */
    public static String getFormatTime(long time, String format) {
        Date date = new Date(time);
        return getDateFormat(format).format(date);
    }


    /**
     * @param time milliseconds
     * @return getTimeRule1
     */
    public static String getTimeRule1(long time) {
        Calendar c1 = Calendar.getInstance(TimeZone.getTimeZone("GMT+8:00"));
        c1.setTimeInMillis(time);
        return compare1(c1);
    }

    /**
     * @param time yyyy-MM-dd HH:mm:ss
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String getTimeRule1(String time) {
        if (time == null || "".equals(time.trim())) {
            return "刚刚";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = sdf.parse(time);
            Calendar c1 = Calendar.getInstance(TimeZone.getTimeZone("GMT+8:00"));
            c1.setTime(date);
            return compare1(c1);
        } catch (ParseException e) {
            return "刚刚";
        }
    }

    /**
     * @param time milliseconds
     * @return getTimeRule2
     */
    public static String getTimeRule2(long time) {
        Calendar c1 = Calendar.getInstance(TimeZone.getTimeZone("GMT+8:00"));
        c1.setTimeInMillis(time);
        return compare2(c1);
    }

    /**
     * @param time yyyy-MM-dd HH:mm:ss
     * @return 时间字符
     */
    public static String getTimeRule2(String time) {
        if (time == null || "".equals(time.trim())) {
            return "刚刚";
        }
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = null;
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            return "刚刚";
        }
        Calendar c1 = Calendar.getInstance(TimeZone.getTimeZone("GMT+8:00"));
        c1.setTime(date);
        return compare2(c1);
    }


    private static String compare1(Calendar c1) {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yy-MM-dd HH:mm");
        SimpleDateFormat sdf2 = new SimpleDateFormat("MM-dd HH:mm");
        Calendar c2 = Calendar.getInstance(TimeZone.getDefault());
        if (c1.get(Calendar.YEAR) < c2.get(Calendar.YEAR)) {
            return sdf1.format(c1.getTime());
        }
        if (c1.get(Calendar.MONTH) < c2.get(Calendar.MONTH)
                || (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH) && c1.get(Calendar.DAY_OF_MONTH) < c2.get(Calendar.DAY_OF_MONTH))) {
            return sdf2.format(c1.getTime());
        }
        if (c1.get(Calendar.HOUR_OF_DAY) < c2.get(Calendar.HOUR_OF_DAY) - 1) {
            return "今天 " + c1.get(Calendar.HOUR_OF_DAY) + ":"
                    + (c1.get(Calendar.MINUTE) < 10 ? "0" + c1.get(Calendar.MINUTE) : c1.get(Calendar.MINUTE));
        }
        if (c1.get(Calendar.HOUR_OF_DAY) == c2.get(Calendar.HOUR_OF_DAY) - 1) {
            if (c1.get(Calendar.MINUTE) > c2.get(Calendar.MINUTE)) {
                return c2.get(Calendar.MINUTE) + (60 - c1.get(Calendar.MINUTE)) + "分钟前";
            }
            return "今天 " + c1.get(Calendar.HOUR_OF_DAY) + ":"
                    + (c1.get(Calendar.MINUTE) < 10 ? "0" + c1.get(Calendar.MINUTE) : c1.get(Calendar.MINUTE));
        }
        if (c1.get(Calendar.MINUTE) < c2.get(Calendar.MINUTE) - 1) {
            return c2.get(Calendar.MINUTE) - c1.get(Calendar.MINUTE) + "分钟前";
        }
        return "刚刚";
    }

    private static String compare2(Calendar c1) {
        Calendar c2 = Calendar.getInstance(TimeZone.getDefault());
        if (c1.get(Calendar.YEAR) < c2.get(Calendar.YEAR) - 1) {
            return c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR) + "年前";
        }
        if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR) - 1) {
            if (c1.get(Calendar.DAY_OF_YEAR) < c2.get(Calendar.DAY_OF_YEAR)) {
                return c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR) + "年前";
            }
            return c2.get(Calendar.DAY_OF_YEAR) + (365 - c1.get(Calendar.DAY_OF_YEAR)) + "天前";
        }
        if (c1.get(Calendar.DAY_OF_YEAR) < c2.get(Calendar.DAY_OF_YEAR) - 1) {
            return c2.get(Calendar.DAY_OF_YEAR) - c1.get(Calendar.DAY_OF_YEAR) + "天前";
        }
        if (c1.get(Calendar.DAY_OF_YEAR) == c2.get(Calendar.DAY_OF_YEAR) - 1) {
            if (c1.get(Calendar.DAY_OF_YEAR) < c2.get(Calendar.DAY_OF_YEAR)) {
                return c2.get(Calendar.DAY_OF_YEAR) - c1.get(Calendar.DAY_OF_YEAR) + "天前";
            }
            return c2.get(Calendar.DAY_OF_YEAR) + (24 - c1.get(Calendar.DAY_OF_YEAR)) + "小时前";
        }
        if (c1.get(Calendar.HOUR_OF_DAY) < c2.get(Calendar.HOUR_OF_DAY) - 1) {
            return c2.get(Calendar.HOUR_OF_DAY) - c1.get(Calendar.HOUR_OF_DAY) + "小时前";
        }
        if (c1.get(Calendar.HOUR_OF_DAY) == c2.get(Calendar.HOUR_OF_DAY) - 1) {
            if (c1.get(Calendar.MINUTE) > c2.get(Calendar.MINUTE)) {
                return c2.get(Calendar.MINUTE) + (60 - c1.get(Calendar.MINUTE)) + "分钟前";
            }
            return c2.get(Calendar.HOUR_OF_DAY) - c1.get(Calendar.HOUR_OF_DAY) + "小时前";
        }
        if (c1.get(Calendar.MINUTE) < c2.get(Calendar.MINUTE) - 1) {
            return c2.get(Calendar.MINUTE) - c1.get(Calendar.MINUTE) + "分钟前";
        }
        return "1分钟前";
    }
}
