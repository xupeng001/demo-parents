package com.example.encode;

import java.io.UnsupportedEncodingException;

/**
 * 类StringEncode.java的实现描述：GB2312编码的字符串转换为ISO-8859-1编码的字符串
 * 
 * @author xupeng 2017年4月11日 下午2:30:13
 */
public class StringEncode {

    public static void main(String[] args) {
        String s1 = "你好";
        String s2 = null;
        try {
            s2 = new String(s1.getBytes("GB2312"), "ISO-8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(s2);
        String s3 = null;
        try {
            s3 = new String(s2.getBytes("ISO-8859-1"), "GB2312");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(s3);

    }
}
