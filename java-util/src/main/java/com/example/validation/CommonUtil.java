package com.example.validation;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 类CommonUtil.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年3月25日 上午10:52:25
 */
public class CommonUtil {
    public static void main(String args[]) {
        System.out.println(Isnumber("edtryuiop;'"));
    }

    /**
     * 排序
     * 
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static String compare3Paras(String a, String b, String c) {
        String sign = null;
        if (a.compareTo(b) <= 0 && a.compareTo(c) <= 0) {
            if (b.compareTo(c) <= 0) {
                sign = a + b + c;
            } else
                sign = a + c + b;
        }
        if (b.compareTo(c) <= 0 && b.compareTo(a) <= 0) {
            if (a.compareTo(c) <= 0) {
                sign = b + a + c;
            } else
                sign = b + c + a;
        }
        if (c.compareTo(b) <= 0 && c.compareTo(a) <= 0) {
            if (a.compareTo(b) <= 0) {
                sign = c + a + b;
            } else
                sign = c + b + a;
        }
        return sign;
    }

    /**
     * 根据传入日期，计算往后推几天的日期
     * 
     * @param date
     * @param i
     * @return
     */
    public static String DataDay(Date date, int i) {
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(Calendar.DATE, i);// 把日期往后增加一天.整数往后推,负数往前移动
        date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy年MM月dd日");
        String dateString = formatter.format(date);
        return dateString;

    }

    /**
     * 根据传入日期，计算往后推几天的星期
     * 
     * @param date
     * @param i
     * @return
     */
    public static String DataWeek(Date date, int i) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, i);
        String week = new DateFormatSymbols().getShortWeekdays()[cal.get(Calendar.DAY_OF_WEEK)];
        return week;
    }

    /**
     * 根据日期算出星期值
     * 
     * @param date
     * @return
     */
    public static String Week(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        String week = new DateFormatSymbols().getShortWeekdays()[cal.get(Calendar.DAY_OF_WEEK)];
        return week;
    }

    /**
     * 日期差值
     * 
     * @param oDate
     * @return
     */
    public static int daysInterval(Date oDate) {
        Date today = new Date();
        Calendar aCalendar = Calendar.getInstance();
        aCalendar.setTime(today);
        int day1 = aCalendar.get(Calendar.DAY_OF_YEAR);
        aCalendar.setTime(oDate);
        int day2 = aCalendar.get(Calendar.DAY_OF_YEAR);
        return day2 - day1;

    }

    /**
     * 获取服务器时间，并以字符串形式返回
     * 
     * @return yyyymmddhhmmss 格式的字符串
     */
    public static String getDateTime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String ly_time = sdf.format(new java.util.Date());
        return ly_time;
    }

    /**
     * @author wangmeng 提取字符串中的字母+数字串
     * @param content
     * @return
     */
    public static String getLetterNumbers(String content) {
        Pattern pattern = Pattern.compile("[a-zA-Z]*\\d+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            return matcher.group(0);
        }
        return null;
    }

    public static String getFormattedText(byte[] bytes) {
        int len = bytes.length;
        StringBuilder buf = new StringBuilder(len * 2);
        // 把密文转换成十六进制的字符串形式
        for (int j = 0; j < len; j++) {
            buf.append(HEX_DIGITS[(bytes[j] >> 4) & 0x0f]);
            buf.append(HEX_DIGITS[bytes[j] & 0x0f]);
        }
        return buf.toString();
    }

    public static boolean comparetime() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String endtime = "2014-03-31";
        Date d = null;
        try {
            d = sdf.parse(endtime);
        } catch (ParseException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        boolean flag = d.before(new Date());
        return flag;
    }

    public static boolean Isnumber(String info) {
        String regx = "^[\u4e00-\u9fa5]*$";
        String regx1 = "^\\d+$";
        if (info.matches(regx1)) {
            System.out.println("*****是数字****");
            return true;
        } else if (info.matches(regx)) {
            System.out.println("****是汉子*****");
            return false;
        } else {
            System.out.println("****无匹配信息*****");
            return false;
        }

    }

    /**
     * 判断是否为手机号码
     * 
     * @return boolean
     */
    public static boolean isValidFixTel(String phoneNo) {
        System.out.println("phoneNo is not null");
        if (phoneNo.length() == 11) {
            System.out.println("phoneNo is not 11 length");
            String no = phoneNo.substring(0, 2);
            System.out.println("no----" + no);
            if (no.equals("13") || no.equals("14") || no.equals("15") || no.equals("18") || no.equals("17")) {
                return true;
            }
        }
        return false;
    }

    private static final char[] HEX_DIGITS = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd',
            'e', 'f'                      };

}
