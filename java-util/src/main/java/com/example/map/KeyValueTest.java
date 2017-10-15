package com.example.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.BiConsumer;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class KeyValueTest {

    public static void main(String[] args) {

        Map<String, String> map = new HashMap<String, String>();
        map.put("a", "a");
        map.put("b", "b");
        map.forEach(new BiConsumer<String, String>() {

            @Override
            public void accept(String t, String u) {

                System.out.println(t + ":" + u);
            }
        });
        Set<String> set = new HashSet<String>();
        System.out.println(set.add("a"));
        System.out.println(set.add("a"));
        set.add("a");
        System.out.println(set.size());
        System.out.println(Math.random());
        System.out.println(ThreadLocalRandom.current().nextInt());

        map = new HashMap<String, String>();
        map.put(null, "a");
        System.out.println(map.get(null));

        map = new TreeMap<String, String>();
        map.put("a", null);
        map.put(null, "a");
        System.out.println(map.get(null));
        map = new Hashtable<String, String>();
        map.put("a", null);
        System.out.println(map.get(null));

    }
}
