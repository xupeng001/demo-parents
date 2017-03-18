package com.example.list;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

public class RetainAll {

    private List<Integer> list1 = Lists.newArrayList();
    private List<Integer> list2 = Lists.newArrayList();
    private List<Integer> list3 = Lists.newArrayList();

    {
        list1.add(1);
        list1.add(2);
        list1.add(3);

        list2.add(4);
        list2.add(2);
        list2.add(3);

        list3.add(5);
        list3.add(2);
        list3.add(1);
    }

    /**
     * 
     */
    @Test
    public void testRetainAll() {

        Set<Integer> list = Sets.newHashSet();
        list.addAll(list1);
        list.retainAll(list2);
        list.retainAll(list3);
        for (Integer integer : list) {
            System.out.println(integer);
        }

    }
}
