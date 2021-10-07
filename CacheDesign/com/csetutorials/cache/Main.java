package com.csetutorials.cache;

public class Main {
	
	public static void main(String[] args) {
		Cache<Integer, Integer> cache = new LFUCache<>(4);
		cache.put(1, 1);
		cache.put(2, 1);
		cache.put(1, 1);
		cache.put(3, 1);
		cache.put(2, 1);
		cache.put(4, 1);
		cache.put(5, 1);
		cache.print();
	}

}
