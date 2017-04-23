package com.example.string;


/**
 * 类ReverseString.java的实现描述：通过递归实现字符串翻转 
 * 1. 递归公式；2. 收敛条件（什么时候就不再继续递归）
 * @author xupeng 2017年4月11日 下午2:28:59
 */
public class ReverseString {

    public static void main(String[] args) {
        System.out.println(reverse("abcdefg"));
    }

    public static String reverse(String originStr) {
        System.out.println(originStr);
        if (originStr == null || originStr.length() <= 1)
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }
}
