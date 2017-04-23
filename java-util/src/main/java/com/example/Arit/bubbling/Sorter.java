package com.example.Arit.bubbling;

import java.util.Comparator;

/**
 * 类Sorter.java的实现描述：排序器接口(策略模式: 将算法封装到具有共同接口的独立的类中使得它们可以相互替换)
 * 
 * @author xupeng 2017年4月11日 下午4:30:27
 */
public interface Sorter<T> {
    /**
     * 排序
     * 
     * @param list 待排序的数组
     */
    public void sort(T[] list);

    /**
     * 排序
     * 
     * @param list 待排序的数组
     * @param comp 比较两个对象的比较器
     */
    public void sort(T[] list, Comparator comp);
}
