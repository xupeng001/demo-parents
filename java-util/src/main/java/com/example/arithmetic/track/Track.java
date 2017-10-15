package com.example.arithmetic.track;

import org.junit.Test;

public class Track {

    private int[]     array = new int[10];
    private boolean[] used  = new boolean[] { false, false, false, false, false, false, false, false, false, false };
    private int       cnt   = 0;
    private int       total = 0;

    private boolean Judge() {
        int sum1, sum2, sum3;
        sum1 = sum2 = sum3 = 0;
        for (int i = 1; i <= 4; i++)
            sum1 += array[i];
        for (int i = 4; i <= 7; i++)
            sum2 += array[i];
        for (int i = 7; i <= 9; i++)
            sum3 += array[i];
        sum3 += array[1];

        if (sum1 == sum2 && sum2 == sum3)
            return true;
        return false;
    }

    private void backtrack(int k, int n) {
        total++;
        System.out.println("k : " + k + " n: " + n + " total :" + total);
        if (k == n) {
            if (Judge()) {
                cnt++;
                System.out.print(String.format("find one!  count=%d\n", cnt));
                System.out.print(String.format("第一条边为：%d-%d-%d-%d\n", array[1], array[2], array[3], array[4]));
                System.out.print(String.format("第二条边为：%d-%d-%d-%d\n", array[4], array[5], array[6], array[7]));
                System.out.print(String.format("第三条边为：%d-%d-%d-%d\n", array[1], array[7], array[8], array[9]));
                System.out.print("\n");
            }
            return;
        }
        for (int i = 1; i < n; i++) {
            if (!used[i]) {
                used[i] = true;

                array[k] = i;
                backtrack(k + 1, n);
                used[i] = false;
            }
        }
    }

//    @Test
    public void test() {
        backtrack(1, 10);
        System.out.println("over");
        System.out.println(total);
    }

    //    @Test
    //    public void test1() {
    //        for (int i = 1; i < 10; i++) {
    //            array[i] = i;
    //        }
    //        for (int x = 1; x < 10; x++) {
    //            change(x);
    //        }
    //        System.out.println(cnt);
    //    }
    //
    //    private void change(int x) {
    //        for (int i = 1; i < 10; i++) {
    //            if (array[x] != i) {
    //                int temp = array[x];
    //                array[x] = array[i];
    //                array[i] = temp;
    //            }
    //            if (Judge()) {
    //                cnt++;
    //            }
    //        }
    //    }

}
