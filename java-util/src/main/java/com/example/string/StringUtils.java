package com.example.string;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	final static long MILLIS_ONE_DAY = 24 * 60 * 60 * 1000;
	final static long MILLIS_ONE_WEEK = 7 * 24 * 60 * 60 * 1000;

	public static String timeOnCR(String timeStr) {

		String time = "";

		Calendar Now = Calendar.getInstance();
		long millisNow = Now.getTimeInMillis();
		int dayNow = (int) (millisNow / MILLIS_ONE_DAY) + 1;

		long millisCall = Long.parseLong(timeStr);
		int dayCall = (int) (millisCall / MILLIS_ONE_DAY) + 1;

		Date dateCall = new Date(millisCall);
		Calendar calCall = Calendar.getInstance();
		calCall.setTime(dateCall);
		if (dayCall == dayNow) {
			time = new SimpleDateFormat("HH:mm", Locale.getDefault())
					.format(dateCall);

		} else if (dayNow - 1 == dayCall) {
			time = "昨天";
		} else if (dayNow - 7 <= dayCall) {

			int d = calCall.get(Calendar.DAY_OF_WEEK);
			switch (d) {

			case 1:
				time = "星期日";
				break;
			case 2:
				time = "星期一";
				break;
			case 3:
				time = "星期二";
				break;
			case 4:
				time = "星期三";
				break;
			case 5:
				time = "星期四";
				break;
			case 6:
				time = "星期五";
				break;
			case 7:
				time = "星期六";
				break;
			}

		} else {
			time = new SimpleDateFormat("yy-MM-dd", Locale.getDefault())
					.format(dateCall);
		}

		return time;
	}

	public static String getTime(String timeStr) {

		return new SimpleDateFormat("HH:mm", Locale.getDefault())
				.format(new Date(Long.parseLong(timeStr)));

	}

	public static String getDate(String timeStr) {

		return new SimpleDateFormat("yyyy年MM月dd日", Locale.getDefault())
				.format(new Date(Long.parseLong(timeStr)));

	}

	public static String getDuration(String timeStr) {

		return new SimpleDateFormat("mm分ss秒", Locale.getDefault())
				.format(new Date(Long.parseLong(timeStr) * 1000));

	}

	public static String getSecondDuration(String timeStr) {

		final String zero = "0";
		final String ofen = "0分";

		String time = getDuration(timeStr);
		if (time.startsWith(zero)) {
			time = time.substring(1);
		}
		if (time.startsWith(ofen)) {
			time = time.substring(2);
		}
		if (time.startsWith(zero)) {
			time = time.substring(1);
		}
		return time;
	}

	public static boolean isMobileNO(String number) {
		if (number.startsWith("86")) {
			number = number.substring(2);
		}
		if (number.startsWith("+86")) {
			number = number.substring(3);
		}
		number = number.replaceAll(" ", "");
		number = number.replaceAll("-", "");
		if (org.apache.commons.lang3.StringUtils.isEmpty(number)
				|| number.length() < 11) {
			return false;
		}
		number = get11Number(number);
		if (number.matches("^1[\\d]{10}$") && number.length() == 11) {
			return true;
		} else {
			return false;
		}

	}

	public static String getMobileNO(String number) {
		if (number.startsWith("86")) {
			number = number.substring(2);
		}
		if (number.startsWith("+86")) {
			number = number.substring(3);
		}
		number = number.replaceAll(" ", "");
		number = number.replaceAll("-", "");
		if (number.length() > 10) {
			return StringUtils.get11Number(number);
		} else {
			throw new RuntimeException("传入的Number——不是一个手机号");
		}
	}

	public static String get11Number(String number) {
		if (org.apache.commons.lang3.StringUtils.isEmpty(number)) {
			return number;
		}
		number = number.trim();
		if (org.apache.commons.lang3.StringUtils.isEmpty(number)
				|| number.length() <= 11) {
			return number;
		} else {
			int startIndex = number.length() - 11;
			number = number.substring(startIndex);
			return number;
		}
	}

	/**
	 * 根据小写简拼字母或数字生成简拼码
	 * 
	 * @param number
	 * @return
	 */
	public static String getNumFromLetter(String number) {

		String num = "";
		for (int i = 0; i < number.length(); i++) {
			String c = number.charAt(i) + "";
			if (c.equals("1")) {
				num = num + "1";
				continue;
			} else if (c.equals("2") || c.equals("a") || c.equals("b")
					|| c.equals("c")) {
				num = num + "2";
				continue;
			} else if (c.equals("3") || c.equals("d") || c.equals("e")
					|| c.equals("f")) {
				num = num + "3";
				continue;
			} else if (c.equals("4") || c.equals("g") || c.equals("h")
					|| c.equals("i")) {
				num = num + "4";
				continue;
			} else if (c.equals("5") || c.equals("j") || c.equals("k")
					|| c.equals("l")) {
				num = num + "5";
				continue;
			} else if (c.equals("6") || c.equals("m") || c.equals("n")
					|| c.equals("o")) {
				num = num + "6";
				continue;
			} else if (c.equals("7") || c.equals("p") || c.equals("q")
					|| c.equals("r") || c.equals("s")) {
				num = num + "7";
				continue;
			} else if (c.equals("8") || c.equals("t") || c.equals("u")
					|| c.equals("v")) {
				num = num + "8";
				continue;
			} else if (c.equals("9") || c.equals("w") || c.equals("x")
					|| c.equals("y") || c.equals("z")) {
				num = num + "9";
				continue;
			} else if (c.equals("0")) {
				num = num + "0";
				continue;
			}
		}

		return num;
	}

	public static String double2KiloMeters(Double kiloms) {
		// DecimalFormat df = new DecimalFormat("######0.00");
		Double result = null;
		if (kiloms < 1000) {
			BigDecimal decimal = new BigDecimal(kiloms);
			result = decimal.setScale(2, BigDecimal.ROUND_HALF_UP)
					.doubleValue();

			return result.toString();
		} else if (kiloms > 1000) {
			BigDecimal decimal = new BigDecimal(kiloms / 1000);
			result = decimal.setScale(2, BigDecimal.ROUND_HALF_UP)
					.doubleValue();
			return result + "k";

		} else {
			return "1k";
		}
	}

	public static String replaceFirst(StringBuilder originStr, String oldStr,
			String newStr) {
		return (originStr.replace(originStr.lastIndexOf(oldStr),
				originStr.lastIndexOf(oldStr) + 1, newStr).toString());
	}

	public static String replaceFirst(String originStr, String oldStr,
			String newStr) {
		StringBuilder sb = new StringBuilder(originStr);
		return replaceFirst(sb, oldStr, newStr);
	}

	public static boolean isHaveArea(String number) {
		number = number.replaceAll("[//d]", "");
		if (number.length() < 5) {
			return false;
		}
		if (!StringUtils.isMobileNO(number) && (number.startsWith("0"))) {
			return true;
		}
		return false;
	}

	/**
	 * 判断字符串是否是数字
	 */
	public static boolean isNum(String str) {
		return str.matches("^[-+]?(([0-9]+)([.]([0-9]+))?|([.]([0-9]+))?)$");
	}

	/**
	 * 验证邮箱
	 */
	public static boolean isEmail(String email) {
		String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
		Pattern p = Pattern.compile(str);
		Matcher m = p.matcher(email);
		return m.matches();
	}
}
