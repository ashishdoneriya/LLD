package com.csetutorials.cache;

public class LRUCache<Key, Value> extends Cache<Key, Value> {

	public LRUCache(int capacity) {
		super(new HashMapStorage<>(capacity), new LRUEvictionPolicy<Key>());
	}
	
}
