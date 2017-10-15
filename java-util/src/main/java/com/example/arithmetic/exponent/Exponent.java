package com.example.arithmetic.exponent;

/**
 * 类Multiplication.java的实现描述：TODO 指数运算
 * 
 * @author xupeng 417年8月28日 下午4:24:31
 */
public class Exponent {

    public static void main(String[] args) throws Exception {
        /**
         * 都是正整数
         */
        System.out.println("Math.pow  都是正整数 : " + Math.pow(4, 2));
        System.out.println("this.pow  都是正整数 : " + pow(4, 2));

        /**
         * 基数是负数
         */
        System.out.println("Math.pow  基数是负数 : " + Math.pow(-4, 2));
        System.out.println("this.pow  基数是负数 : " + pow(-4, 2));

        /**
         * 指数是负数
         */
        System.out.println("Math.pow 指数是负数 : " + Math.pow(4, -2));
        System.out.println("this.pow 指数是负数 : " + pow(4, -2));

        /**
         * 都是负数
         */
        System.out.println("Math.pow 都是负数 : " + Math.pow(-4, -2));
        System.out.println("this.pow 都是负数 : " + pow(-4, -2));

        /**
         * 指数为0
         */
        System.out.println("Math.pow 指数为0 : " + Math.pow(-4, 0));
        System.out.println("this.pow 指数为0 : " + pow(-4, 0));

        /**
         * 基数为0
         */
        System.out.println("Math.pow 基数为0 : " + Math.pow(0, 2));
        System.out.println("Math.pow 基数为0 : " + Math.pow(0, -2));
        System.out.println("this.pow 基数为0 : " + pow(0, 2));

        /**
         * 都是0
         */
        System.out.println("Math.pow 都是0 : " + Math.pow(0, 0));
        System.out.println("this.pow 都是0 : " + pow(0, 0));

    }

    /**
     * @param cardinal 基数
     * @param exponent 指数
     * @return
     * @throws Exception
     */
    private static double pow(double cardinal, double exponent) throws Exception {
        //        if(exponent)

        /**
         * 任何数的O次幂都是0
         */
        if (exponent == 0) {
            return 1;
        }

        if (cardinal == 0) {
            if (exponent >= 0) {
                return 0;
            } else {
                Math.pow(cardinal, exponent);
            }
        }

        /**
         * exponent为正整数
         */
        if (exponent > 0) {
            Double sum = 1D;
            for (int i = 0; i < exponent; i++) {
                sum = sum * cardinal;
            }
            return sum;
        } else {
            Double sum = 1D;
            for (int i = 0; i < Math.abs(exponent); i++) {
                sum = sum * cardinal;
            }
            return sum;
        }

    }
}
