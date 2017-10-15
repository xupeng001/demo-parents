package com.demo.tree;

import org.junit.Test;

public class Demo {

    @Test
    public void test() {

        int[] arr = new int[] { 1, 2, 3, 4, 5, 8, 7, 6, 5, 4, 3 };

        //        for(int x=0;x<arr.length;x++){
        //            
        //        }

        int low = 0;
        int higth = arr.length;
        while (true) {
            int mid = (low + higth) / 2;
            if (mid == higth || mid == 0) {
                return;
            }
            if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                System.out.println(arr[mid]);
                return;
            }
            if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            }
            if (arr[mid] > arr[mid - 1] && arr[mid] < arr[mid + 1]) {
                low = mid + 1;
            }
        }
    }
}
