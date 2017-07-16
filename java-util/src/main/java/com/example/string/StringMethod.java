package com.example.string;

import java.util.Arrays;

public class StringMethod {

	public static void main(String[] args) {
		String str = "test";

		/**
		 * 基于某些指定字符的字符串拆分
		 */
		String[] split = str.split("t");
		for (String string : split) {
			System.out.println(string);
		}
		/**
		 * 字符串转换成字符数组
		 */
		char[] cs = str.toCharArray();
		for (char c : cs) {
			System.out.println(c);
		}
		/**
		 * 排序
		 */
		Arrays.sort(cs);
		for (char c : cs) {
			System.out.println(c);
		}

		/**
		 * 数组转换成字符串
		 */
		String newStr = Arrays.toString(cs);
		System.out.println(newStr);

		/**
		 * 获取指定位置的字符
		 */

		System.out.println(str.charAt(0));
		/**
		 * 字符串的长度
		 */
		System.out.println(str.length());
		/**
		 * 字符串截取
		 */
		System.out.println(str.substring(2));

		System.out.println(str.substring(0, 2));

		/**
		 * 字符串跟数字互转
		 */
		Integer x = 100;
		String xStr = "100";
		Integer.valueOf(xStr);
		String.valueOf(x);
	}

}
