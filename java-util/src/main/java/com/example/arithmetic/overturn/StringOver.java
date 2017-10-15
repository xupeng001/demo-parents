package com.example.arithmetic.overturn;

/**
 * 类StringOver.java的实现描述：TODO 通过一个方法实现字符串的翻转
 * 
 * @author xupeng 2017年8月28日 下午3:53:04
 */
public class StringOver {

    private static String str = "abcdef";

    public static void main(String[] args) {
        method1(str);
        method2(str);
    }

    /**
     * 时间复杂度 
     * 空间复杂度 O(2N)
     * @param str
     */
    private static void method1(String str) {
        char[] strArray = str.toCharArray();
        char temp;
        int i = 0, j = strArray.length - 1;
        while (i < j) {
            temp = strArray[i];
            strArray[i] = strArray[j];
            strArray[j] = temp;
            i++;
            j--;
        }
        System.out.println(String.valueOf(strArray));
    }

    /**
     * 时间复杂度
     * 空间复杂度 空间复杂度 O(2N)
     * @param str
     */
    private static void method2(String str) {
        int i = 0, j = str.length() - 1;
        StringBuffer sb = new StringBuffer(str);
        while (i < j) {
            sb.setCharAt(j, str.charAt(i));
            sb.setCharAt(i, str.charAt(j));
            i++;
            j--;
        }
        System.out.println(sb.toString());
    }
}
