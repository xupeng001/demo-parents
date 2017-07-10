package com.example.genericity;

import java.util.ArrayList;
import java.util.List;

public class FunctionBuild {

    static <E> E reduce(List<E> list, Function<E> f, E initVal) {
        List<E> snapShot;
        synchronized (list) {
            snapShot = new ArrayList<E>(list);
        }
        E result = initVal;
        for (E e : snapShot) {
            result = f.apply(result, e);
        }
        return result;
    }

    /**
     * 不推荐
     * 
     * @param list
     * @param f
     * @param initVal
     * @return
     */
    @SuppressWarnings("unchecked")
    static <E> E reduce1(List<E> list, Function<E> f, E initVal) {
        E[] snapShot = (E[]) list.toArray();
        E result = initVal;
        for (E e : snapShot) {
            result = f.apply(result, e);
        }
        return result;
    }
}
