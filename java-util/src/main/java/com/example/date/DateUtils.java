package com.example.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;

/**
 * 类DateUtils.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年3月25日 上午10:48:32
 */
public class DateUtils {

    private static final DateFormat yyyyMMdd       = new SimpleDateFormat("yyyy-MM-dd");
    private static final DateFormat yyyyMMddHHmm   = new SimpleDateFormat("yyyy-MM-dd HH:mm");
    private static final DateFormat yyyyMMddHHmmss = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String get(Date date, String pattern) {
        return new SimpleDateFormat(pattern).format(date);
    }

    public static Date parse(String dateStr, String pattern) {
        try {
            return new SimpleDateFormat(pattern).parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getYmd(Date date) {
        return yyyyMMdd.format(date);
    }

    public static Date parseYmd(String dateStr) {
        try {
            return yyyyMMdd.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getYmdHmi(Date date) {
        return yyyyMMddHHmm.format(date);
    }

    public static Date parseYmdHmi(String dateStr) {
        try {
            return yyyyMMddHHmm.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String getYmdHmis(Date date) {
        return yyyyMMddHHmmss.format(date);
    }

    public static Date parseYmdHmis(String dateStr) {
        try {
            return yyyyMMddHHmmss.parse(dateStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static int getDays(Date begin, Date end) {
        begin = parseYmd(getYmd(begin));
        end = parseYmd(getYmd(end));
        return (int) ((end.getTime() - begin.getTime()) / (1000 * 60 * 60 * 24));
    }

    /**
     * 生成日期随机序列码
     * 
     * @param fix 前缀
     * @param pattern 日期格式
     * @param randCount 后面几位随机码
     * @return 如: getDateSerializable("P", "yyyyMMdd", 3); <br />
     *         结果: P20140820xxx x为随机数
     */
    public static String getDateSerializable(String fix, String pattern, int randCount) {
        String dateStr = StringUtils.trimToEmpty(fix) + get(new Date(), pattern);
        Random rand = new Random();
        for (int i = 0; i < randCount; i++) {
            dateStr += rand.nextInt(10);
        }
        return dateStr;
    }

}
