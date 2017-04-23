package com.example.map;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 类ThreadMap.java的实现描述：TODO 类实现描述
 * 
 * @author xupeng 2017年4月11日 下午2:38:53
 */
public class ThreadMap {

    public static void main(String[] args) {

        Map<String,String> map = new HashMap<>();
        Map synchronizedMap = Collections.synchronizedMap(map);
    }
}
