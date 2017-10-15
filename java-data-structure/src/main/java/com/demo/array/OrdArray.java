package com.demo.array;

/**
 * 类OrdArray.java的实现描述：有序的数组
 * 
 * @author xupeng 2017年9月11日 上午10:20:55
 */
public class OrdArray {

    private long[] arr;

    private int    size;

    public OrdArray(int max) {
        size = 0;
        arr = new long[max];
    }

    public int getSize() {
        return size;
    }

    /**
     * 插入数据
     * 
     * @param value
     */
    public void insert(long value) {
        if (size >= arr.length) {
            throw new ArrayIndexOutOfBoundsException();
        }
        int j;
        for (j = 0; j < size; j++) {
            if (arr[j] > value) {
                break;
            }
        }
        for (int k = size; k > j; k--) {
            arr[k] = arr[k - 1];
        }
        arr[j] = value;
        size++;
    }

    public int find(long searchKey) {
        int lowerBound = 0;
        int upperBound = size - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (arr[curIn] == searchKey) {
                return curIn;
            }
            /**
             * 没有找到,返回指定值
             */
            if (lowerBound > upperBound) {
                return size;
            }

            /**
             * 在后一半查询
             */
            if (arr[curIn] < searchKey) {
                lowerBound = curIn + 1;
            }
            /**
             * 在前一半查询
             */
            if (arr[curIn] > searchKey) {
                upperBound = curIn - 1;
            }

        }

    }

    public boolean delete(long value) {
        int j = find(value);
        if (j == size) {
            return false;
        }
        for (int k = j; j < size; j++) {
            arr[k] = arr[k + 1];
        }
        size--;
        return true;
    }

    /**
     * 显示所有数据
     */
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + "   ");
        }
        System.out.println("");
    }

    /**
     * 先增后减数组获取峰值
     * 
     * @return
     */

    public int findHight() {
        //        arr = new long[] { 1, 2, 3, 4, 6, 5, 4, 3, 2, 1 };
        arr = new long[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int lowerBound = 0;
        int upperBound = arr.length - 1;
        int curIn;
        while (true) {
            curIn = (lowerBound + upperBound) / 2;
            if (curIn >= arr.length - 1) {
                return -1;
            }
            /**
             * 比前后数据都大，得到最终索引
             */
            if (arr[curIn] > arr[curIn - 1] && arr[curIn] > arr[curIn + 1]) {
                return curIn;
            }
            /**
             * 没有找到,返回指定值
             */
            if (lowerBound > upperBound) {
                return size;
            }

            /**
             * 大于前一个小于后一个，处于增区间,取后半截数组
             */
            if (arr[curIn] > arr[curIn - 1] && arr[curIn] < arr[curIn + 1]) {
                lowerBound = curIn + 1;
            }
            /**
             * 大于后一个，小于前一个处于减区间，取前半截数组
             */
            if (arr[curIn] < arr[curIn - 1] && arr[curIn] > arr[curIn + 1]) {
                upperBound = curIn - 1;
            }

        }

    }
}
