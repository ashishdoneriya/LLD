package com.csetutorials.cache;

import java.util.HashMap;
import java.util.Map;

public class HashMapStorage<Key, Value> implements Storage<Key, Value> {

	private final int capacity;

	private final Map<Key, Value> map;

	public HashMapStorage(int capacity) {
		this.capacity = capacity;
		this.map = new HashMap<>(capacity);
	}

	@Override
	public void put(Key key, Value value) throws StorageFullException {
		if (this.map.size() == this.capacity) {
			throw new StorageFullException();
		}
		this.map.put(key, value);
	}

	@Override
	public Value get(Key key) throws NotFoundException {
		if (!this.map.containsKey(key)) {
			throw new NotFoundException(key + " not found in storage");
		}
		return this.map.get(key);
	}

	@Override
	public void remove(Key key) {
		this.map.remove(key);
	}

	@Override
	public void print() {
		this.map.forEach((k,v)-> System.out.println(k + " = " + v));
	}
	
}
