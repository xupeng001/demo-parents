package com.demo.array;

import org.junit.Assert;
/**
 * 通过二分法寻找指定数据的角标
 * 类FindItem.java的实现描述：TODO 类实现描述 
 * @author xupeng 2017年9月28日 上午9:48:00
 */
public class FindItem {

    public static void main(String[] args) {
        int[] arr = new int[] { 1, 2, 3, 5, 6, 7, 8 };
        int findItem = findItem(arr, 4);
        Assert.assertEquals(findItem, -1);
        findItem = findItem(arr, 5);
        Assert.assertEquals(findItem, 3);

    }

    /**
     * @param arr递增数组
     * @param x 要查询的值
     * @return
     */
    public static int findItem(int[] arr, int x) {
        int low = 0, hight = arr.length;
        int mid = 0;
        while (low < hight) {
            mid = (low + hight) / 2;
            if (arr[mid] == x) {
                return mid;
            }
            /**
             * 在左半部分
             */
            if (arr[mid] < x) {
                low = mid + 1;
            }
            /**
             * 在又半部分
             */
            if (arr[mid] > x) {
                hight = mid - 1;
            }

        }
        System.out.println((x - arr[low]) > (arr[hight] - x) ? hight : low);
        return -1;
    }
}
