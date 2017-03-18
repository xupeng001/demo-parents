package com.example.string;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.junit.Test;

public class FormatString {

    public static void main(String[] args) {
        int youNumber = 111;
        // 0 代表前面补充0   
        // 4 代表长度为4   
        // d 代表参数为正数型   
        String str = String.format("%04d", youNumber);
        System.out.println(str); // 0001   
        //--------------
        System.out.println(haoAddOne_2("111"));
        //-------------------
        // 待测试数据
        int i = 1;
        // 得到一个NumberFormat的实例
        NumberFormat nf = NumberFormat.getInstance();
        // 设置是否使用分组
        nf.setGroupingUsed(false);
        // 设置最大整数位数
        nf.setMaximumIntegerDigits(14);
        // 设置最小整数位数
        nf.setMinimumIntegerDigits(8);
        // 输出测试语句
        System.out.println(nf.format(i));
    }

    private static final String STR_FORMAT = "0000";

    public static String haoAddOne_2(String liuShuiHao) {
        Integer intHao = Integer.parseInt(liuShuiHao);
        intHao++;
        DecimalFormat df = new DecimalFormat(STR_FORMAT);
        return df.format(intHao);
    }
    @Test
    public void testString (){
        String str = String.format("%06d", 10);
        System.out.println(str);
    }
}
