package com.example.arithmetic.track;

import org.junit.Test;

public class EnglishChar {

    int   cnt = 1;

    int[] array;

    public boolean check(int a1, int a2) {
        if (a1 + a2 * 10 > 26) {
            return false;
        }
        System.out.println("----" + (a1 + a2 * 10));
        return true;
    }

    public int count() {

        if (array.length == 0) {
            return 0;
        }
        if (array.length == 1) {

            return 1;
        }

        for (int x = array.length - 1; x > 0; x--) {
            if (check(array[x], array[x - 1])) {
                cnt++;
            }
        }

        return cnt;
    }

    @Test
    public void test() {
        cnt = 1;
        array = new int[] { 1, 2 };
        count();
        System.out.println(cnt);
        cnt = 1;
        array = new int[] { 1, 2, 3 };
        count();
        System.out.println(cnt);
        cnt = 1;
        array = new int[] { 1, 2, 3, 4, 5 };
        count();
        System.out.println(cnt);

        cnt = 1;
        array = new int[] { 1, 2, 3, 1, 2, 1, 5 };
        count();
        System.out.println(cnt);
    }
}
