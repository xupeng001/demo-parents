package com.example.arithmetic.fibonacci;

/**
 * 类Fibonacci.java的实现描述：斐波那契数列
 * 
 * @author xupeng 2017年8月29日 上午10:29:11
 */
public class Fibonacci {

    public static void main(String[] args) {
        //        System.out.println(method1(5));
        //        System.out.println(method1(45));
        //        System.out.println(method2(5));
        //        System.out.println(method2(45));
        int x = 0;
        /**
         * 0<y<1
         */
        double y = 0.8;
        while (true) {
            long a = method2(x);
            double b = Math.pow(2, x * y);
            if (a >= b) {
                System.out.println(x);
                return;
            } else {
                System.out.println(x);
            }
            x++;
        }

    }

    /**
     * 指数级复杂度
     * 
     * @param i
     * @return
     */
    private static long method1(int i) {

        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        return method1(i - 1) + method1(i - 2);
    }

    /**
     * 线性复杂度
     * 
     * @param i
     * @return
     */
    private static long method2(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        long[] fn = new long[i + 1];
        fn[1] = 1;
        fn[0] = 0;
        for (int j = 2; j <= i; j++) {
            fn[j] = fn[j - 1] + fn[j - 2];
        }

        return fn[i];

    }
}
