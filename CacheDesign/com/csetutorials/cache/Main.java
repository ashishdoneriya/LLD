package com.csetutorials.cache;

public class Main {
	
	public static void main(String[] args) {
		EvictionPolicy<String> evictionPolicy = new LRUEvictionPolicy<String>();
		Storage<String, Integer> storage = new HashMapStorage<>(3);
		Cache<String, Integer> cache = new Cache<>(storage, evictionPolicy);
		cache.put("str1", 1);
		cache.put("str2", 2);
		cache.put("str3", 3);
		cache.get("str1");
		cache.put("str4", 4);
		cache.get("str1");
		cache.get("str2");
		cache.print();
	}

}
