package com.demo.array;

import java.util.Arrays;

import org.junit.Test;
/**
 * 
 * 类Sort.java的实现描述：排序O（n^2）
 * @author xupeng 2017年9月11日 下午2:27:38
 */
public class SimpleSort {

    private int[] arr = new int[10];

    /**
     * 冒泡排序
     */
    @Test
    public void testBubbling() {

        arr = new int[] { 1, 2, 3, 4, 1, 2, 6, 5, 4, 5, 6, 1, 2 };
        System.out.println(Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] > arr[j - 1]) {
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
        arr = new int[] { 1, 2, 3, 4, 1, 2, 6, 5, 4, 5, 6, 1, 2 };
        System.out.println(Arrays.toString(arr));
        int out, in;
        for (out = arr.length; out > 1; out--) {
            for (in = 1; in < out; in++) {
                if (arr[in] < arr[in - 1]) {
                    int temp = arr[in - 1];
                    arr[in - 1] = arr[in];
                    arr[in] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));

    }

    /**
     * 选择排序
     */
    @Test
    public void testChoice() {
        arr = new int[] { 1, 2, 3, 4, 1, 2, 6, 5, 4, 5, 6, 1, 2 };
        System.out.println(Arrays.toString(arr));
        int out, in, cur;

        for (out = 0; out < arr.length; out++) {
            for (in = out + 1, cur = out; in < arr.length; in++) {
                if (arr[cur] > arr[in]) {
                    cur = in;
                }
                swap(cur, out);
            }

        }
        System.out.println(Arrays.toString(arr));

    }

    public void swap(int one, int two) {
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
    /**
     * 插入排序
     */

    @Test
    public void testInsert() {
        arr = new int[] { 1, 2, 3, 4, 1, 2, 6, 5, 4, 5, 6, 1, 2 };
        System.out.println(Arrays.toString(arr));
        int out, in;
        for (out = 1; out < arr.length; out++) {
            in = out;
            int temp = arr[out];
            while (in > 0 && arr[in - 1] > temp) {
                arr[in] = arr[in - 1];
                in--;
            }
            if (in != out) {
                arr[in] = temp;
            }

        }
        System.out.println(Arrays.toString(arr));

    }
}
