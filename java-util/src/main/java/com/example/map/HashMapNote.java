package com.example.map;

import java.util.HashMap;
import java.util.Map;


public class HashMapNote {

	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();

		String put = map.put("key", "value");
		System.out.println(put);
		put = map.put("key", "value");
        System.out.println(put);
		String string = map.get("key");
		System.out.println(string);
	}
}
