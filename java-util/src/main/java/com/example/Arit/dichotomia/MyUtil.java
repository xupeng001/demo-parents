package com.example.Arit.dichotomia;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * 类MyUtil.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年4月11日 下午4:35:03
 */
public class MyUtil {

    public static <T extends Comparable<T>> int binarySearch(T[] x, T key) {
        return binarySearch(x, 0, x.length - 1, key);
    }

    // 使用循环实现的二分查找

    public static <T extends Comparable<T>> int binarySearch(T[] x, T key, Comparator<T> comp) {
        int low = 0;
        int high = x.length - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            int cmp = comp.compare(x[mid], key);
            if (cmp < 0) {
                low = mid + 1;
            } else if (cmp > 0) {
                high = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    // 使用递归实现的二分查找

    private static <T extends Comparable<T>> int binarySearch(T[] x, int low, int high, T key) {
        if (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (key.compareTo(x[mid]) == 0) {
                return mid;
            } else if (key.compareTo(x[mid]) < 0) {
                return binarySearch(x, low, mid - 1, key);
            } else {
                return binarySearch(x, mid + 1, high, key);
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < 100; i++) {
            list.add(i + 100);
        }
        int i = binarySearch(list.toArray(new Integer[] {}), 109);
        System.out.println(i);
        i = binarySearch(list.toArray(new Integer[] {}), 0, 99, 109);
        System.out.println(i);

    }
}
