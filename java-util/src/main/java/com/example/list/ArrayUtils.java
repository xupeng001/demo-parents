package com.example.list;

import java.util.Arrays;

/**
 * 类ArrayUtils.java的实现描述：TODO 类实现描述 
 * @author xupeng 2017年3月16日 下午12:03:29
 */
@SuppressWarnings("unchecked")
public class ArrayUtils {

    public static <T> T[] concat1(T[] a, T[] b) {
        final int alen = a.length;
        final int blen = b.length;
        if (alen == 0) {
            return b;
        }
        if (blen == 0) {
            return a;
        }
        final T[] result = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), alen + blen);
        System.arraycopy(a, 0, result, 0, alen);
        System.arraycopy(b, 0, result, alen, blen);
        return result;
    }

    public static <T> T[] concat2(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
}
