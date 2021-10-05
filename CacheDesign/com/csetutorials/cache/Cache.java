package com.csetutorials.cache;

public class Cache<Key, Value> {

	private final Storage<Key, Value> storage;

	private final EvictionPolicy<Key> evictionPolicy;

	public Cache(Storage<Key, Value> storage, EvictionPolicy<Key> evictionPolicy) {
		this.storage = storage;
		this.evictionPolicy = evictionPolicy;
	}

	public void put(Key key, Value value) {
		try {
			this.storage.put(key, value);
			this.evictionPolicy.access(key);
		} catch (StorageFullException e) {
			Key keyToEvict = this.evictionPolicy.evict();
			this.storage.remove(keyToEvict);
			put(key, value);
		}
	} 

	public Value get(Key key) {
		try {
			Value value = this.storage.get(key);
			this.evictionPolicy.access(key);
			return value;
		} catch (NotFoundException e) {
			return null;
		}
	}

	public void remove(Key key) {
		this.storage.remove(key);
		this.evictionPolicy.remove(key);
	}

	public void print() {
		this.storage.print();
	}
	
}
