package com.csetutorials.cache;

public class LFUCache<Key, Value> extends Cache<Key, Value> {

	public LFUCache(int capacity) {
		super(new HashMapStorage<>(capacity), new LFUEvictionPolicy<Key>());
	}
	
}
