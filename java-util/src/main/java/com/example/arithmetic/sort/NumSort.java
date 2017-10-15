package com.example.arithmetic.sort;

import java.util.Arrays;

import org.junit.Test;

public class NumSort {

    int[] array = new int[] { 3, 1, 9, 0, 5, 0, 4, 6, 0, 8, 0, 5, 9, 7, 1, 1, 1, 1, 1, 3, 1, 9, 0, 5, 0, 4, 6, 0, 8, 0,
            5, 9, 7, 1, 1, 1, 1, 1, 3, 1, 9, 0, 5, 0, 4, 6, 0, 8, 0, 5, 9, 7, 1, 1, 1, 1, 1, 3, 1, 9, 0, 5, 0, 4, 6, 0,
            8, 0, 5, 9, 7, 1, 1, 1, 1, 1 };

    int   mr    = 0;

    @Test
    public void test() {
        int[] temp = new int[array.length];
        int x = 0;
        int j = temp.length - 1;
        for (int i = 0; i < array.length; i++) {
            if (array[i] > 0) {
                temp[x] = array[i];
                x++;
            } else {
                temp[j] = array[i];
                j--;
            }
        }
        System.out.println(x);
        System.err.println(j);
        System.out.println(Arrays.toString(temp));
        int[] array2 = getArray(temp, 0, x);
        int[] array3 = getArray(temp, x, temp.length);
        int[] mergeSort = mergeSort(array2);
        int[] append = append(mergeSort, array3);
        System.out.println(Arrays.toString(append));
        System.out.println(mr);
    }

    /**
     * @param array
     * @return
     */
    public int[] mergeSort(int[] array) {
        if (array.length > 1) {
            int[] array1 = getArray(array, 0, array.length / 2);
            int[] array2 = getArray(array, array.length / 2, array.length);
            int[] mergeSort = mergeSort(array1);
            int[] mergeSort2 = mergeSort(array2);
            int[] merge = merge(mergeSort, mergeSort2);
            return merge;
        } else {
            return array;
        }

    }

    public int[] merge(int[] x, int[] y) {
        mr++;
        if (x.length == 0) {
            return y;
        }
        if (y.length == 0) {
            return x;
        }
        if (x[0] <= y[0]) {
            int[] array2 = getArray(x, 1, x.length);
            int[] merge = merge(array2, y);
            int[] append = append(x[0], merge);
            return append;
        } else {
            int[] array2 = getArray(y, 1, y.length);
            int[] merge = merge(array2, x);
            int[] append = append(y[0], merge);
            return append;
        }
    }

    public int[] append(int x, int[] y) {
        int[] temp = new int[y.length + 1];
        temp[0] = x;
        for (int i = 1; i < temp.length; i++) {
            temp[i] = y[i - 1];
        }
        return temp;
    }

    public int[] append(int[] x, int[] y) {
        int[] temp = new int[y.length + x.length];

        for (int i = 0; i < temp.length; i++) {
            if (i < x.length) {
                temp[i] = x[i];
            } else {
                temp[i] = y[i - x.length];
            }
        }
        return temp;
    }

    public int[] remove(int[] y) {
        int[] temp = new int[y.length - 1];
        for (int x = 0; x < temp.length; x++) {
            temp[x] = y[x + 1];
        }
        return temp;
    }

    public int[] getArray(int[] array, int start, int end) {
        int[] temp = new int[end - start];
        int i = 0;
        for (int x = start; x < end; x++, i++) {
            temp[i] = array[x];
        }
        return temp;
    }
}
